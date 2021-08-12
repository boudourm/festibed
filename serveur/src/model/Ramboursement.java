package model;
import java.time.LocalDate;

public class Ramboursement {

	//Attributes
	private Integer idRamboursement;
    private LocalDate dateRamboursement;
    //Associations
    public Reservation reservation;
    //Constructors
	public Ramboursement(Integer idRamboursement, LocalDate dateRamboursement, Reservation reservation) {
		super();
		this.idRamboursement = idRamboursement;
		this.dateRamboursement = dateRamboursement;
		this.reservation = reservation;
	}
	public Ramboursement() {
		super();
	}
    //Getters & Setters
	/**
	 * @return the idRamboursement
	 */
	public Integer getIdRamboursement() {
		return idRamboursement;
	}
	/**
	 * @param idRamboursement the idRamboursement to set
	 */
	public void setIdRamboursement(Integer idRamboursement) {
		this.idRamboursement = idRamboursement;
	}
	/**
	 * @return the dateRamboursement
	 */
	public LocalDate getDateRamboursement() {
		return dateRamboursement;
	}
	/**
	 * @param dateRamboursement the dateRamboursement to set
	 */
	public void setDateRamboursement(LocalDate dateRamboursement) {
		this.dateRamboursement = dateRamboursement;
	}
	/**
	 * @return the reservation
	 */
	public Reservation getReservation() {
		return reservation;
	}
	/**
	 * @param reservation the reservation to set
	 */
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	//Methods
	@Override
	public String toString() {
		return "Ramboursement [idRamboursement=" + idRamboursement + ", dateRamboursement=" + dateRamboursement
				+ ", reservation=" + reservation + "]";
	}
	

}