package model;
import java.time.LocalDate;

public class Nuitee {
	//Attributes
    public LocalDate dateDebut;
    private LocalDate dateFin;
    private Float prixNuitee;
    private Integer nbPlacesenfant;
    private Integer nbPlacesAdulte;
    //Contructors
	public Nuitee(LocalDate dateDebut, LocalDate dateFin, Float prixNuitee, Integer nbPlacesenfant,
			Integer nbPlacesAdulte) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.prixNuitee = prixNuitee;
		this.nbPlacesenfant = nbPlacesenfant;
		this.nbPlacesAdulte = nbPlacesAdulte;
	}
	public Nuitee() {
		super();
	}
	//Getters & Setters
	/**
	 * @return the dateDebut
	 */
	public LocalDate getDateDebut() {
		return dateDebut;
	}
	/**
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}
	/**
	 * @return the dateFin
	 */
	public LocalDate getDateFin() {
		return dateFin;
	}
	/**
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}
	/**
	 * @return the prixNuitee
	 */
	public Float getPrixNuitee() {
		return prixNuitee;
	}
	/**
	 * @param prixNuitee the prixNuitee to set
	 */
	public void setPrixNuitee(Float prixNuitee) {
		this.prixNuitee = prixNuitee;
	}
	/**
	 * @return the nbPlacesenfant
	 */
	public Integer getNbPlacesenfant() {
		return nbPlacesenfant;
	}
	/**
	 * @param nbPlacesenfant the nbPlacesenfant to set
	 */
	public void setNbPlacesenfant(Integer nbPlacesenfant) {
		this.nbPlacesenfant = nbPlacesenfant;
	}
	/**
	 * @return the nbPlacesAdulte
	 */
	public Integer getNbPlacesAdulte() {
		return nbPlacesAdulte;
	}
	/**
	 * @param nbPlacesAdulte the nbPlacesAdulte to set
	 */
	public void setNbPlacesAdulte(Integer nbPlacesAdulte) {
		this.nbPlacesAdulte = nbPlacesAdulte;
	}
	//Methods
	@Override
	public String toString() {
		return "Nuitee [dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", prixNuitee=" + prixNuitee
				+ ", nbPlacesenfant=" + nbPlacesenfant + ", nbPlacesAdulte=" + nbPlacesAdulte + "]";
	}
    
    
    
}