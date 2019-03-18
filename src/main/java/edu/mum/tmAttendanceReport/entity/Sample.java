package edu.mum.tmAttendanceReport.entity;

import java.util.Date;

public class Sample {
	
	private Long Id;
	private Date date;
	private String period;
	private String place;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Student [Id=" + Id + ", date=" + date + ", period=" + period + ", place=" + place + "]";
	}
}
