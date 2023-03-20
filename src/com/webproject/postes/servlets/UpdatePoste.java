package com.webproject.postes.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.webproject.bdd.Postes;
import com.webproject.bdd.Users;
import com.webproject.beans.Poste;
import com.webproject.beans.User;

/**
 * Servlet implementation class UpdatePoste
 */
public class UpdatePoste extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePoste() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt( request.getParameter("id")) ; 
		Postes postes = new Postes() ; 
		List<Poste> listPostes = postes.getPostes()  ; 
		 for (int i = 0; i < listPostes.size(); i++) {
		      if(listPostes.get(i).isValidId(id)) {
		    	  	request.setAttribute("poste", listPostes.get(i)) ; 
		   			this.getServletContext().getRequestDispatcher("/Postes/updatePoste.jsp").forward(request, response); 
		    	  
		      }
	
		      
		 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Poste poste = new Poste() ;
		poste.setId(Integer.parseInt(request.getParameter("id"))) ; 
		poste.setIntitule(request.getParameter("intitule"));
		poste.setPlaceVide(Integer.parseInt(request.getParameter("placeVide")));
		Postes listPoste= new Postes() ; 
		listPoste.updatePoste(poste,poste.getId());
		request.setAttribute("postes", listPoste.getPostes()) ; 
 		this.getServletContext().getRequestDispatcher("/Postes/postes.jsp").forward(request, response); 
	}

}
