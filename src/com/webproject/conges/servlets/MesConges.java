package com.webproject.conges.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.webproject.bdd.CongEnAttente;
import com.webproject.bdd.Congees;
import com.webproject.beans.Conge;
import com.webproject.beans.CongeEnDemande;
import com.webproject.servlets.Login;

/**
 * Servlet implementation class MesConges
 */
public class MesConges extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MesConges() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CongEnAttente congees = new CongEnAttente() ; 
//		HttpSession session = request.getSession() ; 
//		System.out.println((int)session.getAttribute("id"));
		List<CongeEnDemande> listCongees= congees.getUserCongee(Login.user.getId())  ; 
	  	request.setAttribute("congees", listCongees);
		this.getServletContext().getRequestDispatcher("/Conges/mesConges.jsp").forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
