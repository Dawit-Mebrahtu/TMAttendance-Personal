package edu.mum.tmAttendanceReport.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Unable to upload the file")
public class MyException extends RuntimeException{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	public MyException(String message) {
		this.setMessage(message);
	}
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
