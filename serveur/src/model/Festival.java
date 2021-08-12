package model;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Festival {
	//Attributes
    private String numeroIdentification;
    private String nomManifestation;
    private String moisHabituelle;
    private String siteWeb;
    private LocalDate dateDebutF;
    private LocalDate dateFinF;
    private LocalDate dateCreationF;
    private String coordonneesF;
    private Integer nbPlacesFestival;
    private String communePrincipaleF;
    private Integer codePostalFestival;
    private String codeInseeF;
    private String autresCommunes;
    //Associations
    public ComplementDomaine complementDomaine;
    public Domaine domaine;
    public Departement dpartement;
    public List<Place> places;
    public Organisateur organisateur;
    public Map<Client,NoteFestival> notesParClient;
    //Constructors
	
	public Festival() {
		super();
	}
    public Festival(String numeroIdentification, String nomManifestation, String moisHabituelle, String siteWeb,
			LocalDate dateDebutF, LocalDate dateFinF, LocalDate dateCreationF, String coordonneesF,
			Integer nbPlacesFestival, String communePrincipaleF, Integer codePostalFestival, String codeInseeF,
			String autresCommunes, ComplementDomaine complementDomaine, Domaine domaine, Departement dpartement,
			List<Place> places, Organisateur organisateur, Map<Client, NoteFestival> notesParClient) {
		super();
		this.numeroIdentification = numeroIdentification;
		this.nomManifestation = nomManifestation;
		this.moisHabituelle = moisHabituelle;
		this.siteWeb = siteWeb;
		this.dateDebutF = dateDebutF;
		this.dateFinF = dateFinF;
		this.dateCreationF = dateCreationF;
		this.coordonneesF = coordonneesF;
		this.nbPlacesFestival = nbPlacesFestival;
		this.communePrincipaleF = communePrincipaleF;
		this.codePostalFestival = codePostalFestival;
		this.codeInseeF = codeInseeF;
		this.autresCommunes = autresCommunes;
		this.complementDomaine = complementDomaine;
		this.domaine = domaine;
		this.dpartement = dpartement;
		this.places = places;
		this.organisateur = organisateur;
		this.notesParClient = notesParClient;
	}
	//Getters & Setters
    
	/**
	 * @return the numeroIdentification
	 */
	public String getNumeroIdentification() {
		return numeroIdentification;
	}
	/**
	 * @return the codeInseeF
	 */
	public String getCodeInseeF() {
		return codeInseeF;
	}
	/**
	 * @param codeInseeF the codeInseeF to set
	 */
	public void setCodeInseeF(String codeInseeF) {
		this.codeInseeF = codeInseeF;
	}
	/**
	 * @param numeroIdentification the numeroIdentification to set
	 */
	public void setNumeroIdentification(String numeroIdentification) {
		this.numeroIdentification = numeroIdentification;
	}
	/**
	 * @return the nomManifestation
	 */
	public String getNomManifestation() {
		return nomManifestation;
	}
	/**
	 * @param nomManifestation the nomManifestation to set
	 */
	public void setNomManifestation(String nomManifestation) {
		this.nomManifestation = nomManifestation;
	}
	/**
	 * @return the moisHabituelle
	 */
	public String getMoisHabituelle() {
		return moisHabituelle;
	}
	/**
	 * @param moisHabituelle the moisHabituelle to set
	 */
	public void setMoisHabituelle(String moisHabituelle) {
		this.moisHabituelle = moisHabituelle;
	}
	/**
	 * @return the siteWeb
	 */
	public String getSiteWeb() {
		return siteWeb;
	}
	/**
	 * @param siteWeb the siteWeb to set
	 */
	public void setSiteWeb(String siteWeb) {
		this.siteWeb = siteWeb;
	}
	/**
	 * @return the dateDebutF
	 */
	public LocalDate getDateDebutF() {
		return dateDebutF;
	}
	/**
	 * @param dateDebutF the dateDebutF to set
	 */
	public void setDateDebutF(LocalDate dateDebutF) {
		this.dateDebutF = dateDebutF;
	}
	/**
	 * @return the dateFinF
	 */
	public LocalDate getDateFinF() {
		return dateFinF;
	}
	/**
	 * @param dateFinF the dateFinF to set
	 */
	public void setDateFinF(LocalDate dateFinF) {
		this.dateFinF = dateFinF;
	}
	/**
	 * @return the dateCreationF
	 */
	public LocalDate getDateCreationF() {
		return dateCreationF;
	}
	/**
	 * @param dateCreationF the dateCreationF to set
	 */
	public void setDateCreationF(LocalDate dateCreationF) {
		this.dateCreationF = dateCreationF;
	}
	/**
	 * @return the coordonneesF
	 */
	public String getCoordonneesF() {
		return coordonneesF;
	}
	/**
	 * @param coordonneesF the coordonneesF to set
	 */
	public void setCoordonneesF(String coordonneesF) {
		this.coordonneesF = coordonneesF;
	}
	/**
	 * @return the nbPlacesFestival
	 */
	public Integer getNbPlacesFestival() {
		return nbPlacesFestival;
	}
	/**
	 * @param nbPlacesFestival the nbPlacesFestival to set
	 */
	public void setNbPlacesFestival(Integer nbPlacesFestival) {
		this.nbPlacesFestival = nbPlacesFestival;
	}
	/**
	 * @return the communePrincipaleF
	 */
	public String getCommunePrincipaleF() {
		return communePrincipaleF;
	}
	/**
	 * @param communePrincipaleF the communePrincipaleF to set
	 */
	public void setCommunePrincipaleF(String communePrincipaleF) {
		this.communePrincipaleF = communePrincipaleF;
	}
	/**
	 * @return the codePostalFestival
	 */
	public Integer getCodePostalFestival() {
		return codePostalFestival;
	}
	/**
	 * @param codePostalFestival the codePostalFestival to set
	 */
	public void setCodePostalFestival(Integer codePostalFestival) {
		this.codePostalFestival = codePostalFestival;
	}
	/**
	 * @return the autresCommunes
	 */
	public String getAutresCommunes() {
		return autresCommunes;
	}
	/**
	 * @param autresCommunes the autresCommunes to set
	 */
	public void setAutresCommunes(String autresCommunes) {
		this.autresCommunes = autresCommunes;
	}
	/**
	 * @return the complementDomaine
	 */
	public ComplementDomaine getComplementDomaine() {
		return complementDomaine;
	}
	/**
	 * @param complementDomaine the complementDomaine to set
	 */
	public void setComplementDomaine(ComplementDomaine complementDomaine) {
		this.complementDomaine = complementDomaine;
	}
	/**
	 * @return the domaine
	 */
	public Domaine getDomaine() {
		return domaine;
	}
	/**
	 * @param domaine the domaine to set
	 */
	public void setDomaine(Domaine domaine) {
		this.domaine = domaine;
	}
	/**
	 * @return the dpartement
	 */
	public Departement getDpartement() {
		return dpartement;
	}
	/**
	 * @param dpartement the dpartement to set
	 */
	public void setDpartement(Departement dpartement) {
		this.dpartement = dpartement;
	}
	/**
	 * @return the places
	 */
	public List<Place> getPlaces() {
		return places;
	}
	/**
	 * @param places the places to set
	 */
	public void setPlaces(List<Place> places) {
		this.places = places;
	}
	/**
	 * @return the organisateur
	 */
	public Organisateur getOrganisateur() {
		return organisateur;
	}
	/**
	 * @param organisateur the organisateur to set
	 */
	public void setOrganisateur(Organisateur organisateur) {
		this.organisateur = organisateur;
	}
	/**
	 * @return the notesParClient
	 */
	public Map<Client, NoteFestival> getNotesParClient() {
		return notesParClient;
	}
	/**
	 * @param notesParClient the notesParClient to set
	 */
	public void setNotesParClient(Map<Client, NoteFestival> notesParClient) {
		this.notesParClient = notesParClient;
	}
	//Association Methods
	public boolean addPlace(Place place) {
		return this.places.add(place);
	}
	public boolean removePlace(Place place) {
		return this.places.remove(place);
	}
	public NoteFestival saveNote(Client client, NoteFestival note) {
		return this.notesParClient.put(client, note);
	}
	public NoteFestival updateNote(Client client, NoteFestival note) {
		return this.notesParClient.replace(client, note);
	}
	//METHODS
	@Override
	public String toString() {
		return "Festival [numeroIdentification=" + numeroIdentification + ", nomManifestation=" + nomManifestation
				+ "]";
	}
	
}