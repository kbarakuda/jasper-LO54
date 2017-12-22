package fr.utbm.entity;

import java.util.Date;

public class reportItem {
	private String courseCode;
	private String name;
	private String adresse;
	private String phone;
	private String email;
	private Date startDate;

	public reportItem() {

	}

	public reportItem(String name, String adresse, String phone, String email) {
		this.setName(name);
		this.setAdresse(adresse);
		this.setPhone(phone);
		this.setEmail(email);
		
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	
}
