package fr.utbm.service;

import java.util.ArrayList;
import java.util.List;

import fr.utbm.entity.Client;
import fr.utbm.entity.Course;
import fr.utbm.entity.CourseSession;
import fr.utbm.repository.JasperDAO;

public class CourseService {
	private JasperDAO jDAO;

	public List<Course> getListCourse() {
		jDAO = new JasperDAO();
		return jDAO.getListCourse();
	}
	
	public List<CourseSession> getListCourseSession() {
		jDAO = new JasperDAO();
		return jDAO.getListCourseSession();
	}
	
	public CourseSession getListCourseSessionById(int id) {
		jDAO = new JasperDAO();
		return jDAO.getListCourseSessionById(id);
	}

	public ArrayList<String> getListCourseByTitle(String s) {
		jDAO = new JasperDAO();
		return jDAO.getListCourseByTitle(s);
	}

	public List<Course> getListCourseByDate(String startDate, String endDate) {
		jDAO = new JasperDAO();
		return jDAO.getListCourseByDate(startDate,endDate);
	}

	public List<Course> getListCourseByLocation(String loc) {
		jDAO = new JasperDAO();
		return jDAO.getListCourseByLocation(loc);
	}
	
	public int saveClient(Client c) {
		jDAO = new JasperDAO();
		return jDAO.saveClient(c);
	}
}
