package model;

import java.util.*;

public class Camping extends Hebergement {
	//Attributes
	private Float tarifemplacement;
    private String categorieH;
    //Associations
    public List<Emplacement> emplacements;
    
    //Constructor
	public Camping() {
		super();
	}
	public Camping(Float tarifemplacement, String categorieH, List<Emplacement> emplacements) {
		super();
		this.tarifemplacement = tarifemplacement;
		this.categorieH = categorieH;
		this.emplacements = emplacements;
	}
	
	//Getters & Setters
	public Float getTarifemplacement() {
		return tarifemplacement;
	}
	public void setTarifemplacement(Float tarifemplacement) {
		this.tarifemplacement = tarifemplacement;
	}
	public String getCategorieH() {
		return categorieH;
	}
	public void setCategorieH(String categorieH) {
		this.categorieH = categorieH;
	}
	public List<Emplacement> getEmplacements() {
		return emplacements;
	}
	public void setEmplacements(List<Emplacement> emplacements) {
		this.emplacements = emplacements;
	}
    
	//Association Methods
	public boolean addEmplacement(Emplacement e) {
		return this.emplacements.add(e);
	}
	public boolean removeEmplacement(Emplacement e) {
		return this.emplacements.remove(e);
	}

	
	//Methods
	@Override
	public String toString() {
		return "Camping [tarifemplacement=" + tarifemplacement + ", categorieH=" + categorieH + ", emplacements="
				+ emplacements + "]";
	}
}