package model;
import java.util.*;

public class Organisateur extends Utilisateur {
	//Associations
    public List<Festival>  festivals;
    //Getters & Setters
	/**
	 * @return the festivals
	 */
	public List<Festival> getFestivals() {
		return festivals;
	}

	/**
	 * @param festivals the festivals to set
	 */
	public void setFestivals(List<Festival> festivals) {
		this.festivals = festivals;
	}
    //Associations Methods
	public boolean addFestival(Festival festival) {
		return this.festivals.add(festival);
	}
	public boolean removeFestival(Festival festival) {
		return this.festivals.remove(festival);
	}
	//Methods

	@Override
	public String toString() {
		return "Organisateur [festivals=" + festivals + "]";
	}
	
}