package fr.utbm.entity;

import java.util.Date;

public class CourseSession {
	private int id;
	private int loacationId;
	private Date startDate;
	private Date endDate;
	private String courseCode;
	
	public CourseSession() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLoacationId() {
		return loacationId;
	}
	public void setLoacationId(int loacationId) {
		this.loacationId = loacationId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
}
