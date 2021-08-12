package model;
import java.time.LocalDate;

public class Dates {
	//Attributes
    private LocalDate dateValue;
    //Constructors
	public Dates(LocalDate dateValue) {
		super();
		this.dateValue = dateValue;
	}
	public Dates() {
		super();
	}
    //Getters & Setters
	/**
	 * @return the dateValue
	 */
	public LocalDate getDateValue() {
		return dateValue;
	}
	/**
	 * @param dateValue the dateValue to set
	 */
	public void setDateValue(LocalDate dateValue) {
		this.dateValue = dateValue;
	}
	//Methods
	@Override
	public String toString() {
		return "Dates [dateValue=" + dateValue + "]";
	}
	
	
}