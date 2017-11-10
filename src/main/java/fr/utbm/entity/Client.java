package fr.utbm.entity;

public class Client {
	private int id;
	private int courseSessionId;
	private String lastName;
	private String firstName;
	private String address;
	private String phone;
	private String email;
	
	public Client() {	
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getcourseSessionId() {
		return courseSessionId;
	}
	public void setcourseSessionId(int courseSessionId) {
		this.courseSessionId = courseSessionId;
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
	
	
	
}
