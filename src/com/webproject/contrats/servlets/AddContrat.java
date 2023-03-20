package com.webproject.contrats.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.webproject.bdd.Contrats;
import com.webproject.bdd.Users;
import com.webproject.beans.Contrat;
import com.webproject.beans.User;

/**
 * Servlet implementation class AddContrat
 */
public class AddContrat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddContrat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
 		this.getServletContext().getRequestDispatcher("/Contrats/addContrat.jsp").forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Contrat contrat = new Contrat() ; 
		contrat.setTitle(request.getParameter("title"));
		contrat.setType(request.getParameter("type")) ; 
		contrat.setEtat(Boolean.parseBoolean(request.getParameter("etat")));
		Contrats listContrat = new Contrats() ; 
		listContrat.addContrat(contrat);
		request.setAttribute("contrats", listContrat.getContrats()) ; 
 		this.getServletContext().getRequestDispatcher("/Contrats/contrats.jsp").forward(request, response); 
		
	}

}
