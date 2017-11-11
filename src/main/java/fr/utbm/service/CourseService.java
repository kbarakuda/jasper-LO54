package fr.utbm.service;

import java.util.List;

import org.hibernate.query.Query;

import fr.utbm.entity.Course;
import fr.utbm.repository.JasperDAO;

public class CourseService {
	private JasperDAO jDAO;

	public List<Course> getListCourse() {
		return jDAO.getListCourse();
	}

	public List<Course> getListCourseByTitle(String s) {
		return jDAO.getListCourseByTitle(s);
	}

	public List<Course> getListCourseByDate(String date) {
		return jDAO.getListCourseByDate(date);
	}

	public List<Course> getListCourseByLocation(String loc) {
		return jDAO.getListCourseByLocation(loc);
	}
}
