package edu.mum.tmAttendanceReport.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="retreat")
public class Retreat implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
	@JoinColumn(name="student_id")
	private Student studentid;
	
	private Integer numberOfRetreats;

	public Student getStudentid() {
		return studentid;
	}

	public void setStudentid(Student studentid) {
		this.studentid = studentid;
	}

	public Integer getNumberOfRetreats() {
		return numberOfRetreats;
	}

	public void setNumberOfRetreats(Integer numberOfRetreats) {
		this.numberOfRetreats = numberOfRetreats;
	}
	
	
}
