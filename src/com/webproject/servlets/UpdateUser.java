package com.webproject.servlets;

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
 * Servlet implementation class UpdateUser
 */
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt( request.getParameter("id")) ; 
		Users tableNoms = new Users() ; 
		List<User> listUsers = tableNoms.getUsers()  ; 
		 for (int i = 0; i < listUsers.size(); i++) {
		      if(listUsers.get(i).isValidId(id)) {
		    	  	request.setAttribute("user", listUsers.get(i)) ; 
		   			this.getServletContext().getRequestDispatcher("/Users/Admin/update.jsp").forward(request, response); 
		    	  
		      }
	
		      
		 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User() ; 
		user.setId(Integer.parseInt(request.getParameter("id")));
		user.setNom(request.getParameter("nom"));
		user.setPrenom(request.getParameter("prenom")) ; 
	    user.setEmail(request.getParameter("email"));
	    user.setUsername(request.getParameter("username"));
	    user.setPassword(request.getParameter("password"));
	    user.setRole(request.getParameter("role"));
	    user.setCv(request.getParameter("cv"));
	    user.setDateNaissance(request.getParameter("dateNaissance"));
//	    getFileName(request.getPart("contrat"))
		Users tableNoms = new Users() ; 
		tableNoms.updateUser(user,user.getId());
		request.setAttribute("users", tableNoms.getUsers()) ; 
 		this.getServletContext().getRequestDispatcher("/Users/Admin/users.jsp").forward(request, response); 
	}

}
