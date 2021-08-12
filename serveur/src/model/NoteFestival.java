package model;
import java.util.*;

public class NoteFestival {
	//Attributes
    private Integer noteF;
    //Constructors
	public NoteFestival(Integer noteF) {
		super();
		this.noteF = noteF;
	}

	public NoteFestival() {
		super();
	}
	//Getters & Setters
	/**
	 * @return the noteF
	 */
	public Integer getNoteF() {
		return noteF;
	}

	/**
	 * @param noteF the noteF to set
	 */
	public void setNoteF(Integer noteF) {
		this.noteF = noteF;
	}
    
	//Methods
	@Override
	public String toString() {
		return "NoteFestival [noteF=" + noteF + "]";
	}
    
}