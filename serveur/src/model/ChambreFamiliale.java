package model;

public class ChambreFamiliale extends ChambreHotel {
	//Attributs
	private int capaciteEnfant;
	private int capaciteAdulte;
	//Associations
	
	//Constructor
	public ChambreFamiliale(int capaciteEnfant, int capaciteAdulte) {
		super();
		this.capaciteAdulte=capaciteAdulte;
		this.capaciteEnfant=capaciteEnfant;
	}

	
	
	//Guetters & setters
	public int getCapaciteEnfant() {
		return capaciteEnfant;
	}

	public void setCapaciteEnfant(int capaciteEnfant) {
		this.capaciteEnfant = capaciteEnfant;
	}

	public int getCapaciteAdulte() {
		return capaciteAdulte;
	}

	public void setCapaciteAdulte(int capaciteAdulte) {
		this.capaciteAdulte = capaciteAdulte;
	}
	

}