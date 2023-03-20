package com.webproject.beans;

public class CongeEnDemande {
	private int id  ; 
	private String intitule ; 
	private String reason  ; 
	private int nbJour ; 
	private boolean affectSalaire ;
	private int user_id ; 
	private String nom ; 
	private String prenom ; 
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public boolean isValidId() {
		return validId;
	}
	public void setValidId(boolean validId) {
		this.validId = validId;
	}

	private int congee_id ;
	private String dateDebut ; 
	private String dateFin ;
	private boolean etat ; 
	private boolean validId ; 
	
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
	
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getCongee_id() {
		return congee_id;
	}
	public void setCongee_id(int congee_id) {
		this.congee_id = congee_id;
	}
	public String getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}
	public String getDateFin() {
		return dateFin;
	}
	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	} 
	
	public boolean isValidId(int id ) {
		if(this.id == id) validId = true ;
			return validId ; 
	}

}
