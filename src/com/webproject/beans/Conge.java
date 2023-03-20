package com.webproject.beans;

public class Conge {
	private int id ;
	private String intitule ; 
	private String reason  ; 
	private int nbJour ; 
	private boolean affectSalaire ;
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
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getNbJour() {
		return nbJour;
	}
	public void setNbJour(int nbJour) {
		this.nbJour = nbJour;
	}
	public boolean isAffectSalaire() {
		return affectSalaire;
	}
	public void setAffectSalaire(boolean affectSalaire) {
		this.affectSalaire = affectSalaire;
	} 
	
	public boolean isValidId(int id ) {
		if(this.id == id) validId = true ;
			return validId ; 
	}

}
