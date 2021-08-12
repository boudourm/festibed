package model;

public class ReservationPlace {
	//Attributes 
	private Integer nbPlacesReservee ;
	//Associations
	private Place place;
	private Reservation reservation;
	
	//Constructors

	public ReservationPlace(Integer nbPlacesReservee) {
		super();
		this.nbPlacesReservee = nbPlacesReservee;
	}
	public ReservationPlace(Integer nbPlacesReservee, Place place, Reservation reservation) {
		super();
		this.nbPlacesReservee = nbPlacesReservee;
		this.place = place;
		this.reservation = reservation;
	}
	public ReservationPlace() {
		super();
	}
	//Getter & Setter
	
	/**
	 * @return the nbPlacesReservee
	 */
	public Integer getNbPlacesReservee() {
		return nbPlacesReservee;
	}
	/**
	 * @return the place
	 */
	public Place getPlace() {
		return place;
	}
	/**
	 * @param place the place to set
	 */
	public void setPlace(Place place) {
		this.place = place;
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
	/**
	 * @param nbPlacesReservee the nbPlacesReservee to set
	 */
	public void setNbPlacesReservee(Integer nbPlacesReservee) {
		this.nbPlacesReservee = nbPlacesReservee;
	}
	
}
