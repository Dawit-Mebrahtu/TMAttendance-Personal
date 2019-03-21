package edu.mum.tmAttendanceReport.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.tmAttendanceReport.entity.DateInfo;
import edu.mum.tmAttendanceReport.entity.Entry;
import edu.mum.tmAttendanceReport.entity.Student;
import edu.mum.tmAttendanceReport.entity.StudentEntry;
import edu.mum.tmAttendanceReport.entity.TMAttendance;
import edu.mum.tmAttendanceReport.service.DateInfoService;
import edu.mum.tmAttendanceReport.service.EntryService;
import edu.mum.tmAttendanceReport.service.StudentService;
import edu.mum.tmAttendanceReport.service.TMAttendanceService;

@Controller
@RequestMapping(value="/faculty")
public class EntryController {
	
	
	@Autowired
	EntryService entryService;
	
	@Autowired
	StudentService studentService;
	@Autowired
	DateInfoService dateInfoService;
	@Autowired
	private TMAttendanceService tmAttendanceService;
	
	@GetMapping(value="/entry")
	public String showpage(Model model)
	{
		List<Entry> entryList= entryService.findAll();
		System.out.println(entryList);
		model.addAttribute("eList", entryList);
		
	return "entryForm";
	}
	
	
	
	@PostMapping(value="/entry")
	public String showStudentbyEntry(@RequestParam("entry") String id,RedirectAttributes redirect, Model model)
	{
		
		Long longid= Long.parseLong(id);
		
		System.out.println(id);
		
	List<Student> students= studentService.findAllByEntry(longid);
	System.out.println(students);
	
	Entry entry= entryService.getEntryID( longid);
	System.out.println(entry);
	
	String description= entry.getStartPeriod();
	DateInfo  dateInfo =entry.getStartdate();
	Date date=  dateInfo.getDate();
	java.sql.Date startDate = new java.sql.Date(date.getTime());
	System.out.println(startDate);
	List<DateInfo> possibleDates= dateInfoService.Daysgreaterthan(startDate);
	 Double tottalPossibleSeesion= (double) possibleDates.size();
	 System.out.println(tottalPossibleSeesion);
	 
	 
	List<StudentEntry> studententrylist= new ArrayList<>();
	 for(Student student:students)
	 {
		 StudentEntry studentEntry =new StudentEntry();
		 studentEntry.setFirstname(student.getFirstName());
		 studentEntry.setLastname(student.getLastName());
		 studentEntry.setId(student.getStudentId());
		 studentEntry.setPossibleSession( tottalPossibleSeesion);
		 Long studentid= student.getStudentId();
		 List<TMAttendance> tottalSession= tmAttendanceService.findAttendanceById(studentid,startDate);
		 
		 Long size=  (long) tottalSession.size();
		 studentEntry.setTotalSessionAttended(size);
		 Double percentage= (size/tottalPossibleSeesion)*100;
		 studentEntry.setPercentage(percentage);
		 
		 studententrylist.add(studentEntry);
		 
		 System.out.println(studentEntry);
		 
	 }
	 
	 System.out.println("----------------------------------------------------------------------------------");
	 System.out.println(studententrylist);
	
	redirect.addFlashAttribute("studententrylist", studententrylist);
	redirect.addFlashAttribute("description",description );
	

			return "redirect:/faculty/entry/viewEntryList" ;
	}
	
	@GetMapping(value="/entry/viewEntryList")
	public String showStudentbyEntrylist(Model model)
	{
		return "entry";
	}

}
