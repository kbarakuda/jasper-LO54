package fr.utbm.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
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
	
	public List<CourseSession> getListCourseSessionByTerm(String term) {
		jDAO = new JasperDAO();
		return jDAO.getListCourseSessionByTerm(term);
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

	public int saveClient(Client c) {
		jDAO = new JasperDAO();
		return jDAO.saveClient(c);
	}

	public LinkedList<String> getLieuFormation(List<CourseSession> list) {
		LinkedList<String> listLieu = new LinkedList<String>();
		for (CourseSession courseSession : list) {
			if(!listLieu.contains(courseSession.getLocation().getCity()))
				listLieu.add(courseSession.getLocation().getCity()); 
		}
		return listLieu;
	}

	public List<CourseSession> getListCourseSessionByTerms(HashMap<String, String> searchMap) {
		jDAO = new JasperDAO();
		return jDAO.getListCourseSessionByTerms(searchMap);
		
	}
}
