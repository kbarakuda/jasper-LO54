package fr.utbm.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.utbm.entity.Client;
import fr.utbm.entity.CourseSession;
import fr.utbm.service.CourseService;
import fr.utbm.service.ReportService;



/**
 * Servlet implementation class Home
 */
@WebServlet(name="HomeServlet", urlPatterns="/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CourseService cs = new CourseService();
		if(request.getParameter("generatePDF")!=null) {
			ReportService rs = new ReportService();
			CourseSession c = cs.getCourseSessionById(new Integer(request.getParameter("generatePDF")));
			rs.generateReport(c);
			
			response.sendRedirect( request.getContextPath() + "/downloads/InscritsCourseReport.pdf");
		}else {
			
			List<CourseSession> list;
			HashMap<String, String> searchMap = new HashMap<String, String>();
			int search = 0;
			if(request.getParameter("searchTerm")!=null && !request.getParameter("searchTerm").isEmpty()) {
				searchMap.put("searchTerm", request.getParameter("searchTerm").toUpperCase());
				search=1;
			}
			if(request.getParameter("date")!=null && !request.getParameter("date").isEmpty()) {
				searchMap.put("date",request.getParameter("date"));
				search=1;
			}
			if(request.getParameter("lieuFormation")!=null && !request.getParameter("lieuFormation").isEmpty()) {
				searchMap.put("lieuFormation", request.getParameter("lieuFormation").toUpperCase());
				search=1;
			} 
			
			if(search==1) {
				list = cs.getListCourseSessionByTerms(searchMap); 
			}
			else {
				list = cs.getListCourseSession();
			}
			List<String> listLieuFormation = cs.getLieuFormation(list);
			request.setAttribute("listCourseSession", list); 
			request.setAttribute("listLieuFormation", listLieuFormation); 
			this.getServletContext().getRequestDispatcher("/defaultPage.jsp").forward(request, response);
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Sauvegarde de l'utilisateur
		CourseService cs = new CourseService();
		CourseSession courseSession = cs.getCourseSessionById(new Integer(request.getParameter("couseSessionId")));
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
