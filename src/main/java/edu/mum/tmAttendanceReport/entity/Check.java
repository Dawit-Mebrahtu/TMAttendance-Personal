package edu.mum.tmAttendanceReport.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="check")
public class Check implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@OneToOne
	@JoinColumn(name="student_id")
	private Student studentId;
	
	private Integer numberOfChecks;

	public Student getStudentId() {
		return studentId;
	}

	public void setStudentId(Student studentId) {
		this.studentId = studentId;
	}

	public Integer getNumberOfChecks() {
		return numberOfChecks;
	}

	public void setNumberOfChecks(Integer numberOfChecks) {
		this.numberOfChecks = numberOfChecks;
	}
	
	

}
