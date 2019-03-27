package edu.mum.tmAttendanceReport.exceptionHandler;

public class CourseNotOfferedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message = "Course not offered in this block";

	public CourseNotOfferedException() {
	}

	public CourseNotOfferedException(String message) {
		if (message != null)
			this.message = message;

	}

	public String getFullMessage() {
		return message;
	}

}
