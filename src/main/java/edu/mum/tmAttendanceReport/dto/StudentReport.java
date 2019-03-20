package edu.mum.tmAttendanceReport.dto;

public class StudentReport {

	private String id;
	
	private String firstName;
	
	private String lastName;
	
	private String percentage;
	
	private String creditScore;

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	
	@Override
	public String toString() {
		return "StudentReport [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", percentage="
				+ percentage + ", creditScore=" + creditScore + "]";
	}

}
