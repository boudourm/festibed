package model;
import java.util.*;

public class Departement {
	//Attributes
    private Integer deptSk;
    private String nomDepartement;	
    //Associations
    private Region region;
    //Constructors

	public Departement() {
		super();
	}
	public Departement(Integer deptSk, String nomDepartement, Region region) {
		super();
		this.deptSk = deptSk;
		this.nomDepartement = nomDepartement;
		this.region = region;
	}
	//Getterse & Setters
	
	/**
	 * @return the deptSk
	 */
	public Integer getDeptSk() {
		return deptSk;
	}
	/**
	 * @return the region
	 */
	public Region getRegion() {
		return region;
	}
	/**
	 * @param region the region to set
	 */
	public void setRegion(Region region) {
		this.region = region;
	}
	/**
	 * @param deptSk the deptSk to set
	 */
	public void setDeptSk(Integer deptSk) {
		this.deptSk = deptSk;
	}
	/**
	 * @return the nomDepartement
	 */
	public String getNomDepartement() {
		return nomDepartement;
	}
	/**
	 * @param nomDepartement the nomDepartement to set
	 */
	public void setNomDepartement(String nomDepartement) {
		this.nomDepartement = nomDepartement;
	}
	//Methods
	@Override
	public String toString() {
		return "Departement [deptSk=" + deptSk + ", nomDepartement=" + nomDepartement + "]";
	}
	


}