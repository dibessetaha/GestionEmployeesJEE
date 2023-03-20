package com.webproject.contrats.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.webproject.bdd.Users;
import com.webproject.beans.User;

/**
 * Servlet implementation class AssociateContrat
 */
public class AssociateContrat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssociateContrat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int user_id = Integer.parseInt(request.getParameter("user_id")) ; 
		int contrat_id = Integer.parseInt(request.getParameter("contrat_id")) ; 
		double salary = Double.parseDouble(request.getParameter("salary")) ; 
		String debut = request.getParameter("dateContratDebut") ; 
		String fin = request.getParameter("dateContratDebut") ; 
		Users users = new Users() ;
		users.associateContrat(user_id, contrat_id,debut, fin,salary) ; 
		List<User> listUsers = users.getEmployees("emp")  ; 
	  	request.setAttribute("users", listUsers);
 		this.getServletContext().getRequestDispatcher("/Users/RH/emp.jsp").forward(request, response); 

	}

}
