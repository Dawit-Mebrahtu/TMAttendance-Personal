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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.tmAttendanceReport.dto.StudentReport;
import edu.mum.tmAttendanceReport.entity.Block;
import edu.mum.tmAttendanceReport.entity.Course;
import edu.mum.tmAttendanceReport.entity.CourseOffered;
import edu.mum.tmAttendanceReport.entity.Student;
import edu.mum.tmAttendanceReport.entity.TMAttendance;
import edu.mum.tmAttendanceReport.service.BlockService;
import edu.mum.tmAttendanceReport.service.CourseOfferedService;
import edu.mum.tmAttendanceReport.service.CourseService;
import edu.mum.tmAttendanceReport.service.TMAttendanceService;

@Controller
@RequestMapping(value="/faculty")
public class BlockController {

	@Autowired
	private CourseOfferedService courseOfferedService;

	@Autowired
	private CourseService courseService;

	@Autowired
	private BlockService blockService;

//	@Autowired
//	private StudentService studentService;

	@Autowired
	private TMAttendanceService tmAttendanceService;

	@GetMapping(value = "/report/block")
	public String showPage(Model model) {
		List<Block> bList = blockService.findAll();
		List<Course> cList = courseService.findAll();

		model.addAttribute("bList", bList);
		model.addAttribute("cList", cList);

		return "blockForm";
	}

	@PostMapping(value= "/report/block")
	public String searchReport(@RequestParam("course") String  courseCode, @RequestParam("block") String  blockId, RedirectAttributes redirect,
			                     Model model){
		
		System.out.println(courseCode);
		System.out.println(blockId);
		CourseOffered courseOffered ;
		Course course = courseService.findById(courseCode);
		Block block = blockService.findById(Long.parseLong(blockId));
		
		
		if(course !=null && block!=null) {
			model.addAttribute("courseName", course.getName());
			model.addAttribute("blockDescription", block.getDescription());
			courseOffered = courseOfferedService.findByCourseAndBlock(course, block);
			//System.out.println(courseOffered);
			List<Student> studentList = courseOffered. getStudents();
			//System.out.println(studentList);
			List<StudentReport> studentReports = generateResult(studentList, block);
			model.addAttribute("studentReports",studentReports);
		}
		else {
			return "redirect:/faculty/report/block";
		}
		
		return "block";
	}
	
//	@GetMapping(value= {"/Report/Block/studentList"})
//	public String showentitypage()
//	{
//		return "block";
//	}

	public List<StudentReport> generateResult(List<Student> list, Block block) {
		//final DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		java.sql.Date startDate = new java.sql.Date(block.getStartDate().getTime());
		java.sql.Date endDate = new java.sql.Date(block.getEndDate().getTime());
		Integer numberOfDaysInBlock = Integer.parseInt(block.getPeriod());

		List<StudentReport> studentReportList = new ArrayList<>();

		for (Student student : list) {
			StudentReport studentReport = new StudentReport();
			studentReport.setId(String.valueOf(student.getStudentId()));
			studentReport.setFirstName(student.getFirstName());
			studentReport.setLastName(student.getLastName());

			List<TMAttendance> studentBlockAttendanceList = tmAttendanceService
					.findAttendanceByDates(student.getStudentId(), startDate, endDate);

			double percentage = (double) (studentBlockAttendanceList.size() / numberOfDaysInBlock) * 100;
			studentReport.setPercentage(String.valueOf(percentage));

			if (percentage >= 90.0) {
				studentReport.setCreditScore("1.5");
			} else if (percentage >= 80.0) {
				studentReport.setCreditScore("1.0");
			} else if (percentage >= 70.0) {
				studentReport.setCreditScore("0.5");
			} else {
				studentReport.setCreditScore("0.0");
			}

			System.out.println(studentReport);

			studentReportList.add(studentReport);
		}

		return studentReportList;
	}
}