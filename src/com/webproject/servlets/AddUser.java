package com.webproject.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.webproject.bdd.Postes;
import com.webproject.bdd.Users;
import com.webproject.beans.Poste;
import com.webproject.beans.User;


/**
 * Servlet implementation class AddUser
 */
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Postes postes = new Postes() ;
		List<Poste> listPostes= postes.getPostes()  ; 
	  	request.setAttribute("postes", listPostes );
 		this.getServletContext().getRequestDispatcher("/Users/Admin/addUser.jsp").forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String description = request.getParameter("description") ; 
//		request.setAttribute("description", description);
//		String msg = "" ; 
//		try {
//			Part part =  request.getPart("contrat") ; 
//			System.out.println(part);
//			part.write(getFileName(part)) ; 
//			msg = "successfully" ; 
//			
//		}catch(Exception e) {
//			msg = "something wrong" ; 
//			e.printStackTrace() ; 
//		}
//		request.setAttribute("msg", msg) ;		
		User user = new User() ; 
		user.setNom(request.getParameter("nom"));
		user.setPrenom(request.getParameter("prenom")) ; 
	    user.setEmail(request.getParameter("email"));
	    user.setUsername(request.getParameter("username"));
	    user.setPassword(request.getParameter("password"));
	    user.setRole(request.getParameter("role"));
	    user.setCv(request.getParameter("cv"));
	    user.setPoste_id(Integer.parseInt(request.getParameter("poste_id")));
	    user.setDateNaissance(request.getParameter("dateNaissance"));
		Users tableNoms = new Users() ; 
		tableNoms.addUser(user);
		request.setAttribute("users", tableNoms.getUsers()) ; 
 		this.getServletContext().getRequestDispatcher("/Users/Admin/users.jsp").forward(request, response); 
	}

}
