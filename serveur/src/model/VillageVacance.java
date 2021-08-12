package model;
import java.time.LocalDate;
import java.util.*;

public class VillageVacance extends Hebergement {
	//Attributes
	private Integer nbUnite;
    private String mentionVillageVacance;
    private String typeSejour;
    //Associations
    public List<ChambreVillage> chambresVillage;
    public List<Collectif> collectifs;
    //Constructor
	public VillageVacance(Integer idHebergement, LocalDate dateClassementH, LocalDate datePublicationH,
			String typologieH, String classementH, String telephoneH, String courrierH, String siteInternet,
			Integer capaciteAcceuilH, String coordonneesH, Float noteH, String descriptionH, String nomCommercialH,
			String adresseH, Integer codePostalH, String communeH, String nomEPCI, Departement departement,
			List<Photo> photos, Hebergeur hebergeur, Map<Client, NoteHebergement> notesParClients, Integer nbUnite,
			String mentionVillageVacance, String typeSejour, List<ChambreVillage> chambresVillage,
			List<Collectif> collectifs) {
		super(idHebergement, dateClassementH, datePublicationH, typologieH, classementH, telephoneH, courrierH,
				siteInternet, capaciteAcceuilH, coordonneesH, noteH, descriptionH, nomCommercialH, adresseH,
				codePostalH, communeH, nomEPCI, departement, photos, hebergeur, notesParClients);
		this.nbUnite = nbUnite;
		this.mentionVillageVacance = mentionVillageVacance;
		this.typeSejour = typeSejour;
		this.chambresVillage = chambresVillage;
		this.collectifs = collectifs;
	}
    //Getters & Setters
	/**
	 * @return the nbUnite
	 */
	public Integer getNbUnite() {
		return nbUnite;
	}
	/**
	 * @param nbUnite the nbUnite to set
	 */
	public void setNbUnite(Integer nbUnite) {
		this.nbUnite = nbUnite;
	}
	/**
	 * @return the mentionVillageVacance
	 */
	public String getMentionVillageVacance() {
		return mentionVillageVacance;
	}
	/**
	 * @param mentionVillageVacance the mentionVillageVacance to set
	 */
	public void setMentionVillageVacance(String mentionVillageVacance) {
		this.mentionVillageVacance = mentionVillageVacance;
	}
	/**
	 * @return the typeSejour
	 */
	public String getTypeSejour() {
		return typeSejour;
	}
	/**
	 * @param typeSejour the typeSejour to set
	 */
	public void setTypeSejour(String typeSejour) {
		this.typeSejour = typeSejour;
	}
	/**
	 * @return the chambresVillage
	 */
	public List<ChambreVillage> getChambresVillage() {
		return chambresVillage;
	}
	/**
	 * @param chambresVillage the chambresVillage to set
	 */
	public void setChambresVillage(List<ChambreVillage> chambresVillage) {
		this.chambresVillage = chambresVillage;
	}
	/**
	 * @return the collectifs
	 */
	public List<Collectif> getCollectifs() {
		return collectifs;
	}
	/**
	 * @param collectifs the collectifs to set
	 */
	public void setCollectifs(List<Collectif> collectifs) {
		this.collectifs = collectifs;
	}
	//Associations Methods
	public boolean addChambreVillage(ChambreVillage chambre) {
		return this.chambresVillage.add(chambre);
	}
	public boolean removeChambreVillage(ChambreVillage chambre) {
		return this.chambresVillage.remove(chambre);
	}
	public boolean addCollectif(Collectif collectif) {
		return this.collectifs.add(collectif);
	}
	public boolean removeCollectif(Collectif collectif) {
		return this.collectifs.remove(collectif);
	}
	//Methods
	@Override
	public String toString() {
		return "VillageVacance [nbUnite=" + nbUnite + ", mentionVillageVacance=" + mentionVillageVacance
				+ ", typeSejour=" + typeSejour + ", chambresVillage=" + chambresVillage + ", collectifs=" + collectifs
				+ "]";
	}
	
	/*
	public List<ChambreVillage> chambresVillage;
    public List<Collectif> collectifs;*/
}