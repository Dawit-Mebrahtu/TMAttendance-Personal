package edu.mum.tmAttendanceReport.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tmAttendance")
public class TMAttendance implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
//These are commented to know how to use composite keys 
//	private Student student;
//	
//	private DateInfo dateInfo;
	
//	private Place place;
	
//	private TimeInfo timeInfo;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
//
//	public TimeInfo getTimeInfo() {
//		return timeInfo;
//	}
//
//	public void setTimeInfo(TimeInfo timeInfo) {
//		this.timeInfo = timeInfo;
//	}
//
//	public Place getPlace() {
//		return place;
//	}
//
//	public void setPlace(Place place) {
//		this.place = place;
//	}
	
//	public Student getStudent() {
//		return student;
//	}
//
//	public void setStudent(Student student) {
//		this.student = student;
//	}
//
//	public DateInfo getDateInfo() {
//		return dateInfo;
//	}
//
//	public void setDateInfo(DateInfo dateInfo) {
//		this.dateInfo = dateInfo;
//	}	
	
}
