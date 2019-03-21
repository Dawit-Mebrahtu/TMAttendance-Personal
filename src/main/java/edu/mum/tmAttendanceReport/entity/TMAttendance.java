package edu.mum.tmAttendanceReport.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="tmAttendance")
@Component
public class TMAttendance implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//	creates a composite key using Student and DateInfo
	@EmbeddedId
	private TMAttendanceIdentity tmAttendanceIdentity;
	
	@OneToOne
	@JoinColumn(name="place_id")
	private Place place;
	
	@OneToOne
	@JoinColumn(name="timeInfo_id")
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
