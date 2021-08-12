package model;
import java.util.*;

public class ChambreDHotel extends Logement {
	//Attributes
	private Float tarifenfant;
    private Float tarifAdulte;
    //Associations
    public Hotel hotel;

    //Constructor
	public ChambreDHotel() {
		super();
	}

	public ChambreDHotel(Float tarifenfant, Float tarifAdulte, Hotel hotel) {
		super();
		this.tarifenfant = tarifenfant;
		this.tarifAdulte = tarifAdulte;
		this.hotel = hotel;
	}
	
	//Getters & Setters

	public Float getTarifenfant() {
		return tarifenfant;
	}
	public void setTarifenfant(Float tarifenfant) {
		this.tarifenfant = tarifenfant;
	}
	public Float getTarifAdulte() {
		return tarifAdulte;
	}
	public void setTarifAdulte(Float tarifAdulte) {
		this.tarifAdulte = tarifAdulte;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	//Methods
	@Override
	public String toString() {
		return "ChambreDHotel [tarifenfant=" + tarifenfant + ", tarifAdulte=" + tarifAdulte + ", hotel=" + hotel + "]";
	}
	


}