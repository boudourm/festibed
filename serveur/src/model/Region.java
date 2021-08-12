package model;
import java.util.*;

public class Region {
	//Attributes
    private String nomRegion;
    //Constructors

	public Region(String nomRegion) {
		super();
		this.nomRegion = nomRegion;
	}
	public Region() {
		super();
	}
    //Getters & Setters
	/**
	 * @return the nomRegion
	 */
	public String getNomRegion() {
		return nomRegion;
	}
	/**
	 * @param nomRegion the nomRegion to set
	 */
	public void setNomRegion(String nomRegion) {
		this.nomRegion = nomRegion;
	}
	//Methods
	@Override
	public String toString() {
		return "Region [nomRegion=" + nomRegion + "]";
	}
	
}