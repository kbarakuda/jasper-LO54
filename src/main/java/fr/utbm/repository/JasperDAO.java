package fr.utbm.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

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

	public List<Course> getListCourse() {
		session = HibernateUtil.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<Course> courseList = session.createQuery("from Course")
									.getResultList() ;
		return courseList;
	}
	
	public List<CourseSession> getListCourseSession() {
		session = HibernateUtil.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<CourseSession> courseList = session.createQuery("from COURSE_SESSION")
									.getResultList() ;
		session.close();
		return courseList;
	}
	
	public CourseSession getListCourseSessionById(int id) {
		session = HibernateUtil.getSessionFactory().openSession();
		CourseSession courseSession = null;
		try {
			courseSession = (CourseSession) session.createQuery("from COURSE_SESSION WHERE course_session_id = :id")
					.setParameter("id", id)
					.getSingleResult();
		}catch (Exception e) {
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
		
		//.setParameter(0, FormatProcess.concactQuery(term))
		@SuppressWarnings("unchecked")
		List<Course> courseList = session.createQuery("from Course Where upper(title) like :term OR upper(course_code) like :term")
									.setParameter("term", FormatProcess.concactQuery(term))
									.getResultList() ;
		ArrayList<String> courseListTitle = new ArrayList<String>();
		for (Course course : courseList) {
			courseListTitle.add(course.getTitle());
			System.out.println(course.getTitle());
		}
		session.close();
		return courseListTitle;
	}

	public List<Course> getListCourseByDate(String startDate, String endDate) {
		session = HibernateUtil.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<Course> courseList = session.createQuery("from COURSE_SESSION Where start_date >= :startDate AND end_date <= :endDate")
									.setParameter("startDate", startDate)
									.setParameter("endDate", endDate)
									.getResultList() ;
		return courseList;
	}

	public List<Course> getListCourseByLocation(String term) {
		session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("from Course c join Where title like ? ");
		query.setString(0, FormatProcess.concactQuery(term));
		List<Course> courseList = query.list();
		return courseList;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	public int persistClient(Client c) {
		return 1;
	}
	public void closeSession() {
		this.session.close();
	}
}
