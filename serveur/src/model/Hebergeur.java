package model;
import java.util.List;

public class Hebergeur extends Utilisateur {
	//Associations
	public List<Hebergement> hebergements;
	//Constructors

	public Hebergeur(List<Hebergement> hebergements) {
		super();
		this.hebergements = hebergements;
	}
	//Getters & Setters

	public Hebergeur() {
		super();
	}

	public Hebergeur(Integer idUtilisateur, String nomUtilisateur, String prenomUtilisateur, String emailUtilisateur,
			String motDePasseUtilisateur, String idFireBase) {
		super(idUtilisateur, nomUtilisateur, prenomUtilisateur, emailUtilisateur, motDePasseUtilisateur, idFireBase);
	}

	/**
	 * @return the hebergements
	 */
	public List<Hebergement> getHebergements() {
		return hebergements;
	}

	/**
	 * @param hebergements the hebergements to set
	 */
	public void setHebergements(List<Hebergement> hebergements) {
		this.hebergements = hebergements;
	}
	//Methods

	@Override
	public String toString() {
		return "Hebergeur ["+super.toString()+",hebergements=" + hebergements + "]";
	}
	
	
}