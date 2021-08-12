package model;


import java.util.*;

public class Utilisateur {

	//Attributes
    private Integer idUtilisateur;
    private String nomUtilisateur;
    private String prenomUtilisateur;
    private String emailUtilisateur;
    private String motDePasseUtilisateur;
    private String idFireBase;
    
    //Constructor        
	public Utilisateur() {
		super();
	}
	public Utilisateur(Integer idUtilisateur, String nomUtilisateur, String prenomUtilisateur, String emailUtilisateur,
			String motDePasseUtilisateur, String idFireBase) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.nomUtilisateur = nomUtilisateur;
		this.prenomUtilisateur = prenomUtilisateur;
		this.emailUtilisateur = emailUtilisateur;
		this.motDePasseUtilisateur = motDePasseUtilisateur;
		this.idFireBase = idFireBase;
	}
	//Getters & Setters
	
	/**
	 * @return the idUtilisateur
	 */
	public Integer getIdUtilisateur() {
		return idUtilisateur;
	}
	/**
	 * @return the idFireBase
	 */
	public String getIdFireBase() {
		return idFireBase;
	}
	/**
	 * @param idFireBase the idFireBase to set
	 */
	public void setIdFireBase(String idFireBase) {
		this.idFireBase = idFireBase;
	}
	/**
	 * @param idUtilisateur the idUtilisateur to set
	 */
	public void setIdUtilisateur(Integer idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	/**
	 * @return the nomUtilisateur
	 */
	public String getNomUtilisateur() {
		return nomUtilisateur;
	}
	/**
	 * @param nomUtilisateur the nomUtilisateur to set
	 */
	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}
	/**
	 * @return the prenomUtilisateur
	 */
	public String getPrenomUtilisateur() {
		return prenomUtilisateur;
	}
	/**
	 * @param prenomUtilisateur the prenomUtilisateur to set
	 */
	public void setPrenomUtilisateur(String prenomUtilisateur) {
		this.prenomUtilisateur = prenomUtilisateur;
	}
	/**
	 * @return the emailUtilisateur
	 */
	public String getEmailUtilisateur() {
		return emailUtilisateur;
	}
	/**
	 * @param emailUtilisateur the emailUtilisateur to set
	 */
	public void setEmailUtilisateur(String emailUtilisateur) {
		this.emailUtilisateur = emailUtilisateur;
	}
	/**
	 * @return the motDePasseUtilisateur
	 */
	public String getMotDePasseUtilisateur() {
		return motDePasseUtilisateur;
	}
	/**
	 * @param motDePasseUtilisateur the motDePasseUtilisateur to set
	 */
	public void setMotDePasseUtilisateur(String motDePasseUtilisateur) {
		this.motDePasseUtilisateur = motDePasseUtilisateur;
	}
	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", nomUtilisateur=" + nomUtilisateur
				+ ", prenomUtilisateur=" + prenomUtilisateur + ", emailUtilisateur=" + emailUtilisateur
				+ ", motDePasseUtilisateur=" + motDePasseUtilisateur + ", idFireBase=" + idFireBase + "]";
	}
	
	//Methods

	
}