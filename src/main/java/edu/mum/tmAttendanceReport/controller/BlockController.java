package edu.mum.tmAttendanceReport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.tmAttendanceReport.entity.Block;
import edu.mum.tmAttendanceReport.entity.Course;
import edu.mum.tmAttendanceReport.entity.CourseOfferedIdentity;
import edu.mum.tmAttendanceReport.service.BlockService;
import edu.mum.tmAttendanceReport.service.CourseOfferedService;
import edu.mum.tmAttendanceReport.service.CourseService;
import edu.mum.tmAttendanceReport.service.StudentService;
import edu.mum.tmAttendanceReport.service.TMAttendanceService;

@Controller
public class BlockController {

	@Autowired
	private CourseOfferedService courseOfferedService;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private BlockService blockService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private TMAttendanceService tmAttendanceService;
	
	
	
	
	
	@GetMapping(value= {"/Report/Block"})
	public String showPage(@ModelAttribute("courseOfferedIdentity") CourseOfferedIdentity courseOffered, Model model){
		List<Block> bList = blockService.findAll();
		List<Course> cList = courseService.findAll();
		
		model.addAttribute("bList",bList );
		model.addAttribute("cList",cList );
		
		return "blockForm";
	}
	
	@PostMapping(value= {"/Report/Block/"})
	public String searchReport(@RequestParam("course") String  courseCode, @RequestParam("block") String  blockId){
		System.out.println(courseCode);
		System.out.println(blockId);
		
		return "block";
	}
	
	@GetMapping(value= {"/Report/Entity"})
	public String showentitypage()
	{
		return "Entity";
	}
}