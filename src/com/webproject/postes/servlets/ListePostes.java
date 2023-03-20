package com.webproject.postes.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.webproject.bdd.Postes;
import com.webproject.beans.Poste;



/**
 * Servlet implementation class ListePostes
 */
public class ListePostes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ListePostes() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Postes postes = new Postes() ; 
		List<Poste> listePostes = postes.getPostes()  ; 
	  	request.setAttribute("postes", listePostes);
 		this.getServletContext().getRequestDispatcher("/Postes/postes.jsp").forward(request, response); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
