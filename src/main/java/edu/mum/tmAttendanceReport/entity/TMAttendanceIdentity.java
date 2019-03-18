package edu.mum.tmAttendanceReport.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Embeddable
public class TMAttendanceIdentity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@OneToOne
	@JoinColumn(name="studentId")
	private Student studentId;
	
	@OneToOne
	@JoinColumn(name="date")
	private DateInfo date;

	public Student getStudentId() {
		return studentId;
	}

	public void setStudentId(Student studentId) {
		this.studentId = studentId;
	}

	public DateInfo getDate() {
		return date;
	}

	public void setDate(DateInfo date) {
		this.date = date;
	}
	
	public TMAttendanceIdentity() {
	}

	public TMAttendanceIdentity(Student studentId, DateInfo date) {
		super();
		this.studentId = studentId;
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((studentId == null) ? 0 : studentId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TMAttendanceIdentity other = (TMAttendanceIdentity) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (studentId == null) {
			if (other.studentId != null)
				return false;
		} else if (!studentId.equals(other.studentId))
			return false;
		return true;
	}
	
	
	
	
	
	

}
