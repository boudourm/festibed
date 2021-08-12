package model;
import java.util.*;

public class Client extends Utilisateur {

	//Associations
    public List<Reservation> reservations;
    public Map<Festival,NoteFestival> notesParFestival;
    public Map<Hebergement,NoteHebergement> notesParHebergements ;
    
    //Constructors
    public Client(List<Reservation> reservations, Map<Festival, NoteFestival> notesParFestival,
			Map<Hebergement, NoteHebergement> notesParHebergements) {
		super();
		this.reservations = reservations;
		this.notesParFestival = notesParFestival;
		this.notesParHebergements = notesParHebergements;
	}
    
    public Client() {
	}

	//Getters & Setters
	/**
	 * @return the rservations
	 */
	public List<Reservation> getRservations() {
		return reservations;
	}
	/**
	 * @param rservations the rservations to set
	 */
	public void setRservations(List<Reservation> rservations) {
		this.reservations = rservations;
	}

	/**
	 * @return the notesParFestival
	 */
	public Map<Festival, NoteFestival> getNotesParFestival() {
		return notesParFestival;
	}

	/**
	 * @param notesParFestival the notesParFestival to set
	 */
	public void setNotesParFestival(Map<Festival, NoteFestival> notesParFestival) {
		this.notesParFestival = notesParFestival;
	}

	/**
	 * @return the notesParHebergements
	 */
	public Map<Hebergement, NoteHebergement> getNotesParHebergements() {
		return notesParHebergements;
	}

	/**
	 * @param notesParHebergements the notesParHebergements to set
	 */
	public void setNotesParHebergements(Map<Hebergement, NoteHebergement> notesParHebergements) {
		this.notesParHebergements = notesParHebergements;
	}
	
	//Association Methods
	public boolean addReservation(Reservation reservation) {
		return this.reservations.add(reservation);
	}
	public boolean removeReservation(Reservation reservation) {
		return this.reservations.remove(reservation);
	}
	public NoteFestival rateFastival(Festival festival, Integer note) {
		return this.notesParFestival.put(festival, new NoteFestival(note));
	}
	public NoteHebergement rateHebergement(Hebergement hebergement, Integer note) {
		return this.notesParHebergements.put(hebergement, new NoteHebergement(note));
	}
	public NoteFestival updateRateFastival(Festival festival, Integer note) {
		return this.notesParFestival.replace(festival, new NoteFestival(note));
	}
	public NoteHebergement updateRate(Hebergement hebergement, Integer note) {
		return this.notesParHebergements.replace(hebergement, new NoteHebergement(note));
	}

	//Methods

	}	
    
	
    