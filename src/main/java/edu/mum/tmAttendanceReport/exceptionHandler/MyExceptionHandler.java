package edu.mum.tmAttendanceReport.exceptionHandler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler(MyException.class)
	public ModelAndView handleError(HttpServletRequest req, MyException exception) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", exception.getMessage());
		mav.setViewName("fileNotFound");
		return mav;
	}
}


