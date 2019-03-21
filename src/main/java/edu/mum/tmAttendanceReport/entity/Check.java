package edu.mum.tmAttendanceReport.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tmcheck")
public class Check implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	@JoinColumn(name="student_id")
	private Student studentId;
	
	private Integer numberOfChecks;
	
	
	public Check() {}
	
	public Check(Long id, Student studentId, Integer numberOfChecks) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.numberOfChecks = numberOfChecks;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	@Override
	public String toString() {
		return "Check [id=" + id + ", studentId=" + studentId + ", numberOfChecks=" + numberOfChecks + "]";
	}
	
	

}
