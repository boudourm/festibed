package model;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Hebergement {
	
	//Attributes
	private Integer idHebergement;
    private LocalDate dateClassementH;
    private LocalDate datePublicationH;
    private String typologieH;
    private String classementH;
    private String telephoneH;
    private String courrierH;
    private String siteInternet;
    private Integer capaciteAcceuilH;
    private String coordonneesH;
    private Float noteH;
    private String descriptionH;
    private String nomCommercialH;
    private String adresseH;
    private Integer codePostalH;
    private String communeH;
    private String nomEPCI;
    //Associations
    public Departement departement;
    public List<Photo> photos;
    public Hebergeur hebergeur;
    public Map<Client,NoteHebergement> notesParClients;
    //Contructors
	public Hebergement(Integer idHebergement, LocalDate dateClassementH, LocalDate datePublicationH, String typologieH,
			String classementH, String telephoneH, String courrierH, String siteInternet, Integer capaciteAcceuilH,
			String coordonneesH, Float noteH, String descriptionH, String nomCommercialH, String adresseH,
			Integer codePostalH, String communeH, String nomEPCI, Departement departement, List<Photo> photos,
			Hebergeur hebergeur, Map<Client, NoteHebergement> notesParClients) {
		super();
		this.idHebergement = idHebergement;
		this.dateClassementH = dateClassementH;
		this.datePublicationH = datePublicationH;
		this.typologieH = typologieH;
		this.classementH = classementH;
		this.telephoneH = telephoneH;
		this.courrierH = courrierH;
		this.siteInternet = siteInternet;
		this.capaciteAcceuilH = capaciteAcceuilH;
		this.coordonneesH = coordonneesH;
		this.noteH = noteH;
		this.descriptionH = descriptionH;
		this.nomCommercialH = nomCommercialH;
		this.adresseH = adresseH;
		this.codePostalH = codePostalH;
		this.communeH = communeH;
		this.nomEPCI = nomEPCI;
		this.departement = departement;
		this.photos = photos;
		this.hebergeur = hebergeur;
		this.notesParClients = notesParClients;
	}
	public Hebergement() {
		super();
	}
	//Getters & Setters
	/**
	 * @return the idHebergement
	 */
	public Integer getIdHebergement() {
		return idHebergement;
	}
	/**
	 * @param idHebergement the idHebergement to set
	 */
	public void setIdHebergement(Integer idHebergement) {
		this.idHebergement = idHebergement;
	}
	/**
	 * @return the dateClassementH
	 */
	public LocalDate getDateClassementH() {
		return dateClassementH;
	}
	/**
	 * @param dateClassementH the dateClassementH to set
	 */
	public void setDateClassementH(LocalDate dateClassementH) {
		this.dateClassementH = dateClassementH;
	}
	/**
	 * @return the datePublicationH
	 */
	public LocalDate getDatePublicationH() {
		return datePublicationH;
	}
	/**
	 * @param datePublicationH the datePublicationH to set
	 */
	public void setDatePublicationH(LocalDate datePublicationH) {
		this.datePublicationH = datePublicationH;
	}
	/**
	 * @return the typologieH
	 */
	public String getTypologieH() {
		return typologieH;
	}
	/**
	 * @param typologieH the typologieH to set
	 */
	public void setTypologieH(String typologieH) {
		this.typologieH = typologieH;
	}
	/**
	 * @return the classementH
	 */
	public String getClassementH() {
		return classementH;
	}
	/**
	 * @param classementH the classementH to set
	 */
	public void setClassementH(String classementH) {
		this.classementH = classementH;
	}
	/**
	 * @return the telephoneH
	 */
	public String getTelephoneH() {
		return telephoneH;
	}
	/**
	 * @param telephoneH the telephoneH to set
	 */
	public void setTelephoneH(String telephoneH) {
		this.telephoneH = telephoneH;
	}
	/**
	 * @return the courrierH
	 */
	public String getCourrierH() {
		return courrierH;
	}
	/**
	 * @param courrierH the courrierH to set
	 */
	public void setCourrierH(String courrierH) {
		this.courrierH = courrierH;
	}
	/**
	 * @return the siteInternet
	 */
	public String getSiteInternet() {
		return siteInternet;
	}
	/**
	 * @param siteInternet the siteInternet to set
	 */
	public void setSiteInternet(String siteInternet) {
		this.siteInternet = siteInternet;
	}
	/**
	 * @return the capaciteAcceuilH
	 */
	public Integer getCapaciteAcceuilH() {
		return capaciteAcceuilH;
	}
	/**
	 * @param capaciteAcceuilH the capaciteAcceuilH to set
	 */
	public void setCapaciteAcceuilH(Integer capaciteAcceuilH) {
		this.capaciteAcceuilH = capaciteAcceuilH;
	}
	/**
	 * @return the coordonneesH
	 */
	public String getCoordonneesH() {
		return coordonneesH;
	}
	/**
	 * @param coordonneesH the coordonneesH to set
	 */
	public void setCoordonneesH(String coordonneesH) {
		this.coordonneesH = coordonneesH;
	}
	/**
	 * @return the noteH
	 */
	public Float getNoteH() {
		return noteH;
	}
	/**
	 * @param noteH the noteH to set
	 */
	public void setNoteH(Float noteH) {
		this.noteH = noteH;
	}
	/**
	 * @return the descriptionH
	 */
	public String getDescriptionH() {
		return descriptionH;
	}
	/**
	 * @param descriptionH the descriptionH to set
	 */
	public void setDescriptionH(String descriptionH) {
		this.descriptionH = descriptionH;
	}
	/**
	 * @return the nomCommercialH
	 */
	public String getNomCommercialH() {
		return nomCommercialH;
	}
	/**
	 * @param nomCommercialH the nomCommercialH to set
	 */
	public void setNomCommercialH(String nomCommercialH) {
		this.nomCommercialH = nomCommercialH;
	}
	/**
	 * @return the adresseH
	 */
	public String getAdresseH() {
		return adresseH;
	}
	/**
	 * @param adresseH the adresseH to set
	 */
	public void setAdresseH(String adresseH) {
		this.adresseH = adresseH;
	}
	/**
	 * @return the codePostalH
	 */
	public Integer getCodePostalH() {
		return codePostalH;
	}
	/**
	 * @param codePostalH the codePostalH to set
	 */
	public void setCodePostalH(Integer codePostalH) {
		this.codePostalH = codePostalH;
	}
	/**
	 * @return the communeH
	 */
	public String getCommuneH() {
		return communeH;
	}
	/**
	 * @param communeH the communeH to set
	 */
	public void setCommuneH(String communeH) {
		this.communeH = communeH;
	}
	/**
	 * @return the nomEPCI
	 */
	public String getNomEPCI() {
		return nomEPCI;
	}
	/**
	 * @param nomEPCI the nomEPCI to set
	 */
	public void setNomEPCI(String nomEPCI) {
		this.nomEPCI = nomEPCI;
	}
	/**
	 * @return the departement
	 */
	public Departement getDepartement() {
		return departement;
	}
	/**
	 * @param departement the departement to set
	 */
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	/**
	 * @return the photos
	 */
	public List<Photo> getPhotos() {
		return photos;
	}
	/**
	 * @param photos the photos to set
	 */
	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}
	/**
	 * @return the hebergeur
	 */
	public Hebergeur getHebergeur() {
		return hebergeur;
	}
	/**
	 * @param hebergeur the hebergeur to set
	 */
	public void setHebergeur(Hebergeur hebergeur) {
		this.hebergeur = hebergeur;
	}
	/**
	 * @return the notesParClients
	 */
	public Map<Client, NoteHebergement> getNotesParClients() {
		return notesParClients;
	}
	/**
	 * @param notesParClients the notesParClients to set
	 */
	public void setNotesParClients(Map<Client, NoteHebergement> notesParClients) {
		this.notesParClients = notesParClients;
	}
	//Associations Methods
	/*    
    public List<Photo> photos;
    public Map<Client,NoteHebergement> notesParClients;
    */
	public boolean addPhoto(Photo photo) {
		return this.photos.add(photo);
	}
	public boolean removePhoto(Photo photo) {
		return this.photos.remove(photo);
	}
	public NoteHebergement saveNote(Client client, NoteHebergement note) {
		return this.notesParClients.put(client,note);
	}
	public NoteHebergement updateNote(Client client, NoteHebergement note) {
		return this.notesParClients.replace(client,note);
	}
	//Methods
	@Override
	public String toString() {
		return "Hebergement [idHebergement=" + idHebergement + ", nomCommercialH=" + nomCommercialH
				+ "]";
	}
	
}