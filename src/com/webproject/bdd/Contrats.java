package com.webproject.bdd;


import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.webproject.beans.Contrat;
import com.webproject.beans.User;

public class Contrats {
	private Connection conn ; 
	public List<Contrat> getContrats() {
		List<Contrat> contrats = new ArrayList<Contrat>() ; 
		
		Statement st=null;
		ResultSet rs = null;
		//Connection a la base de donnees 
		loadDatabase() ; 
	
		try {
    		String sql="select * from contrats ";
    		st = conn.createStatement();
    		System.out.println("Succes d'exec de la requete!!");
    		rs=st.executeQuery(sql);	
			while(rs.next()) {
				int id = rs.getInt("id")  ;
				String title = rs.getString("title") ; 
				String type = rs.getString("type") ; 
				Contrat contrat = new Contrat() ;
				contrat.setId(id);
				contrat.setTitle(title);
				contrat.setType(type);
				contrats.add(contrat) ; 
			
		
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
		return contrats ; 
	}
	
	public List<Contrat> getContratsEncour() {
		List<Contrat> contrats = new ArrayList<Contrat>() ; 
		
		Statement st=null;
		ResultSet rs = null;
		//Connection a la base de donnees 
		loadDatabase() ; 
	
		try {
    		String sql="SELECT * from users u join contrats c where u.contrat_id = c.id and u.contrat_id is not null;"
    				;
    		st = conn.createStatement();
    		System.out.println("Succes d'exec de la requete!!");
    		rs=st.executeQuery(sql);	
			while(rs.next()) {
				int id = rs.getInt("id")  ;
				String title = rs.getString("title") ; 
				String type = rs.getString("type") ; 
				String nom = rs.getString("nom") ; 
				String prenom = rs.getString("prenom") ; 
				String dateDebut = rs.getString("dateContratDebut") ; 
				String dateFin = rs.getString("dateContratfin") ; 
				Contrat contrat = new Contrat() ;
				contrat.setId(id);
				contrat.setTitle(title);
				contrat.setType(type);
				contrat.setNom(nom);
				contrat.setPrenom(prenom);
				contrat.setDateContratDebut(dateDebut);
				contrat.setDateContratFin(dateFin);
				contrats.add(contrat) ; 
			
		
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
		return contrats ; 
	}
	
	public Contrat getOneContrat(int user_id) {
		Contrat contrat = new Contrat() ; 
		
		Statement st=null;
		ResultSet rs = null;
		//Connection a la base de donnees 
		loadDatabase() ; 
	
		try {
    		String sql="SELECT * from users u join contrats c where u.contrat_id = c.id and u.id = ?;" ; 
    		PreparedStatement preparedStatement = conn.prepareStatement(sql);
    		preparedStatement.setInt(1,user_id);
    		rs = preparedStatement.executeQuery() ; 
    		System.out.println("Succes d'exec de la requete getOneContrat!!");
			while(rs.next()) {
				int id = rs.getInt("id")  ;
				String title = rs.getString("title") ; 
				String type = rs.getString("type") ; 
				String nom = rs.getString("nom") ; 
				String prenom = rs.getString("prenom") ; 
				String dateDebut = rs.getString("dateContratDebut") ; 
				String dateFin = rs.getString("dateContratfin") ; 
				double salary = rs.getDouble("salary") ; 
				contrat.setSalary(salary);
				contrat.setId(id);
				contrat.setTitle(title);
				contrat.setType(type);
				contrat.setNom(nom);
				contrat.setPrenom(prenom);
				contrat.setDateContratDebut(dateDebut);
				contrat.setDateContratFin(dateFin);
				
			
		
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
		return contrat ; 
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
	    
	  public void addContrat(Contrat contrat ) {
	        loadDatabase();
	        
	        try {
	            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO `contrats` (`title`,`type`, `etat`) VALUES (?, ?, ?);");
	            preparedStatement.setString(1, contrat.getTitle());
	            preparedStatement.setString(2, contrat.getType());
	            preparedStatement.setBoolean(3, contrat.isEtat());
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
	  
	  public void deleteUser(int id) {
	        loadDatabase();
	        
	        try {
	            PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM `users` WHERE `users`.`id` = ?");
	            preparedStatement.setInt(1, id);
	      
	            System.out.println("requete delete ok");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
}

