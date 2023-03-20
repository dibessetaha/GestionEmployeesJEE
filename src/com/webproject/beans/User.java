package com.webproject.beans;

public class User {
	private int id ; 
	private String username  ; 
	private String password  ; 
	private String nom  ; 
	private String email  ; 
	private String prenom  ; 
	private String role ; 
	private String dateNaissance ; 
	private String dateContratDebut ; 
	private String dateContratFin ; 
	private String typeContrat ; 
	private double salary ; 
	private String poste ; 
	public String getPoste() {
		return poste;
	}
	public void setPoste(String poste) {
		this.poste = poste;
	}
	public String getTypeContrat() {
		return typeContrat;
	}
	public void setTypeContrat(String typeContrat) {
		this.typeContrat = typeContrat;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
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
	private String cv ; 
	private int poste_id ; 
	private int contrat_id ; 
	private int conge_id ; 
	public int getPoste_id() {
		return poste_id;
	}
	public void setPoste_id(int poste_id) {
		this.poste_id = poste_id;
	}
	public int getContrat_id() {
		return contrat_id;
	}
	public void setContrat_id(int contrat_id) {
		this.contrat_id = contrat_id;
	}
	public int getConge_id() {
		return conge_id;
	}
	public void setConge_id(int conge_id) {
		this.conge_id = conge_id;
	}
	public boolean isValidPass() {
		return validPass;
	}
	public void setValidPass(boolean validPass) {
		this.validPass = validPass;
	}
	public boolean isValidId() {
		return validId;
	}
	public void setValidId(boolean validId) {
		this.validId = validId;
	}
	private boolean validPass = false;
	private boolean validId = false;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
		
	public String getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(String date) {
		this.dateNaissance = date;
	}
	public String getCv() {
		return cv;
	}
	public void setCv(String cv) {
		this.cv = cv;
	}
	public boolean isValidPass(String username, String pass ) {
		if(pass.equals(password) && username.equals(username)) validPass = true ;
			return validPass ; 
	}
	public boolean isValidId(int id ) {
		if(this.id == id) validId = true ;
			return validId ; 
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
	
	

}

