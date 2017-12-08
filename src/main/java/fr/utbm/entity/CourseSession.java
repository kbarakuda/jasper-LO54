package fr.utbm.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="COURSE_SESSION")
public class CourseSession {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COURSE_SESSION_ID")
	private int id;
	
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="LOCATION_ID")
	private Location location;
	
	@Column(name="START_DATE", nullable=false)
	private Date startDate;
	
	@Column(name="END_DATE", nullable=false)
	private Date endDate;
	

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="COURSE_CODE")
	private Course course;
	
	@OneToMany(mappedBy="courseSession",fetch=FetchType.EAGER)
	private List<Client> subscribers;
	
	
	public CourseSession() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location loacation) {
		this.location = loacation;
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
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "CourseSession [id=" + id + ", location=" + location + ", startDate=" + startDate + ", endDate="
				+ endDate + ", course=" + course + ", subscribers=" + subscribers + "] \n";
	}
	
	
}
