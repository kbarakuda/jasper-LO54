package fr.utbm.app;

import java.util.List;

import fr.utbm.entity.Course;
import fr.utbm.entity.CourseSession;
import fr.utbm.repository.JasperDAO;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method st
		JasperDAO jDAO = new JasperDAO();
		List<CourseSession> list = jDAO.getListCourseSession();
		
		for (CourseSession course : list) {
			System.out.println(course);
		}
	}
}
