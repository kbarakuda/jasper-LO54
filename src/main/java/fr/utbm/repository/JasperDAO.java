package fr.utbm.repository;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import fr.utbm.entity.Client;
import fr.utbm.entity.Course;
import fr.utbm.util.FormatProcess;
import fr.utbm.util.HibernateUtil;

public class JasperDAO {
	private Session session = HibernateUtil.getSessionFactory().openSession();

	public void saveClient(Client c) {

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
	}

	public List<Course> getListCourse() {
		Query query = session.createQuery("from Course");
		List<Course> courseList = query.list();
		return courseList;
	}

	public List<Course> getListCourseByTitle(String term) {
		Query query = session.createQuery("from Course Where title like ? ");
		query.setString(0, FormatProcess.concactQuery(term));
		List<Course> courseList = query.list();
		return courseList;
	}

	public List<Course> getListCourseByDate(String term) {
		Query query = session.createQuery("from Course Where title like ? ");
		query.setString(0, FormatProcess.concactQuery(term));
		List<Course> courseList = query.list();
		return courseList;
	}

	public List<Course> getListCourseByLocation(String term) {
		Query query = session.createQuery("from Course c join Where title like ? ");
		query.setString(0, FormatProcess.concactQuery(term));
		List<Course> courseList = query.list();
		return courseList;
	}
}
