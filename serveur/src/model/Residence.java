package model;
import java.time.LocalDate;
import java.util.*;

public class Residence extends Hebergement {
	//Attributes
	private Integer capacite;
	//Associations
    private List<Unite> units;
	//Contructors
	public Residence(Integer idHebergement, LocalDate dateClassementH, LocalDate datePublicationH, String typologieH,
			String classementH, String telephoneH, String courrierH, String siteInternet, Integer capaciteAcceuilH,
			String coordonneesH, Float noteH, String descriptionH, String nomCommercialH, String adresseH,
			Integer codePostalH, String communeH, String nomEPCI, Departement departement, List<Photo> photos,
			Hebergeur hebergeur, Map<Client, NoteHebergement> notesParClients, Integer capacite) {
		super(idHebergement, dateClassementH, datePublicationH, typologieH, classementH, telephoneH, courrierH,
				siteInternet, capaciteAcceuilH, coordonneesH, noteH, descriptionH, nomCommercialH, adresseH,
				codePostalH, communeH, nomEPCI, departement, photos, hebergeur, notesParClients);
		this.capacite = capacite;
	}
	//Getters & Setters
	/**
	 * @return the capacite
	 */
	public Integer getCapacite() {
		return capacite;
	}
	/**
	 * @param capacite the capacite to set
	 */
	public void setCapacite(Integer capacite) {
		this.capacite = capacite;
	}
	/**
	 * @return the units
	 */
	public List<Unite> getUnits() {
		return units;
	}
	/**
	 * @param units the units to set
	 */
	public void setUnits(List<Unite> units) {
		this.units = units;
	}
	//Associations Methods
	public boolean addUnit(Unite unit) {
		return this.units.add(unit);
	}
	public boolean removeUnit(Unite unit) {
		return this.units.remove(unit);
	}
	//Methods
	@Override
	public String toString() {
		return "Residence [capacite=" + capacite + ", units=" + units + "]";
	}
	
}