package model;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Logement {

	//Attributes
	private Integer idLogement;

	//Associations
    public Map<Reservation,Nuitee> nuiteeParReservation;
    public List<Dates> datesDispo;
    //Contructors
	public Logement(Integer idLogement, Map<Reservation, Nuitee> nuiteeParReservation, List<Dates> datesDispo) {
		super();
		this.idLogement = idLogement;
		this.nuiteeParReservation = nuiteeParReservation;
		this.datesDispo = datesDispo;
	}
	public Logement() {
		super();
	}
	//Getters & Setters
	/**
	 * @return the idLogement
	 */
	public Integer getIdLogement() {
		return idLogement;
	}
	/**
	 * @param idLogement the idLogement to set
	 */
	public void setIdLogement(Integer idLogement) {
		this.idLogement = idLogement;
	}
	/**
	 * @return the nuiteeParReservation
	 */
	public Map<Reservation, Nuitee> getNuiteeParReservation() {
		return nuiteeParReservation;
	}
	/**
	 * @param nuiteeParReservation the nuiteeParReservation to set
	 */
	public void setNuiteeParReservation(Map<Reservation, Nuitee> nuiteeParReservation) {
		this.nuiteeParReservation = nuiteeParReservation;
	}
	/**
	 * @return the datesDispo
	 */
	public List<Dates> getDatesDispo() {
		return datesDispo;
	}
	/**
	 * @param datesDispo the datesDispo to set
	 */
	public void setDatesDispo(List<Dates> datesDispo) {
		this.datesDispo = datesDispo;
	}
	//Association Methods
	public Nuitee saveNuitte(Reservation reservation , Nuitee nuitee) {
		return this.nuiteeParReservation.put(reservation, nuitee);
	}
	public Nuitee updateNuitte(Reservation reservation , Nuitee nuitee) {
		return this.nuiteeParReservation.replace(reservation, nuitee);
	}
	public Nuitee cancelReservation(Reservation reservation ) {
		return this.nuiteeParReservation.remove(reservation);
	}
	public boolean addDate(LocalDate date) {
		return this.datesDispo.add(new Dates(date));
	}
	
	public boolean removeDate(LocalDate date) {
		return this.datesDispo.remove(new Dates(date));
	}
	
	//Methods
	@Override
	public String toString() {
		return "Logement [idLogement=" + idLogement + ", nuiteeParReservation=" + nuiteeParReservation + ", datesDispo="
				+ datesDispo + "]";
	}
    
    

}