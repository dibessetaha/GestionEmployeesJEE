package com.webproject.beans;

public class Contrat {
	private int id  ; 
	private String title ;
	private String poste ; 
	private String dateContratDebut ; 
	private String dateContratFin ; 
	private double salary ; 
	private String type ; 
	private boolean etat ; 
	private boolean validId ; 
	private int user_id ;
	private String nom ; 
	private String prenom ; 
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPoste() {
		return poste;
	}
	public void setPoste(String poste) {
		this.poste = poste;
	}
	
	public String getDateContratDebut() {
		return dateContratDebut;
	}
	public void setDateContratDebut(String dateContratDebut) {
		this.dateContratDebut = dateContratDebut;
	}
	public String getDateContratFin() {
		return dateContratFin;
	}
	public void setDateContratFin(String dateContratFin) {
		this.dateContratFin = dateContratFin;
	}
	public boolean isValidId() {
		return validId;
	}
	public void setValidId(boolean validId) {
		this.validId = validId;
	}
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	} 
	public boolean isValidId(int id ) {
		if(this.id == id) validId = true ;
			return validId ; 
	}
}
