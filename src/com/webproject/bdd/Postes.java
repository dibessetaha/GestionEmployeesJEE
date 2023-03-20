package com.webproject.bdd;


import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.webproject.beans.Poste;


public class Postes {
	private Connection conn ; 
	public List<Poste> getPostes() {
		List<Poste> postes = new ArrayList<Poste>() ; 
		
		Statement st=null;
		ResultSet rs = null;
		//Connection a la base de donnees 
		loadDatabase() ; 
	
		try {
    		String sql="select * from postes ";
    		st = conn.createStatement();
    		System.out.println("Succes d'exec de la requete!!");
    		rs=st.executeQuery(sql);	
			while(rs.next()) {
				int id = rs.getInt("id")  ;
				String intitule = rs.getString("intitule") ; 
				int placeVide = rs.getInt("placeVide")  ;
				Poste poste = new Poste() ;
				poste.setId(id);
				poste.setIntitule(intitule);
				poste.setPlaceVide(placeVide);
				postes.add(poste); 
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
		return postes ; 
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
	    
	  public void addPoste(Poste contrat ) {
	        loadDatabase();
	        
	        try {
	            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO `postes` (`intitule`, `placeVide`) VALUES (?, ?)");
	            preparedStatement.setString(1, contrat.getIntitule());
	            preparedStatement.setInt(2, contrat.getPlaceVide());
	            preparedStatement.executeUpdate();
	            System.out.println("requete insert ok");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	  
	  public void updatePoste(Poste poste, int id) {
	        loadDatabase();
	        
	        try {
	            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE `postes` SET "
	            		+ "`intitule` = ?, `placeVide` = ? WHERE `postes`.`id` = ?;");
	            preparedStatement.setString(1, poste.getIntitule());
	            preparedStatement.setInt(2, poste.getPlaceVide());
	            preparedStatement.setInt(3,id);
	            preparedStatement.executeUpdate();
	            System.out.println("requete update ok");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	  
	  public void deletePoste(int id) {
	        loadDatabase();
	        
	        try {
	            PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM `postes` WHERE `postes`.`id` = ?");
	            preparedStatement.setInt(1, id);
	            preparedStatement.executeUpdate() ; 
	            System.out.println("requete delete ok");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
}

