package edu.mum.tmAttendanceReport.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="courseOffered")
public class CourseOffered implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	
	//	creates a composite key using Course and Block
	@EmbeddedId
	private CourseOfferedIdentity courseOfferedIdentity;	

	@OneToOne
	@JoinColumn(name="faculty_id")
	private Faculty faculty;
	
	@OneToMany
	private List<Student> students;

	public CourseOfferedIdentity getCourseOfferedIdentity() {
		return courseOfferedIdentity;
	}

	public void setCourseOfferedIdentity(CourseOfferedIdentity courseOfferedIdentity) {
		this.courseOfferedIdentity = courseOfferedIdentity;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "CourseOffered [courseOfferedIdentity=" + courseOfferedIdentity + ", faculty=" + faculty + ", students="
				+ students + "]";
	}
	
	
}
