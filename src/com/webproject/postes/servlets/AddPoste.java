package com.webproject.postes.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.webproject.bdd.Postes;
import com.webproject.beans.Poste;



/**
 * Servlet implementation class AddPoste
 */
public class AddPoste extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AddPoste() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		this.getServletContext().getRequestDispatcher("/Postes/addPoste.jsp").forward(request, response); 

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Poste poste = new Poste() ; 
		poste.setIntitule(request.getParameter("intitule"));
		poste.setPlaceVide(Integer.parseInt(request.getParameter("placeVide")));
		Postes listPoste= new Postes() ; 
		listPoste.addPoste(poste);
		request.setAttribute("postes", listPoste.getPostes()) ; 
 		this.getServletContext().getRequestDispatcher("/Postes/postes.jsp").forward(request, response); 
	}

}
