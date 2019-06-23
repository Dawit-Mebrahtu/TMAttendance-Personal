package edu.mum.tmAttendanceReport.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.tmAttendanceReport.dto.StudentReport;
import edu.mum.tmAttendanceReport.entity.Block;
import edu.mum.tmAttendanceReport.entity.Course;
import edu.mum.tmAttendanceReport.entity.CourseOffered;
import edu.mum.tmAttendanceReport.entity.Student;
import edu.mum.tmAttendanceReport.exceptionHandler.CourseNotOfferedException;
import edu.mum.tmAttendanceReport.service.BlockService;
import edu.mum.tmAttendanceReport.service.CourseOfferedService;
import edu.mum.tmAttendanceReport.service.CourseService;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping(value="/faculty")
public class BlockController {

	@Autowired
	private CourseOfferedService courseOfferedService;

	@Autowired
	private CourseService courseService;

	@Autowired
	private BlockService blockService;


	@GetMapping(value = "/report/block")
	public String showPage(Model model) {
		List<Block> bList = blockService.findAll();
		List<Course> cList = courseService.findAll();

		model.addAttribute("bList", bList);
		model.addAttribute("cList", cList);

		return "blockForm";
	}

	@PostMapping(value= "/report/block")
	public String searchReport(@RequestParam("course") String  courseCode, @RequestParam("block") String  blockId, Model model,
								HttpSession httpSession){
		
		System.out.println(courseCode);
		System.out.println(blockId);
		CourseOffered courseOffered ;
		Course course = courseService.findById(courseCode);
		Block block = blockService.findById(Long.parseLong(blockId));
		
		
		if(course !=null && block!=null) {
			model.addAttribute("courseName", course.getName());
			model.addAttribute("blockDescription", block.getDescription());
			try {
				courseOffered = courseOfferedService.findByCourseAndBlock(course, block);
				List<Student> studentList = courseOffered. getStudents();
				List<StudentReport> studentReports = blockService.generateResult(studentList, block);
				model.addAttribute("studentReports",studentReports);
				httpSession.setAttribute("studentReports", studentReports);
				
			}catch(Exception e) {
				throw new CourseNotOfferedException();
			}
			
		}
		else {
			return "redirect:/faculty/report/block";
		}

		return "block";
	}

}