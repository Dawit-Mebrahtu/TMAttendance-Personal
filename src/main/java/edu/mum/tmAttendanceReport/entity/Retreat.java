package edu.mum.tmAttendanceReport.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	@JoinColumn(name="student_id")
	private Student studentid;
	
	private Integer numberOfRetreats;
	
	public Retreat() {}

	public Retreat(Long id, Student studentid, Integer numberOfRetreats) {
		this.id = id;
		this.studentid = studentid;
		this.numberOfRetreats = numberOfRetreats;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	@Override
	public String toString() {
		return "Retreat [id=" + id + ", studentid=" + studentid + ", numberOfRetreats=" + numberOfRetreats + "]";
	}
	
	
}
