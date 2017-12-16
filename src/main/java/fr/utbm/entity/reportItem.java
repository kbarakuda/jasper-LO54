package fr.utbm.entity;

import java.util.Date;

public class reportItem {
	private String courseCode;
	private String name;
	private Date startDate;

	public reportItem() {

	}

	public reportItem(String name, Date startDate) {
		this.setName(name);
		this.setStartDate(startDate);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	
	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}


	
	
}
