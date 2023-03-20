package com.webproject.bdd;


import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.webproject.beans.CongeEnDemande;
import com.webproject.beans.User;

public class Users {
	private Connection conn ; 
	
	
	public List<User> getEmployees(String r) {
		List<User> users = new ArrayList<User>() ; 
		Statement st=null;
		ResultSet rs = null;
		//Connection a la base de donnees 
		loadDatabase() ; 
	
		try {
    		String sql="select * from users where role = ? and contrat_id is NULL";
    		PreparedStatement preparedStatement = conn.prepareStatement(sql);
    		preparedStatement.setString(1,r);
    		rs = preparedStatement.executeQuery() ; 
    		System.out.println("Succes d'exec de la requete!!");
			while(rs.next()) {
				int id = rs.getInt("id")  ;
				String prenom = rs.getString("prenom") ; 
				String nom = rs.getString("nom") ; 
				String dateNaissance = rs.getString("dateNaissance") ; 
				String email = rs.getString("email") ; 
				String cv = rs.getString("cv") ;
				int poste_id = rs.getInt("poste_id") ;
				int contrat_id = rs.getInt("poste_id") ;
				User user = new User() ;
				user.setId(id);
				user.setNom(nom);
				user.setNom(nom);
				user.setCv(cv);
				user.setPrenom(prenom);
				user.setDateNaissance(dateNaissance);
				user.setEmail(email);
				user.setPoste_id(poste_id);
				user.setContrat_id(contrat_id);
				users.add(user);
		
		
		}
		}catch(SQLException e) {
			System.out.println(e);
			
		}finally {
			try {
				
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (conn != null)
					conn.close();
		}catch(SQLException e) {
			
		}
		}
		return users ; 
	}
	
	public List<User> getWithContrat(String r) {
		List<User> users = new ArrayList<User>() ; 
		Statement st=null;
		ResultSet rs = null;
		//Connection a la base de donnees 
		loadDatabase() ; 
	
		try {
    		String sql="select * from users u join contrats c where u.contrat_id = c.id and role = ? and contrat_id is not NULL";
    		PreparedStatement preparedStatement = conn.prepareStatement(sql);
    		preparedStatement.setString(1,r);
    		rs = preparedStatement.executeQuery() ; 
    		System.out.println("Succes d'exec de la requete!!");
			while(rs.next()) {
				int id = rs.getInt("id")  ;
				String prenom = rs.getString("prenom") ; 
				String nom = rs.getString("nom") ; 
				String dateNaissance = rs.getString("dateNaissance") ; 
				String email = rs.getString("email") ; 
				String cv = rs.getString("cv") ;
				String typeContrat = rs.getString("type") ; 
				String dateContratDebut = rs.getString("dateContratDebut") ; 
				String dateContratDFin = rs.getString("dateContratDebut") ; 
				double salary = rs.getDouble("salary") ; 
				User user = new User() ;
				user.setId(id);
				user.setNom(nom);
				user.setNom(nom);
				user.setCv(cv);
				user.setPrenom(prenom);
				user.setDateNaissance(dateNaissance);
				user.setEmail(email);
				user.setTypeContrat(typeContrat);
				user.setDateContratDebut(dateContratDebut);
				user.setDateContratFin(dateContratDFin);
				user.setSalary(salary);
				users.add(user);
		
		
		}
		}catch(SQLException e) {
			System.out.println(e);
			
		}finally {
			try {
				
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (conn != null)
					conn.close();
		}catch(SQLException e) {
			
		}
		}
		return users ; 
	}
	
