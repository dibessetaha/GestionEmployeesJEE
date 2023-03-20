package com.webproject.conges.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.webproject.bdd.Congees;
import com.webproject.bdd.Postes;
import com.webproject.beans.Conge;
import com.webproject.beans.Poste;

/**
 * Servlet implementation class UpdateCongee
 */
public class UpdateCongee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCongee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id")) ; 
		Congees congees = new Congees() ; 
		List<Conge> listConges= congees.getConges()  ; 
		 for (int i = 0; i < listConges.size(); i++) {
		      if(listConges.get(i).isValidId(id)) {
		    	  	request.setAttribute("conge", listConges.get(i)) ; 
		   			this.getServletContext().getRequestDispatcher("/Conges/UpdateConge.jsp").forward(request, response); 
		    	  
		      }
	
		      
		 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Conge conge = new Conge() ;
		conge.setId(Integer.parseInt(request.getParameter("id"))) ; 
		conge.setNbJour(Integer.parseInt(request.getParameter("nbJour"))) ; 
		conge.setIntitule(request.getParameter("intitule"));
		conge.setReason(request.getParameter("reason"));
		conge.setAffectSalaire(Boolean.parseBoolean(request.getParameter("affectSalaire")));
		Congees listconge= new Congees() ; 
		listconge.updateConge(conge,conge.getId());
		request.setAttribute("congees", listconge.getConges()) ; 
 		this.getServletContext().getRequestDispatcher("/Users/Admin/congees.jsp").forward(request, response); 
	}

}
