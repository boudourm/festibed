package model;
import java.util.*;

public class Collectif extends Logement {

	//Attributes
    private Float tarifAdulte;
    private Float tarifenfant;
    private Integer nbLitsMax;
    private Integer nbLitsDIspo;
    
    //Associations
    public VillageVacance villageVacance;

    //Constructors
	public Collectif(Float tarifAdulte, Float tarifenfant, Integer nbLitsMax, Integer nbLitsDIspo,
			VillageVacance villageVacance) {
		super();
		this.tarifAdulte = tarifAdulte;
		this.tarifenfant = tarifenfant;
		this.nbLitsMax = nbLitsMax;
		this.nbLitsDIspo = nbLitsDIspo;
		this.villageVacance = villageVacance;
	}

	public Collectif() {
		super();
	}
    //Getters & Setters

	/**
	 * @return the tarifAdulte
	 */
	public Float getTarifAdulte() {
		return tarifAdulte;
	}

	/**
	 * @param tarifAdulte the tarifAdulte to set
	 */
	public void setTarifAdulte(Float tarifAdulte) {
		this.tarifAdulte = tarifAdulte;
	}

	/**
	 * @return the tarifenfant
	 */
	public Float getTarifenfant() {
		return tarifenfant;
	}

	/**
	 * @param tarifenfant the tarifenfant to set
	 */
	public void setTarifenfant(Float tarifenfant) {
		this.tarifenfant = tarifenfant;
	}

	/**
	 * @return the nbLitsMax
	 */
	public Integer getNbLitsMax() {
		return nbLitsMax;
	}

	/**
	 * @param nbLitsMax the nbLitsMax to set
	 */
	public void setNbLitsMax(Integer nbLitsMax) {
		this.nbLitsMax = nbLitsMax;
	}

	/**
	 * @return the nbLitsDIspo
	 */
	public Integer getNbLitsDIspo() {
		return nbLitsDIspo;
	}

	/**
	 * @param nbLitsDIspo the nbLitsDIspo to set
	 */
	public void setNbLitsDIspo(Integer nbLitsDIspo) {
		this.nbLitsDIspo = nbLitsDIspo;
	}

	/**
	 * @return the villageVacance
	 */
	public VillageVacance getVillageVacance() {
		return villageVacance;
	}

	/**
	 * @param villageVacance the villageVacance to set
	 */
	public void setVillageVacance(VillageVacance villageVacance) {
		this.villageVacance = villageVacance;
	}
	//Methods
	@Override
	public String toString() {
		return "Collectif [tarifAdulte=" + tarifAdulte + ", tarifenfant=" + tarifenfant + ", nbLitsMax=" + nbLitsMax
				+ ", nbLitsDIspo=" + nbLitsDIspo + ", villageVacance=" + villageVacance + "]";
	}
	
    

}