	public List<User> getUsers() {
		List<User> users = new ArrayList<User>() ; 
		
		Statement st=null;
		ResultSet rs = null;
		//Connection a la base de donnees 
		loadDatabase() ; 
	
		try {
    		String sql="select * from users";
    		st = conn.createStatement();
    		System.out.println("Succes d'exec de la requete!!");
    		rs=st.executeQuery(sql);	
			while(rs.next()) {
				int id = rs.getInt("id")  ;
				String username = rs.getString("username") ; 
				String nom = rs.getString("nom") ; 
				String prenom = rs.getString("prenom") ; 
				String pass = rs.getString("password") ; 
				String role = rs.getString("role") ; 
				String dateNaissance = rs.getString("dateNaissance") ; 
				String email = rs.getString("email") ; 
				int poste = rs.getInt("poste_id") ; 
				String cv = rs.getString("cv") ; 
				User user = new User() ;
				user.setId(id);
				user.setPoste_id(poste);
				user.setUsername(username);
				user.setPassword(pass);
				user.setRole(role);
				user.setNom(nom);
				user.setCv(cv);
				user.setPrenom(prenom);
				user.setDateNaissance(dateNaissance);
				user.setEmail(email);
				users.add(user) ; 
			
		
		}
		}catch(SQLException e) {
			System.out.println(e);
			
		}finally {
			try {
				
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (conn != null)
					conn.close();
		}catch(SQLException e) {
			
		}
		}
		return users ; 
	}
	
	  private void loadDatabase() {
	        // Chargement du driver
	        try {
	        	Class.forName("com.mysql.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	        }

	        try {
	            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdjee","root","");
	            System.out.println("Connexion OK");
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	    }
	    
	  public void addUser(User user) {
	        loadDatabase();
	        
	        try {
	            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO `users` (`nom`, `prenom`, `email`, `password`, `username`, `cv`, `dateNaissance`, `role`, `poste_id`) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?);");
	            preparedStatement.setString(1, user.getNom());
	            preparedStatement.setString(2, user.getPrenom());
	            preparedStatement.setString(3, user.getEmail());
	            preparedStatement.setString(4, user.getPassword());
	            preparedStatement.setString(5, user.getUsername());
	            preparedStatement.setString(6, user.getCv());
	            preparedStatement.setString(7, user.getDateNaissance());
	            preparedStatement.setString(8, user.getRole());
	            preparedStatement.setInt(9, user.getPoste_id());
	            preparedStatement.executeUpdate();
	            System.out.println("requete insert ok");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	  
	  public void updateUser(User user, int id) {
	        loadDatabase();
	        
	        try {
	            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE `users` SET "
	            		+ "`nom` = ?, `prenom` = ?, `email` = ?,"
	            		+ " `password` = ?, `username` = ?, `cv` = ?,"
	            		+ " `dateNaissance` = ?, `role` = ?  WHERE `users`.`id` = ?;");
	            preparedStatement.setString(1, user.getNom());
	            preparedStatement.setString(2, user.getPrenom());
	            preparedStatement.setString(3, user.getEmail());
	            preparedStatement.setString(4, user.getPassword());
	            preparedStatement.setString(5, user.getUsername());
	            preparedStatement.setString(6, user.getCv());
	            preparedStatement.setString(7, user.getDateNaissance());
	            preparedStatement.setString(8, user.getRole());
	            preparedStatement.setInt(9,id);
	            preparedStatement.executeUpdate();
	            System.out.println("requete update ok");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	  
	  public void associateContrat(int user_id, int contrat_id, String debut, String fin, double salary) {
	        loadDatabase();
	        
	        try {
	            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE `users` SET "
	            		+ "`contrat_id` = ?, `dateContratDebut` = ?, `dateContratFin` = ?, salary = ?"
	            		+ " WHERE `users`.`id` = ?;");
	            User user = new User() ;
				user.setDateContratDebut(debut);
				user.setDateContratFin(fin);
				user.setId(user_id);
				user.setSalary(salary);
	            preparedStatement.setInt(1, contrat_id);
	            preparedStatement.setString(2, user.getDateContratDebut());
	            preparedStatement.setString(3, user.getDateContratFin());
	            preparedStatement.setDouble(4, user.getSalary());
	            preparedStatement.setInt(5, user.getId());
	            preparedStatement.executeUpdate();
	            System.out.println("requete associate ok");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	  
	  
	  public void deleteUser(int id) {
	        loadDatabase();
	        
	        try {
	            PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM `users` WHERE id = ?");
	            preparedStatement.setInt(1, id);
	            preparedStatement.executeUpdate(); 
	            System.out.println(id);
	            System.out.println("requete delete ok");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
}

