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
@Table(name="entry")
public class Entry implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	private String startPeriod;
	
	@OneToOne
	@JoinColumn(name="dateInfo_id")
	private DateInfo startdate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStartPeriod() {
		return startPeriod;
	}

	public void setStartPeriod(String startPeriod) {
		this.startPeriod = startPeriod;
	}

	public DateInfo getStartdate() {
		return startdate;
	}

	public void setStartdate(DateInfo startdate) {
		this.startdate = startdate;
	}

	@Override
	public String toString() {
		return "Entry [id=" + id + ", startPeriod=" + startPeriod + ", startdate=" + startdate + "]";
	} 

	
	
	
}
