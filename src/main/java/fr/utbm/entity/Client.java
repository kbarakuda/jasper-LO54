package fr.utbm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Client")
public class Client {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="COURSE_SESSION_ID")
	private CourseSession courseSession;
	
	@Column(name="LASTNAME", length=50, nullable=false)
	private String lastName;
	
	@Column(name="FIRSTNAME", length=50, nullable=false)
	private String firstName;
	
	@Column(name="ADDRESS", length=128, nullable=false)
	private String address;
	
	@Column(name="PHONE", length=30, nullable=false)
	private String phone;
	
	@Column(name="EMAIL")
	private String email;

	
	public Client() {	
	}
	
	
	
	public Client(CourseSession courseSession, String lastName, String firstName, String address, String phone,
			String email) {
		super();
		this.setcourseSession(courseSession); 
		this.setLastName(lastName); 
		this.setFirstName(firstName);
		this.setAddress(address);
		this.setPhone(phone);
		this.setEmail(email);
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public CourseSession getcourseSession() {
		return courseSession;
	}
	public void setcourseSession(CourseSession courseSession) {
		this.courseSession = courseSession;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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

	@Override
	public String toString() {
		return "Client [id=" + id + ", lastName=" + lastName + ", firstName="
				+ firstName + ", address=" + address + ", phone=" + phone + ", email=" + email + "]";
	}
	
	
	
	
	
}
