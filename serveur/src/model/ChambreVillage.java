package model;
import java.util.*;

public class ChambreVillage extends Logement {
	//Attributes
    private Integer capaciteAdulte;
    private Integer capaciteEnfant;
    private Float tarifAdulte;
    private Float tarifEnfant;
    
    //Associations
    public VillageVacance villageVacance;

    //Constructor
	public ChambreVillage() {
		super();
	}
   public ChambreVillage(Integer capaciteAdulte, Integer capaciteEnfant, Float tarifAdulte, Float tarifEnfant,
			VillageVacance villageVacance) {
		super();
		this.capaciteAdulte = capaciteAdulte;
		this.capaciteEnfant = capaciteEnfant;
		this.tarifAdulte = tarifAdulte;
		this.tarifEnfant = tarifEnfant;
		this.villageVacance = villageVacance;
	}

    //Getters & Setters
	/**
	 * @return the capaciteAdulte
	 */
	public Integer getCapaciteAdulte() {
		return capaciteAdulte;
	}

	/**
	 * @param capaciteAdulte the capaciteAdulte to set
	 */
	public void setCapaciteAdulte(Integer capaciteAdulte) {
		this.capaciteAdulte = capaciteAdulte;
	}

	/**
	 * @return the capaciteEnfant
	 */
	public Integer getCapaciteEnfant() {
		return capaciteEnfant;
	}

	/**
	 * @param capaciteEnfant the capaciteEnfant to set
	 */
	public void setCapaciteEnfant(Integer capaciteEnfant) {
		this.capaciteEnfant = capaciteEnfant;
	}

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
	 * @return the tarifEnfant
	 */
	public Float getTarifEnfant() {
		return tarifEnfant;
	}

	/**
	 * @param tarifEnfant the tarifEnfant to set
	 */
	public void setTarifEnfant(Float tarifEnfant) {
		this.tarifEnfant = tarifEnfant;
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
		return "ChambreVillage [capaciteAdulte=" + capaciteAdulte + ", capaciteEnfant=" + capaciteEnfant
				+ ", tarifAdulte=" + tarifAdulte + ", tarifEnfant=" + tarifEnfant + ", villageVacance=" + villageVacance
				+ "]";
	}
}