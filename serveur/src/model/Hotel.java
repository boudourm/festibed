package model;
import java.time.LocalDate;
import java.util.*;

public class Hotel extends Hebergement {
	//Attributes
	private Integer nbChambres;
    private Integer nbCSMax;
    private Integer nbCFMax;
    private Integer nbCDMax;
    //Associations
    private List<ChambreDHotel> chambres;
    //Constructors
	public Hotel(Integer idHebergement, LocalDate dateClassementH, LocalDate datePublicationH, String typologieH,
			String classementH, String telephoneH, String courrierH, String siteInternet, Integer capaciteAcceuilH,
			String coordonneesH, Float noteH, String descriptionH, String nomCommercialH, String adresseH,
			Integer codePostalH, String communeH, String nomEPCI, Departement departement, List<Photo> photos,
			Hebergeur hebergeur, Map<Client, NoteHebergement> notesParClients, Integer nbChambres, Integer nbCSMax,
			Integer nbCFMax, Integer nbCDMax, List<ChambreDHotel> chambres) {
		super(idHebergement, dateClassementH, datePublicationH, typologieH, classementH, telephoneH, courrierH,
				siteInternet, capaciteAcceuilH, coordonneesH, noteH, descriptionH, nomCommercialH, adresseH,
				codePostalH, communeH, nomEPCI, departement, photos, hebergeur, notesParClients);
		this.nbChambres = nbChambres;
		this.nbCSMax = nbCSMax;
		this.nbCFMax = nbCFMax;
		this.nbCDMax = nbCDMax;
		this.chambres = chambres;
	}
	//Getters & Setters
	/**
	 * @return the nbChambres
	 */
	public Integer getNbChambres() {
		return nbChambres;
	}
	/**
	 * @param nbChambres the nbChambres to set
	 */
	public void setNbChambres(Integer nbChambres) {
		this.nbChambres = nbChambres;
	}
	/**
	 * @return the nbCSMax
	 */
	public Integer getNbCSMax() {
		return nbCSMax;
	}
	/**
	 * @param nbCSMax the nbCSMax to set
	 */
	public void setNbCSMax(Integer nbCSMax) {
		this.nbCSMax = nbCSMax;
	}
	/**
	 * @return the nbCFMax
	 */
	public Integer getNbCFMax() {
		return nbCFMax;
	}
	/**
	 * @param nbCFMax the nbCFMax to set
	 */
	public void setNbCFMax(Integer nbCFMax) {
		this.nbCFMax = nbCFMax;
	}
	/**
	 * @return the nbCDMax
	 */
	public Integer getNbCDMax() {
		return nbCDMax;
	}
	/**
	 * @param nbCDMax the nbCDMax to set
	 */
	public void setNbCDMax(Integer nbCDMax) {
		this.nbCDMax = nbCDMax;
	}
	/**
	 * @return the chambres
	 */
	public List<ChambreDHotel> getChambres() {
		return chambres;
	}
	/**
	 * @param chambres the chambres to set
	 */
	public void setChambres(List<ChambreDHotel> chambres) {
		this.chambres = chambres;
	}
	//Associations Methods
   // private List<ChambreDHotel> chambres;
    public boolean addChambre(ChambreDHotel chambre) {
    	return this.chambres.add(chambre);
    }
    public boolean removeChambre(ChambreDHotel chambre) {
    	return this.chambres.remove(chambre);
    }
    //Methods
	@Override
	public String toString() {
		return "Hotel [nbChambres=" + nbChambres + ", nbCSMax=" + nbCSMax + ", nbCFMax=" + nbCFMax + ", nbCDMax="
				+ nbCDMax + ", chambres=" + chambres + "]";
	}
    
 }