package edu.mum.tmAttendanceReport.exceptionHandler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler(MyException.class)
	public ModelAndView handleFileNotFoundError(HttpServletRequest req, MyException exception) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", exception.getMessage());
		mav.setViewName("fileNotFound");
		return mav;
	}
	
	
	@ExceptionHandler(CourseNotOfferedException.class)
	public ModelAndView handleCourseNotOffered(HttpServletRequest req, CourseNotOfferedException exception) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", exception.getFullMessage());
		mav.setViewName("courseNotOffered");
		return mav;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllError(HttpServletRequest req, Exception exception) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", exception);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName("error");
		return mav;
	}
}


