package fr.utbm.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import fr.utbm.service.CourseService;

@WebServlet(name="SearchController", urlPatterns="/searchJSON")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 protected void doGet(HttpServletRequest request,
             HttpServletResponse response) throws ServletException, IOException {

             response.setContentType("application/json");
             try {
                     String term = request.getParameter("term");

                     CourseService cs = new CourseService();
                     ArrayList<String> list = cs.getListCourseByTitle(term.toUpperCase()); 
                     String searchList = new Gson().toJson(list);
                     response.getWriter().write(searchList);
             } catch (Exception e) {
                     System.err.println(e.getMessage());
             }
     }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}
}
