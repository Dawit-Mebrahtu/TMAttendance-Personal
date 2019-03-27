package edu.mum.tmAttendanceReport.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import edu.mum.tmAttendanceReport.entity.User;
import edu.mum.tmAttendanceReport.service.LoadDataService;

@Controller
public class LoginController {

//	@Autowired
//	private UserService userService;
//	
//	@Autowired
//	private LoadDataService loadDataService;

	@RequestMapping(value = {"/", "/login" }, method = RequestMethod.GET)
	public ModelAndView login() {
//     	loadDataService.loadData(); 
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}


	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("PRINTING AUTH OBJECT: " + auth);
		
		if (auth != null) {
			System.out.println("clearing session");
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";// You can redirect wherever you want, but generally it's a good practice to
										// show login screen again.
	}

	// for 403 access denied page
	@RequestMapping(value = "/access-denied", method = RequestMethod.GET)
	public ModelAndView accesssDenied(Principal user) {
	
		ModelAndView model = new ModelAndView();
		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() + ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", "You do not have permission to access this page!");
		}

		model.setViewName("accessDenied");
		return model;

	}
}
