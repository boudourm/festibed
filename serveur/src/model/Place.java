package model;
import java.time.LocalDate;
import java.util.Map;

public class Place {
    //Attributes
	private Integer idPlace;
    private Integer nbPlaceDispo;
    private Float prixPlace;
    private Integer categoriePlace;
    private LocalDate dateSoiree;
    //Associations
    private Festival festival;
    private Map<Reservation,ReservationPlace> placesReserveesParResevation;
    //Constructors
	public Place() {
		super();
	}
    public Place(Integer idPlace, Integer nbPlaceDispo, Float prixPlace, Integer categoriePlace, LocalDate dateSoiree,
			Festival festival, Map<Reservation, ReservationPlace> placesReserveesParResevation) {
		super();
		this.idPlace = idPlace;
		this.nbPlaceDispo = nbPlaceDispo;
		this.prixPlace = prixPlace;
		this.categoriePlace = categoriePlace;
		this.dateSoiree = dateSoiree;
		this.festival = festival;
		this.placesReserveesParResevation = placesReserveesParResevation;
	}
	//Getters & setters 
    
	/**
	 * @return the idPlace
	 */
	public Integer getIdPlace() {
		return idPlace;
	}
	/**
	 * @return the placesReserveesParResevation
	 */
	public Map<Reservation, ReservationPlace> getPlacesReserveesParResevation() {
		return placesReserveesParResevation;
	}
	/**
	 * @param placesReserveesParResevation the placesReserveesParResevation to set
	 */
	public void setPlacesReserveesParResevation(Map<Reservation, ReservationPlace> placesReserveesParResevation) {
		this.placesReserveesParResevation = placesReserveesParResevation;
	}
	/**
	 * @param idPlace the idPlace to set
	 */
	public void setIdPlace(Integer idPlace) {
		this.idPlace = idPlace;
	}
	/**
	 * @return the nbPlaceDispo
	 */
	public Integer getNbPlaceDispo() {
		return nbPlaceDispo;
	}
	/**
	 * @param nbPlaceDispo the nbPlaceDispo to set
	 */
	public void setNbPlaceDispo(Integer nbPlaceDispo) {
		this.nbPlaceDispo = nbPlaceDispo;
	}
	/**
	 * @return the prixPlace
	 */
	public Float getPrixPlace() {
		return prixPlace;
	}
	/**
	 * @param prixPlace the prixPlace to set
	 */
	public void setPrixPlace(Float prixPlace) {
		this.prixPlace = prixPlace;
	}
	/**
	 * @return the categoriePlace
	 */
	public Integer getCategoriePlace() {
		return categoriePlace;
	}
	/**
	 * @param categoriePlace the categoriePlace to set
	 */
	public void setCategoriePlace(Integer categoriePlace) {
		this.categoriePlace = categoriePlace;
	}
	/**
	 * @return the dateSoiree
	 */
	public LocalDate getDateSoiree() {
		return dateSoiree;
	}
	/**
	 * @param dateSoiree the dateSoiree to set
	 */
	public void setDateSoiree(LocalDate dateSoiree) {
		this.dateSoiree = dateSoiree;
	}
	/**
	 * @return the festival
	 */
	public Festival getFestival() {
		return festival;
	}
	/**
	 * @param festival the festival to set
	 */
	public void setFestival(Festival festival) {
		this.festival = festival;
	}
	/**
	 * @return the reservations
	 */
	//Associations Methods
	public ReservationPlace enregistrerPlaceReservee(Reservation reservation, ReservationPlace reservationPlace) {
		return this.placesReserveesParResevation.put(reservation, reservationPlace);
	}
	public ReservationPlace retirerPlaceReservee(Reservation reservation) {
		return this.placesReserveesParResevation.remove(reservation);
	}
	public ReservationPlace updatePlaceReservee(Reservation reservation, ReservationPlace reservationPlace) {
		return this.placesReserveesParResevation.replace(reservation, reservationPlace);
	}
	
    
}