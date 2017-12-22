package fr.utbm.repository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import fr.utbm.entity.Client;
import fr.utbm.entity.Course;
import fr.utbm.entity.CourseSession;
import fr.utbm.util.FormatProcess;
import fr.utbm.util.HibernateUtil;

public class JasperDAO {
	private Session session;

	public int saveClient(Client c) {
		session = HibernateUtil.getSessionFactory().openSession();
		int result = 1;
		try {
			session.beginTransaction();
			session.persist(c);
			session.getTransaction().commit();
		} catch (HibernateException he) {
			he.printStackTrace();
			if (session.getTransaction() != null) {
				try {
					session.getTransaction().rollback();
				} catch (HibernateException he2) {
					he2.printStackTrace();
				}
			}
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (HibernateException he3) {
					he3.printStackTrace();
				}
			}
		}
		return result;
	}

 
	public List<CourseSession> getListCourseSession() {
		session = HibernateUtil.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<CourseSession> courseList = session.createQuery("from CourseSession as cs ORDER BY cs.course.code,cs.startDate").getResultList();
		session.close();
		return courseList;
	}

	public CourseSession getCourseSessionById(int id) {
		session = HibernateUtil.getSessionFactory().openSession();
		CourseSession courseSession = null;
		try {
			courseSession = (CourseSession) session.createQuery("from CourseSession as cs WHERE cs.id = :id")
					.setParameter("id", id).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (HibernateException he3) {
					he3.printStackTrace();
				}
			}
		}
		return courseSession;
	}

	public ArrayList<String> getListCourseByTitle(String term) {
		session = HibernateUtil.getSessionFactory().openSession();

		// .setParameter(0, FormatProcess.concactQuery(term))
		@SuppressWarnings("unchecked")
		List<Course> courseList = session
				.createQuery("from Course as c Where upper(c.title) like :term OR upper(c.code) like :term")
				.setParameter("term", FormatProcess.concactQuery(term)).getResultList();
		ArrayList<String> courseListTitle = new ArrayList<String>();
		for (Course course : courseList) {
			courseListTitle.add(course.getTitle());
		}
		session.close();
		return courseListTitle;
	}

	public List<CourseSession> getListCourseSessionByTerm(String term) {
		session = HibernateUtil.getSessionFactory().openSession();
		// .setParameter("term", FormatProcess.concactQuery(term.toUpperCase()))

		@SuppressWarnings("unchecked")
		List<CourseSession> courseList = session.createQuery(
				"from CourseSession as cs Where upper(cs.course.title) like :term OR upper(cs.course.code) like :term")
				.setParameter("term", FormatProcess.concactQuery(term.toUpperCase())).getResultList();
		session.close();
		return courseList;
	}

	public List<CourseSession> getListCourseSessionByTerms(HashMap<String, String> searchMap) {

		session = HibernateUtil.getSessionFactory().openSession();
		String query = "";
		for (Map.Entry<String, String> entry : searchMap.entrySet()) {
			if (entry.getKey().equals("searchTerm")) {
				if (query.isEmpty())
					query += " (upper(cs.course.title) like :searchTerm OR upper(cs.course.code) like :searchTerm)";
				else
					query += " AND (upper(cs.course.title) like :searchTerm OR upper(cs.course.code) like :searchTerm)";
			}
			if (entry.getKey().equals("date")) {
				if (query.isEmpty())
					query += " (:date Between cs.startDate AND cs.endDate)";
				else
					query += " AND (:date Between cs.startDate AND cs.endDate)";
			}
			if (entry.getKey().equals("lieuFormation")) {
				if (query.isEmpty())
					query += " (upper(cs.location.city) = :lieuFormation)";
				else
					query += " AND (upper(cs.location.city) = :lieuFormation)";
			}
		}
		@SuppressWarnings("rawtypes")
		Query q = session.createQuery("from CourseSession as cs Where " + query);
		for (Map.Entry<String, String> entry : searchMap.entrySet()) {
			if (entry.getKey().equals("date")) {
				try {
					DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm",Locale.FRANCE);
					Date date = formatter.parse(searchMap.get("date"));
					System.out.println(date);
					q.setParameter("date", date);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			} else {
				q.setParameter(entry.getKey(), entry.getValue());
			}
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

		@SuppressWarnings("unchecked")
		List<CourseSession> courseList = q.getResultList();
		session.close();
		return courseList;
	}


	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}


	public void closeSession() {
		this.session.close();
	}

}
