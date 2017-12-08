package fr.utbm.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.utbm.entity.Client;
import fr.utbm.entity.CourseSession;
import fr.utbm.service.CourseService;


/**
 * Servlet implementation class Home
 */
@WebServlet(name="HomeServlet", urlPatterns="/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CourseService cs = new CourseService();
		List<CourseSession> list;
		if(request.getParameter("searchTerm") != null) {
			list = cs.getListCourseSession();
		}else {
			list = cs.getListCourseSession();
		}
		request.setAttribute("listCourseSession", list);  
		this.getServletContext().getRequestDispatcher("/defaultPage.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Sauvegarde de l'utilisateur
		CourseService cs = new CourseService();
		CourseSession courseSession = cs.getListCourseSessionById(new Integer(request.getParameter("couseSessionId")));
		String lastName = request.getParameter("lastName");
		String firstName = request.getParameter("firstName");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		Client c = new Client(courseSession, lastName, firstName, address, phone,email);
		
		int result = cs.saveClient(c);
		List<CourseSession> list = cs.getListCourseSession();
		request.setAttribute("listCourseSession", list); 
		this.getServletContext().getRequestDispatcher("/defaultPage.jsp?save="+result).forward(request, response);
		//doGet(request, response);
	}

}
