package model;
import java.util.*;

public class Domaine {
	//Attributes
    private String nomDomaine;
    //Constructors
	public Domaine(String nomDomaine) {
		super();
		this.nomDomaine = nomDomaine;
	}
	public Domaine() {
		super();
	}
    //Getters & Setters 
	/**
	 * @return the nomDomaine
	 */
	public String getNomDomaine() {
		return nomDomaine;
	}
	/**
	 * @param nomDomaine the nomDomaine to set
	 */
	public void setNomDomaine(String nomDomaine) {
		this.nomDomaine = nomDomaine;
	}
	//Methods
	@Override
	public String toString() {
		return "Domaine [nomDomaine=" + nomDomaine + "]";
	}
	

}