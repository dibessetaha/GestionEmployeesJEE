package com.webproject.beans;

public class Poste {
	private int id  ; 
	private String intitule ; 
	private int placeVide ; 
	private int user_id;  
	private int contrat_id ;
	private boolean validId ; 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public int getPlaceVide() {
		return placeVide;
	}
	public void setPlaceVide(int placeVide) {
		this.placeVide = placeVide;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getContrat_id() {
		return contrat_id;
	}
	public void setContrat_id(int contrat_id) {
		this.contrat_id = contrat_id;
	} 
	
	public boolean isValidId(int id ) {
		if(this.id == id) validId = true ;
			return validId ; 
	}
	
}
