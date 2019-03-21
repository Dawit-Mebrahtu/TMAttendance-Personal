package edu.mum.tmAttendanceReport.entity;

public class StudentEntry {

	
	private String firstname;
	private String lastname;
	private Long id;
	private Double possibleSession;
	private Long totalSessionAttended;
	private Double percentage;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getPossibleSession() {
		return possibleSession;
	}
	public void setPossibleSession(Double possibleSession) {
		this.possibleSession = possibleSession;
	}
	public Long getTotalSessionAttended() {
		return totalSessionAttended;
	}
	public void setTotalSessionAttended(Long totalSessionAttended) {
		this.totalSessionAttended = totalSessionAttended;
	}
	public Double getPercentage() {
		return percentage;
	}
	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}
	@Override
	public String toString() {
		return "StudentEntry [firstname=" + firstname + ", lastname=" + lastname + ", id=" + id + ", possibleSession="
				+ possibleSession + ", totalSessionAttended=" + totalSessionAttended + ", percentage=" + percentage
				+ "]";
	}
	
	
	
	
	
	
}
