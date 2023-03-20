package com.webproject.bdd;


import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.webproject.beans.Conge;

public class Congees {
	private Connection conn ; 
	public List<Conge> getConges() {
		List<Conge> conges = new ArrayList<Conge>() ; 
		Statement st=null;
		ResultSet rs = null;
		//Connection a la base de donnees 
		loadDatabase() ; 
	
		try {
    		String sql="select * from congees ";
    		st = conn.createStatement();
    		System.out.println("Succes d'exec de la requete!!");
    		rs=st.executeQuery(sql);	
			while(rs.next()) {
				int id = rs.getInt("id")  ;
				String intitule = rs.getString("intitule") ; 
				String reason = rs.getString("reason") ; 
				int nbJour = rs.getInt("nbJour") ; 
				boolean affectSalaire = rs.getBoolean("affectSalaire") ; 
				Conge conge = new Conge() ;
				conge.setId(id);
				conge.setIntitule(intitule);
				conge.setReason(reason);
				conge.setNbJour(nbJour);
				conge.setAffectSalaire(affectSalaire);
				conges.add(conge) ; 
			
		
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
		return conges ; 
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
	    
	  public void addConge(Conge conge ) {
	        loadDatabase();
	        
	        try {
	            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO `congees` (`intitule`, `reason`, `nbJour`, `affectSalaire`) VALUES (?,?,?,?)");
	            preparedStatement.setString(1, conge.getIntitule());
	            preparedStatement.setString(2, conge.getReason());
	            preparedStatement.setInt(3, conge.getNbJour());
	            preparedStatement.setBoolean(4, conge.isAffectSalaire());
	            preparedStatement.executeUpdate();
	            System.out.println("requete insert ok");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
//	  
	  public void updateConge(Conge user, int id) {
	        loadDatabase();
	        
	        try {
	            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE `congees` SET "
	            		+ "`intitule` = ?, `reason` = ?, `nbJour` = ?,"
	            		+ " `affectSalaire` = ? WHERE `congees`.`id` = ?;");
	            preparedStatement.setString(1, user.getIntitule());
	            preparedStatement.setString(2, user.getReason());
	            preparedStatement.setInt(3, user.getNbJour());
	            preparedStatement.setBoolean(4, user.isAffectSalaire());
	            preparedStatement.setInt(5,id);
	            preparedStatement.executeUpdate();
	            System.out.println("requete update ok");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	  
	  public void deleteConge(int id) {
	        loadDatabase();
	        
	        try {
	            PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM `congees` WHERE `congees`.`id` = ?");
	            preparedStatement.setInt(1, id);
	            preparedStatement.executeUpdate() ; 
	            System.out.println("requete delete ok");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
}

