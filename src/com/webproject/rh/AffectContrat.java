package com.webproject.rh;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.webproject.bdd.Contrats;
import com.webproject.bdd.Users;
import com.webproject.beans.Contrat;
import com.webproject.beans.User;

/**
 * Servlet implementation class AffectContrat
 */
public class AffectContrat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AffectContrat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Contrats tableNoms = new Contrats() ; 
		List<Contrat> listUsers = tableNoms.getContrats()  ; 
		request.setAttribute("contrats", listUsers) ;
		request.setAttribute("user_id",Integer.parseInt(request.getParameter("user_id"))) ; 
		 this.getServletContext().getRequestDispatcher("/Users/RH/affectContrat.jsp").forward(request, response); 	

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int user_id = Integer.parseInt(request.getParameter("user_id")) ; 
		int contrat_id = Integer.parseInt(request.getParameter("contrat_id")) ; 
	  	request.setAttribute("user_id", user_id);
	  	request.setAttribute("contrat_id", contrat_id);
 		this.getServletContext().getRequestDispatcher("/Users/RH/rangeTemps.jsp").forward(request, response); 
	}

}
