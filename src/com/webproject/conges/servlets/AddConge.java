package com.webproject.conges.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.webproject.bdd.Congees;
import com.webproject.bdd.Postes;
import com.webproject.beans.Conge;
import com.webproject.beans.Poste;

/**
 * Servlet implementation class AddConge
 */
public class AddConge extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddConge() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
 		this.getServletContext().getRequestDispatcher("/Conges/addCongee.jsp").forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Conge conge = new Conge() ;
System.out.println(Boolean.parseBoolean(request.getParameter("affectSalaire")));
		conge.setNbJour(Integer.parseInt(request.getParameter("nbJour"))) ; 
		conge.setIntitule(request.getParameter("intitule"));
		conge.setReason(request.getParameter("reason"));
		conge.setAffectSalaire(Boolean.parseBoolean(request.getParameter("affectSalaire")));
		Congees listconge= new Congees() ; 
		listconge.addConge(conge);
		request.setAttribute("congees", listconge.getConges()) ; 
 		this.getServletContext().getRequestDispatcher("/Users/Admin/congees.jsp").forward(request, response); 
	}

}
