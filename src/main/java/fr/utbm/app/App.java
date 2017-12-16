package fr.utbm.app;

import java.io.IOException;
import java.util.List;

import fr.utbm.entity.CourseSession;
import fr.utbm.repository.JasperDAO;
import fr.utbm.service.ReportService;

public class App {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method st
		JasperDAO jDAO = new JasperDAO();
		List<CourseSession> list = jDAO.getListCourseSessionByTerm("AD");
		
		ReportService rs = new ReportService();
		
		rs.generateReport(list.get(0));
		
		
	}
}
