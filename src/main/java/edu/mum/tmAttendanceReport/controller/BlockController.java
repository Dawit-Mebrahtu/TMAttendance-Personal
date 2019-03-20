package edu.mum.tmAttendanceReport.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.tmAttendanceReport.dto.StudentReport;
import edu.mum.tmAttendanceReport.entity.Block;
import edu.mum.tmAttendanceReport.entity.Course;
import edu.mum.tmAttendanceReport.entity.CourseOffered;
import edu.mum.tmAttendanceReport.entity.CourseOfferedIdentity;
import edu.mum.tmAttendanceReport.entity.Student;
import edu.mum.tmAttendanceReport.entity.TMAttendance;
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
	public String searchReport(@RequestParam("course") String  courseCode, @RequestParam("block") String  blockId, RedirectAttributes redirect,
			                     Model model){
		
		System.out.println(courseCode);
		System.out.println(blockId);
		CourseOffered courseOffered ;
		Course course = courseService.findById(courseCode);
		Block block = blockService.findById(Long.parseLong(blockId));
		
		if(course !=null && block!=null) {
			courseOffered = courseOfferedService.findByCourseAndBlock(course, block);
			System.out.println(courseOffered);
			List<Student> studentList = courseOffered. getStudents();
			List<StudentReport> students = generateResult(studentList, block);
			
			redirect.addFlashAttribute("students", students);
		}else {
			return "redirect:/Report/Block";
		}
		
		return "redirect:/Report/Block/studentList";
	}
	
	@GetMapping(value= {"/Report/Block/studentList"})
	public String showentitypage()
	{
		return "StudentListForm";
	}
	
	
    public List<StudentReport> generateResult(List<Student> list, Block block){
    	
    	Date startDate = block.getStartDate();
    	Date endDate = 	block.getEndDate();	
    	Integer numberOfDaysInBlock = Integer.parseInt( block.getPeriod());
    	
    	List<StudentReport> studentReportList = new ArrayList<>();
    
    	for(Student student: list) {
    		StudentReport studentReport = new StudentReport();
    		studentReport.setId(String.valueOf(student.getStudentId()));
    		studentReport.setFirstName(student.getFirstName());
    		studentReport.setLastName(student.getLastName());
    		
    		List<TMAttendance> studentBlockAttendanceList = tmAttendanceService.findAttendanceByDates(student, startDate, endDate);
    		
    		double percentage = (double) (studentBlockAttendanceList.size()/numberOfDaysInBlock)*100;
    		studentReport.setPercentage(String.valueOf(percentage));
    		
    		if(percentage >= 90.0 ) {
    			studentReport.setCreditScore("1.5");
    		}else if(percentage >= 80.0 ) {
    			studentReport.setCreditScore("1.0");
    		}else if(percentage >= 70.0 ) {
    			studentReport.setCreditScore("0.5");
    		}else {
    			studentReport.setCreditScore("0.0");
    		}
    		
    		studentReportList.add(studentReport);
    	}
    	
    	return studentReportList;
    }
}