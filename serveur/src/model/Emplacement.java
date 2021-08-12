package model;
import java.util.*;

public class Emplacement extends Logement {
	//Attributes
	private String etatDispo;
	//Associations
    public Camping camping;
    //Constructors
	public Emplacement(Integer idLogement, Map<Reservation, Nuitee> nuiteeParReservation, List<Dates> datesDispo,
			String etatDispo, Camping camping) {
		super(idLogement, nuiteeParReservation, datesDispo);
		this.etatDispo = etatDispo;
		this.camping = camping;
	}
	public Emplacement(Integer idLogement, Map<Reservation, Nuitee> nuiteeParReservation, List<Dates> datesDispo) {
		super(idLogement, nuiteeParReservation, datesDispo);
	}
    //Getters & Setters
	/**
	 * @return the etatDispo
	 */
	public String getEtatDispo() {
		return etatDispo;
	}
	/**
	 * @param etatDispo the etatDispo to set
	 */
	public void setEtatDispo(String etatDispo) {
		this.etatDispo = etatDispo;
	}
	/**
	 * @return the camping
	 */
	public Camping getCamping() {
		return camping;
	}
	/**
	 * @param camping the camping to set
	 */
	public void setCamping(Camping camping) {
		this.camping = camping;
	}
	//Methods
	@Override
	public String toString() {
		return "Emplacement [etatDispo=" + etatDispo + ", camping=" + camping + "]";
	}
	
}