package model;


import java.util.*;

public class ChambreFamilliale extends ChambreDHotel {
	//Attributes
    private Integer capaciteAdulte;
    private Integer capaciteenfant;
  
    //Constructor
	public ChambreFamilliale() {
		super();
	}

	public ChambreFamilliale(Integer capaciteAdulte, Integer capaciteenfant) {
		super();
		this.capaciteAdulte = capaciteAdulte;
		this.capaciteenfant = capaciteenfant;
	}

	//Getters & Setters
	/**
	 * @return the capaciteAdulte
	 */
	public Integer getCapaciteAdulte() {
		return capaciteAdulte;
	}

	/**
	 * @param capaciteAdulte the capaciteAdulte to set
	 */
	public void setCapaciteAdulte(Integer capaciteAdulte) {
		this.capaciteAdulte = capaciteAdulte;
	}

	/**
	 * @return the capaciteenfant
	 */
	public Integer getCapaciteenfant() {
		return capaciteenfant;
	}

	/**
	 * @param capaciteenfant the capaciteenfant to set
	 */
	public void setCapaciteenfant(Integer capaciteenfant) {
		this.capaciteenfant = capaciteenfant;
	}
	
	//Methods
	@Override
	public String toString() {
		return "ChambreFamilliale [capaciteAdulte=" + capaciteAdulte + ", capaciteenfant=" + capaciteenfant + "]";
	}	

}