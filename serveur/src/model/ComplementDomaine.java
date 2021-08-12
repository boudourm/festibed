package model;
import java.util.*;

public class ComplementDomaine {
	//Attributes
    private String NomSousDomaine;
    //Constructors
	public ComplementDomaine(String nomSousDomaine) {
		super();
		NomSousDomaine = nomSousDomaine;
	}

	public ComplementDomaine() {
		super();
	}
	//Getters & Setters

	/**
	 * @return the nomSousDomaine
	 */
	public String getNomSousDomaine() {
		return NomSousDomaine;
	}

	/**
	 * @param nomSousDomaine the nomSousDomaine to set
	 */
	public void setNomSousDomaine(String nomSousDomaine) {
		NomSousDomaine = nomSousDomaine;
	}
	//Methods

	@Override
	public String toString() {
		return "ComplementDomaine [NomSousDomaine=" + NomSousDomaine + "]";
	}
	
}