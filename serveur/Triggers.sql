---------------------------------------------------------------------
---------------------------------------------------------------------
-----------------------------Triggers--------------------------------
---------------------------------------------------------------------
---------------------------------------------------------------------


--Trigger : vérification du nombre de places d'un festival

CREATE OR REPLACE TRIGGER VERIFIER_PLACE_FESTIVAL
BEFORE INSERT ON RESERVATIONPLACE
FOR EACH ROW
DECLARE
placesDispo PLACE.NBPLACESDISPO%Type;
BEGIN
SELECT NBPLACESDISPO into placesDispo FROM PLACE WHERE PLACE.IDPLACE = :NEW.IDPLACE;
IF(placesDispo - :new.nbPlaces < 0) 
then raise_application_error(-20010,'Le nombre de places dun festival ne peut pas etre négative');
else 
UPDATE PLACE SET NBPLACESDISPO = NBPLACESDISPO - :NEW.NBPLACESRESERVEE WHERE IDPLACE = :NEW.IDPLACE;
ENDIF;
END;
/


--Trigger : MAJ après la suppression d'un festival

CREATE OR REPLACE TRIGGER MAJ_SUPPRESSION_FESTIVAL
BEFORE DELETE ON FESTIVAL
FOR EACH ROW
DECLARE
--
CURSOR C1 IS SELECT DISTINCT r.IDRESERVATION, p.IDPLACE 
FROM PLACE p, RESERVATIONPLACE rp, RESERVATION r, NUITEE n 
WHERE p.NUMEROIDENTIFICATION=:old.NUMEROIDENTIFICATION
and p.IDPLACE = rp.IDPLACE 
and r.IDRESERVATION=rp.IDRESERVATION
and n.IDRESERVATION = r.IDRESERVATION;

CURSOR C2 IS SELECT DISTINCT r.IDRESERVATION, n.IDLOGEMENT
FROM PLACE p, RESERVATIONPLACE rp, RESERVATION r, NUITEE n 
WHERE p.NUMEROIDENTIFICATION=old.NUMEROIDENTIFICATION
and p.IDPLACE = rp.IDPLACE 
and r.IDRESERVATION=rp.IDRESERVATION
and n.IDRESERVATION = r.IDRESERVATION;

plac C1%ROWTYPE;
nuitee C1%ROWTYPE;
nbFestivals number ;
BEGIN
	--Le nombre de festival liés à cette reservation

	FOR plac IN C1 LOOP
	SELECT COUNT(DISTINCT(f.NUMEROIDENTIFICATION)) INTO nbFestivals
	FROM PLACE p, RESERVATIONPLACE rp , Festival f
	WHERE plac.IDRESERVATION = rp.IDRESERVATION 
	and p.IDPLACE = rp.IDPLACE 
	and p.NUMEROIDENTIFICATION=f.NUMEROIDENTIFICATION;
	if(nbFestivals > 1 ) then
	FOR nuitee IN C2 LOOP
	DELETE FROM NUITEE 
	WHERE plac.IDRESER=nuitee.IDRESERVATION 
	and IDLOGEMENT=nuitee.IDLOGEMENT;
	END LOOP: 
	ENDIF;
	DELETE FROM PLACE WHERE IDPLACE=place.IDPLACE;
	END LOOP:
END;
/



--Trigger : MAJ apres Suppression d'un festival du panier 

CREATE OR REPLACE TRIGGER MAJ_Reservation
BEFORE DELETE ON RESERVATIONPLACE
FOR EACH ROW
DECLARE
prix number;
id number ; 
BEGIN

SELECT p.PRIXPLACE into prix FROM PLACE p 
WHERE p.IDPLACE = :old.IDPLACE;
--Mettre à jour le montant de la reservation 
UPDATE RESERVATION SET PRIXTOTAL=PRIXTOTAL - prix 
WHERE IDRESERVATION = :old.IDRESERVATION;
--Mettre à jour le nombre de place de la reservation 
UPDATE PLACE SET NBPLACESDISPO=NBPLACESDISPO + :old.NBPLACESRESERVEE 
WHERE idplace = :old.IDPLACE;
END;
/