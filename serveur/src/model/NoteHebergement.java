package model;
import java.util.*;

public class NoteHebergement {
	//Attributes
    private Integer noteH;

    //Constructor
	public NoteHebergement(Integer noteH) {
		super();
		this.noteH = noteH;
	}

	public NoteHebergement() {
		super();
	}

	//Getters é Setters
	/**
	 * @return the noteH
	 */
	public Integer getNoteH() {
		return noteH;
	}

	/**
	 * @param noteH the noteH to set
	 */
	public void setNoteH(Integer noteH) {
		this.noteH = noteH;
	}
	//Methods

	@Override
	public String toString() {
		return "NoteHebergement [noteH=" + noteH + "]";
	}
	
	
	
}