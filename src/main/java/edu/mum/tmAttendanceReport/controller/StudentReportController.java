package edu.mum.tmAttendanceReport.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.tmAttendanceReport.dto.SingleStudentReport;
import edu.mum.tmAttendanceReport.entity.Block;
import edu.mum.tmAttendanceReport.entity.Check;
import edu.mum.tmAttendanceReport.entity.DateInfo;
import edu.mum.tmAttendanceReport.entity.Retreat;
import edu.mum.tmAttendanceReport.entity.Student;
import edu.mum.tmAttendanceReport.entity.TMAttendance;
import edu.mum.tmAttendanceReport.service.BlockService;
import edu.mum.tmAttendanceReport.service.CheckService;
import edu.mum.tmAttendanceReport.service.CourseOfferedService;
import edu.mum.tmAttendanceReport.service.CourseService;
import edu.mum.tmAttendanceReport.service.DateInfoService;
import edu.mum.tmAttendanceReport.service.RetreatService;
import edu.mum.tmAttendanceReport.service.StudentService;
import edu.mum.tmAttendanceReport.service.TMAttendanceService;

@Controller
@RequestMapping(value="/student")
public class StudentReportController {

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
	
	@Autowired
	DateInfoService dateInfoService;
	
	@Autowired
	CheckService checkService;
	
	@Autowired
	RetreatService retreatService;
	
	@GetMapping(value = "/tmcheckingreport")
	public String tmCheckingReport(Model model, HttpSession session) {
		 Student student = (Student) session.getAttribute("currentStudent");
		 Check checkRecord = checkService.findByStudentid(student);
		 model.addAttribute("checkRecord", checkRecord);
		 
		 return "tmCheckingReport";
	}
	
	@GetMapping(value = "/retreatreport")
	public String retreatReport(Model model, HttpSession session) {
		 Student student = (Student) session.getAttribute("currentStudent");
		 Retreat retreatRecord = retreatService.findByStudentid(student);
		 model.addAttribute("retreatRecord", retreatRecord);
		 
		 return "retreatReport";
	}

	@GetMapping(value = "/attendance")
	public String showPage(Model model, HttpSession session) {
		 Student student = (Student) session.getAttribute("currentStudent");
		
		Date entryStartDate = new java.sql.Date(student.getEntry().getStartdate().getDate().getTime());
				
		List<Block> blockList = blockService.findByStartDateAfter(entryStartDate);
		List<DateInfo> dateList = dateInfoService.findByDateAfter(entryStartDate);
		List<TMAttendance> totalAttendedSessions = tmAttendanceService
				.findTotalAttendance(student.getStudentId(), entryStartDate);
		
		double percentage = ((double) totalAttendedSessions.size() / dateList.size()) * 100;

		model.addAttribute("totalSessions", dateList.size());
		model.addAttribute("totalSessionsAttended", totalAttendedSessions.size());
		model.addAttribute("percentage", percentage);
		model.addAttribute("blocks", blockList);
		
		return "studentReport";
	}
	
	@PostMapping(value = "/attendance")
	public String blockAttendance(@RequestParam("blocks") Long blockId, RedirectAttributes redirectAttributes, HttpSession session) {
		Block block = blockService.findById(blockId);
		
		Student student = (Student) session.getAttribute("currentStudent");
		
		if(block!=null) {
			SingleStudentReport studentReports = studentService.generateResult(student, block);
			redirectAttributes.addFlashAttribute("studentReports", studentReports);
		}

		return "redirect:/student/attendance";
	}
	
}