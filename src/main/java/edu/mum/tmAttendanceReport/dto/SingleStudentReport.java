package edu.mum.tmAttendanceReport.dto;

import java.util.List;

import edu.mum.tmAttendanceReport.entity.TMAttendance;

public class SingleStudentReport {

	
	private String sessions;
	
	private String attended;
	
	private String percentage;
	
	private String creditScore;
	
	private List<TMAttendance> tmAttendance;

	public String getSessions() {
		return sessions;
	}

	public void setSessions(String sessions) {
		this.sessions = sessions;
	}

	public String getAttended() {
		return attended;
	}

	public void setAttended(String attended) {
		this.attended = attended;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public String getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(String creditScore) {
		this.creditScore = creditScore;
	}

	public List<TMAttendance> getTmAttendance() {
		return tmAttendance;
	}

	public void setTmAttendance(List<TMAttendance> tmAttendance) {
		this.tmAttendance = tmAttendance;
	}

	@Override
	public String toString() {
		return "SingleStudentReport [sessions=" + sessions + ", attended=" + attended + ", percentage=" + percentage
				+ ", creditScore=" + creditScore + ", tmAttendance=" + tmAttendance + "]";
	}

	
	

}
