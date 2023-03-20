package com.webproject.conges.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.webproject.bdd.Congees;
import com.webproject.bdd.Users;
import com.webproject.beans.Conge;
import com.webproject.beans.User;
import com.webproject.servlets.Login;

/**
 * Servlet implementation class ListCongees
 */
public class ListCongees extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCongees() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Congees congees = new Congees() ; 
		List<Conge> listCongees= congees.getConges()  ; 

		  	request.setAttribute("congees", listCongees);
	  		this.getServletContext().getRequestDispatcher("/Conges/congees.jsp").forward(request, response); 
	 

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
