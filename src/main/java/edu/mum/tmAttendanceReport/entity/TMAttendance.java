package edu.mum.tmAttendanceReport.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tmAttendance")
public class TMAttendance implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//	creates a composite key using Student and DateInfo
	@EmbeddedId
	private TMAttendanceIdentity tmAttendanceIdentity;
	
	private Place place;
	
	private TimeInfo timeInfo;
	
	
	public TMAttendance() {}

	public TMAttendance(TMAttendanceIdentity tmAttendanceIdentity, Place place, TimeInfo timeInfo) {
		super();
		this.tmAttendanceIdentity = tmAttendanceIdentity;
		this.place = place;
		this.timeInfo = timeInfo;
	}

	public TMAttendanceIdentity getTmAttendanceIdentity() {
		return tmAttendanceIdentity;
	}

	public void setTmAttendanceIdentity(TMAttendanceIdentity tmAttendanceIdentity) {
		this.tmAttendanceIdentity = tmAttendanceIdentity;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public TimeInfo getTimeInfo() {
		return timeInfo;
	}

	public void setTimeInfo(TimeInfo timeInfo) {
		this.timeInfo = timeInfo;
	}
	
	
	
}
