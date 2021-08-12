package model;

public class ChambreHotel extends Logement {

	//Attributs
	private double tarifEnfant;
	private double tarifAdulte;

	//Associations
	private Hotel hotel;
	
	//Constructor
	public ChambreHotel(){
		super();
	}
	public ChambreHotel(double tarifEnfant, double tarifAdulte , Hotel hotel) {
		super();
		this.tarifAdulte=tarifAdulte;
		this.tarifEnfant=tarifEnfant;
		this.hotel=hotel;
	}
	
	//Guetters & setters
	
	

}