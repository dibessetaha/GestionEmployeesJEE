package com.webproject.conges.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.webproject.bdd.CongEnAttente;
import com.webproject.bdd.Congees;
import com.webproject.beans.CongeEnDemande;

/**
 * Servlet implementation class refuserConge
 */
public class refuserConge extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public refuserConge() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CongEnAttente congees = new CongEnAttente() ;
		congees.refuserCongee(Integer.parseInt(request.getParameter("id")))  ; 
		List<CongeEnDemande> listCongees= congees.getConges()  ; 
	  	request.setAttribute("congees", listCongees);
		this.getServletContext().getRequestDispatcher("/Users/RH/congeEnAttente.jsp").forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
