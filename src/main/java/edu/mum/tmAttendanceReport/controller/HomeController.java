package edu.mum.tmAttendanceReport.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.tmAttendanceReport.entity.Student;
import edu.mum.tmAttendanceReport.entity.User;
import edu.mum.tmAttendanceReport.service.StudentService;
import edu.mum.tmAttendanceReport.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	StudentService studentService;

	@GetMapping(value = "/home")
	public ModelAndView showPage(Principal user, HttpSession session) {
		
		User currentUser = userService.findByEmail(user.getName()) ;
		session.setAttribute("currentUser", currentUser.getEmail());
		
		Student currentStudent = studentService.findByUser(currentUser);
		
		if(currentStudent != null) {
			session.setAttribute("currentStudent", currentStudent);
		}
		

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("currentUser", user.getName());
		modelAndView.setViewName("home");
		
		return modelAndView;
	}
}
