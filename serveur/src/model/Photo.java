package model;
import java.util.*;

public class Photo {
	//Attributes
    private String imageUrl;
    //Associations
    public Hebergement hebergement;
    //Constructors
	public Photo(String imageUrl, Hebergement hebergement) {
		super();
		this.imageUrl = imageUrl;
		this.hebergement = hebergement;
	}
	public Photo() {
		super();
	}
    //Getters & Setters
	/**
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}
	/**
	 * @param imageUrl the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	/**
	 * @return the hebergement
	 */
	public Hebergement getHebergement() {
		return hebergement;
	}
	/**
	 * @param hebergement the hebergement to set
	 */
	public void setHebergement(Hebergement hebergement) {
		this.hebergement = hebergement;
	}
	//Methods
	@Override
	public String toString() {
		return "Photo [imageUrl=" + imageUrl + ", hebergement=" + hebergement + "]";
	}
	
	
}