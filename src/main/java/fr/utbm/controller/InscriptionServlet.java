package fr.utbm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.utbm.entity.CourseSession;
import fr.utbm.service.CourseService;

@WebServlet(name="InscriptionServlet", urlPatterns="/registration")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = new Integer(request.getParameter("formation"));
			CourseService cs = new CourseService();
			CourseSession courseSession = cs.getCourseSessionById(id);
			request.setAttribute("courseSession", courseSession);  
			this.getServletContext().getRequestDispatcher("/Inscription.jsp").forward(request, response);
		}catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
