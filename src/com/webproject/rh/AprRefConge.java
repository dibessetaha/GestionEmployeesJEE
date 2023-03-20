package com.webproject.rh;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.webproject.bdd.CongEnAttente;
import com.webproject.beans.CongeEnDemande;
import com.webproject.servlets.Login;

/**
 * Servlet implementation class AprRefConge
 */
public class AprRefConge extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AprRefConge() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CongEnAttente congees = new CongEnAttente() ; 
		List<CongeEnDemande> listCongees= congees.getConges()  ; 
	  	request.setAttribute("congees", listCongees);
		this.getServletContext().getRequestDispatcher("/Users/RH/congeEnAttente.jsp").forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CongEnAttente congees = new CongEnAttente() ; 
//		HttpSession session = request.getSession() ; 
//		System.out.println((int)session.getAttribute("id"));
		congees.approuveCongee(Integer.parseInt(request.getParameter("id")))  ; 
		List<CongeEnDemande> listCongees= congees.getConges()  ; 
	  	request.setAttribute("congees", listCongees);
		this.getServletContext().getRequestDispatcher("/Users/RH/congeEnAttente.jsp").forward(request, response); 
		
	}

}
