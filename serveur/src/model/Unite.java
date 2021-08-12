package model;
import java.util.*;

public class Unite extends Logement {
	//Attributes
	private Float tarifUnite;
	//Associations
	public Residence residence;
	//Constructors
	public Unite(Integer idLogement, Map<Reservation, Nuitee> nuiteeParReservation, List<Dates> datesDispo,
			Float tarifUnite) {
		super(idLogement, nuiteeParReservation, datesDispo);
		this.tarifUnite = tarifUnite;
	}
	//Getters & Setters
	/**
	 * @return the tarifUnite
	 */
	public Float getTarifUnite() {
		return tarifUnite;
	}
	/**
	 * @param tarifUnite the tarifUnite to set
	 */
	public void setTarifUnite(Float tarifUnite) {
		this.tarifUnite = tarifUnite;
	}
	/**
	 * @return the residence
	 */
	public Residence getResidence() {
		return residence;
	}
	/**
	 * @param residence the residence to set
	 */
	public void setResidence(Residence residence) {
		this.residence = residence;
	}
	//Methods
	@Override
	public String toString() {
		return "Unite [tarifUnite=" + tarifUnite + ", residence=" + residence + "]";
	}
	
}