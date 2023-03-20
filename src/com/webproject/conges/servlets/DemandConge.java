package com.webproject.conges.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.webproject.bdd.CongEnAttente;
import com.webproject.bdd.Contrats;
import com.webproject.beans.CongeEnDemande;
import com.webproject.beans.Contrat;
import com.webproject.servlets.Login;

/**
 * Servlet implementation class DemandConge
 */
public class DemandConge extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemandConge() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("user", Login.user) ; 
 		this.getServletContext().getRequestDispatcher("/Conges/demandeConge.jsp").forward(request, response); 

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CongeEnDemande conge = new CongeEnDemande() ; 
		conge.setUser_id(Integer.parseInt(request.getParameter("user_id")));
		conge.setCongee_id(Integer.parseInt(request.getParameter("id"))) ; 
		conge.setDateDebut(request.getParameter("dateDebut"));
		conge.setDateFin(request.getParameter("dateFin"));
		CongEnAttente congees = new CongEnAttente() ; 
		congees.addCongeEnDemande(conge);
		request.setAttribute("congees", congees.getUserCongee(Integer.parseInt(request.getParameter("user_id")))) ; 
 		this.getServletContext().getRequestDispatcher("/mesconges").forward(request, response); 
	}

}
