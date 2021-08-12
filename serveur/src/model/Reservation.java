package model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

public class Reservation {
	//Attributes
	private Integer idReservaion;
    private Float prixTotal;
    private LocalDate dateReservation;
    private String infosModePayement;
    private String objetPaiement;
    //Associations
    public Client client;
    private Map<Logement,Nuitee> nuiteesParLogement;
    private Map<Place,ReservationPlace> placesReserveesParPlace;
    public Ramboursement ramboursement;
    //Constructors

	public Reservation() {
		super();
	}

	public Reservation(Integer idReservaion, Float prixTotal, LocalDate dateReservation, String infosModePayement,
			String objetPaiement, Client client, Map<Logement, Nuitee> nuiteesParLogement,
			Map<Place, ReservationPlace> placesReserveesParPlace, Ramboursement ramboursement) {
		super();
		this.idReservaion = idReservaion;
		this.prixTotal = prixTotal;
		this.dateReservation = dateReservation;
		this.infosModePayement = infosModePayement;
		this.objetPaiement = objetPaiement;
		this.client = client;
		this.nuiteesParLogement = nuiteesParLogement;
		this.placesReserveesParPlace = placesReserveesParPlace;
		this.ramboursement = ramboursement;
	}

	//Getters & Setters
	
	
	/**
	 * @return the idReservaion
	 */
	public Integer getIdReservaion() {
		return idReservaion;
	}
	/**
	 * @return the placesReserveesParPlace
	 */
	public Map<Place, ReservationPlace> getPlacesReserveesParPlace() {
		return placesReserveesParPlace;
	}

	/**
	 * @param placesReserveesParPlace the placesReserveesParPlace to set
	 */
	public void setPlacesReserveesParPlace(Map<Place, ReservationPlace> placesReserveesParPlace) {
		this.placesReserveesParPlace = placesReserveesParPlace;
	}

	/**
	 * @param idReservaion the idReservaion to set
	 */
	public void setIdReservaion(Integer idReservaion) {
		this.idReservaion = idReservaion;
	}
	/**
	 * @return the prixTotal
	 */
	public Float getPrixTotal() {
		return prixTotal;
	}
	/**
	 * @param prixTotal the prixTotal to set
	 */
	public void setPrixTotal(Float prixTotal) {
		this.prixTotal = prixTotal;
	}
	/**
	 * @return the dateReservation
	 */
	public LocalDate getDateReservation() {
		return dateReservation;
	}
	/**
	 * @param dateReservation the dateReservation to set
	 */
	public void setDateReservation(LocalDate dateReservation) {
		this.dateReservation = dateReservation;
	}
	/**
	 * @return the infosModePayement
	 */
	public String getInfosModePayement() {
		return infosModePayement;
	}
	/**
	 * @param infosModePayement the infosModePayement to set
	 */
	public void setInfosModePayement(String infosModePayement) {
		this.infosModePayement = infosModePayement;
	}
	/**
	 * @return the objetPaiement
	 */
	public String getObjetPaiement() {
		return objetPaiement;
	}
	/**
	 * @param objetPaiement the objetPaiement to set
	 */
	public void setObjetPaiement(String objetPaiement) {
		this.objetPaiement = objetPaiement;
	}
	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}
	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @return the nuiteesParLogement
	 */
	public Map<Logement, Nuitee> getNuiteesParLogement() {
		return nuiteesParLogement;
	}
	/**
	 * @param nuiteesParLogement the nuiteesParLogement to set
	 */
	public void setNuiteesParLogement(Map<Logement, Nuitee> nuiteesParLogement) {
		this.nuiteesParLogement = nuiteesParLogement;
	}
	/**
	 * @return the ramboursement
	 */
	public Ramboursement getRamboursement() {
		return ramboursement;
	}
	/**
	 * @param ramboursement the ramboursement to set
	 */
	public void setRamboursement(Ramboursement ramboursement) {
		this.ramboursement = ramboursement;
	}
	//Associations Methods
	public Nuitee reserverLogement(Logement logement, Nuitee nuitee) {
		return this.nuiteesParLogement.put(logement, nuitee);
	}
	public Nuitee retirerLogement(Logement logement) {
		return this.nuiteesParLogement.remove(logement);
	}
	public Nuitee updateNuitee(Logement logement, Nuitee nuitee) {
		return this.nuiteesParLogement.replace(logement, nuitee);
	}	
	public ReservationPlace reserverPlaceFestival(Place place, ReservationPlace reservationPlace) {
		return this.placesReserveesParPlace.put(place, reservationPlace);
	}
	public ReservationPlace retirerPlaceFestival(Place place) {
		return this.placesReserveesParPlace.remove(place);
	}
	public ReservationPlace updateReservationPlace(Place place, ReservationPlace reservationPlace) {
		return this.placesReserveesParPlace.replace(place, reservationPlace);
	}
	//Methods
	public Integer getNbPlacesReserveesByFestival(Festival festival)
	{
		ArrayList<Place> places = new ArrayList<Place>();
		Object[] a  = null;
		a  = this.getPlacesReserveesParPlace().keySet().toArray();
		for (Object place : a) {
			Place p = ((Place) place);
			if(p.getFestival().getNumeroIdentification().contentEquals(festival.getNumeroIdentification()))
				places.add(p);
		}	
		Integer nbtotal = 0;
		for (Place p : places) 
		{
			nbtotal = nbtotal + this.getPlacesReserveesParPlace().get(p).getNbPlacesReservee();
		}		
		return nbtotal;
	}
	
	public Float getPrixPlacesReserveesByFestival(Festival festival)
	{
		ArrayList<Place> places = new ArrayList<Place>();
		Object[] a  = null;
		a  = this.getPlacesReserveesParPlace().keySet().toArray();
		for (Object place : a) {
			Place p = ((Place) place);
			if(p.getFestival().getNumeroIdentification().contentEquals(festival.getNumeroIdentification()))
				places.add(p);
		}	
		Float prixtotal = (float)0;
		for (Place p : places) 
		{
			prixtotal = prixtotal + this.getPlacesReserveesParPlace().get(p).getNbPlacesReservee()*p.getPrixPlace();
		}		
		return prixtotal;
	}
	
	@Override
	public String toString() {
		return "Reservation [idReservaion=" + idReservaion + ", prixTotal=" + prixTotal + ", dateReservation="
				+ dateReservation + ", infosModePayement=" + infosModePayement + ", objetPaiement=" + objetPaiement
				+ ", client=" + client + ", nuiteesParLogement=" + nuiteesParLogement + ", placesReserveesParPlace="
				+ placesReserveesParPlace + ", ramboursement=" + ramboursement + "]";
	}

	
}