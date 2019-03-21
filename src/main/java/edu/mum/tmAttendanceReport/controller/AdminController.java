package edu.mum.tmAttendanceReport.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import edu.mum.tmAttendanceReport.dto.FileUploadInfo;
import edu.mum.tmAttendanceReport.entity.Check;
import edu.mum.tmAttendanceReport.entity.Retreat;
import edu.mum.tmAttendanceReport.entity.Student;
import edu.mum.tmAttendanceReport.service.CheckService;
import edu.mum.tmAttendanceReport.service.RetreatService;
import edu.mum.tmAttendanceReport.service.StudentService;

@Controller
@RequestMapping(value="/admin")
public class AdminController {

	public static final String uploadingDir = System.getProperty("user.dir")+ "/uploads" ;
	
	@Autowired
	RetreatService retreatService;
	
	@Autowired
	CheckService checkService;
	
	@Autowired
	StudentService studentService;

	// GET: Show upload form page.
	@RequestMapping(value = "/upload")
	public String uploadForm(@ModelAttribute("fileUploadInfo") FileUploadInfo fileUploadInfo, Model model) {
//		FileUploadInfo fileInfo = new FileUploadInfo();
//		model.addAttribute("fileUploadInfo", fileInfo);
		return "uploadForm";
	}

	// POST: Do Upload
	@PostMapping(value = "/upload")
	public String uploadFile(Model model,
			@RequestParam("file") MultipartFile file){

		Path fileNameAndPath = Paths.get(uploadingDir, file.getOriginalFilename());
        	try {
				Files.write(fileNameAndPath, file.getBytes());
				return "uploadResult";
			} catch (IOException e) {
				e.printStackTrace();
				return "fileNotFound";
			}
	}
	
	@GetMapping(value="/retreat")
	public String retreatForm(@ModelAttribute("retreat") Retreat retreat) {
		return "addRetreatForm";
	}
	
	@PostMapping(value="/retreat")
	public String saveRetreat(@ModelAttribute("retreat") Retreat retreat) {
		System.out.println(retreat);
		Student student = studentService.findById(retreat.getStudentid().getStudentId());
		retreat.setStudentid(student);
		Retreat newRetreat = retreatService.save(retreat);
		return "redirect:/admin/retreat";
	}
	
	
	@GetMapping(value="/retreat/update")
	public String retreatUpdateForm(Model model) {
		//@ModelAttribute("updateRetreat") Retreat retreat
		model.addAttribute("updateRetreat", new Retreat());
		model.addAttribute("found", false);
		
		return "updateRetreat";
	}
	
	@PostMapping(value="/retreat/search")
	public String retreatSearch(@RequestParam("studId") long studentId, Model model) {
		Student stud = studentService.findById(studentId);
		Retreat retreat = retreatService.findByStudentid(stud);
		
		System.out.println("value of retreat obj :" + retreat);
		
		if(retreat != null) {
			model.addAttribute("found", true);
		}
		model.addAttribute("updateRetreat", retreat);
		return "updateRetreat";
	}
	
	@PostMapping(value="/retreat/update")
	public String updateRetreat(@ModelAttribute("updateRetreat") Retreat retreat, Model model) {
		System.out.println("value of updated retreat obj :" + retreat);
		Retreat updatedRetreat = retreatService.save(retreat);
		
		model.addAttribute("found", false);
		return "redirect:/admin/retreat/update";
	}
	
	@GetMapping(value="/check")
	public String checkForm(@ModelAttribute("check") Check check) {
		return "addCheckForm";
	}
	
	@PostMapping(value="/check")
	public String saveCheck(@ModelAttribute("check") Check check) {
		System.out.println("value of check obj :" + check);
		
		Check savedCheck = checkService.save(check);
		return "redirect:/admin/check";
	}
	
	
	@GetMapping(value="/check/update")
	public String checkUpdateForm(Model model) {
		model.addAttribute("updateCheck", new Check());
		model.addAttribute("found", false);
		
		return "updateCheck";
	}
	
	@PostMapping(value="/check/search")
	public String checkSearch(@RequestParam("studId") long studentId, Model model) {
		Student stud = studentService.findById(studentId);
		Check check = checkService.findByStudentid(stud);
		
		if(check != null) {
			model.addAttribute("found", true);
		}
	
		model.addAttribute("updateCheck", check);
		return "updateCheck";
	}
	
	@PostMapping(value="/check/update")
	public String updateCheck(@ModelAttribute("updateCheck") Check check, Model model) {
		
		Check updatedCheck = checkService.save(check);
		
		model.addAttribute("found", false);
		return "redirect:/admin/check/update";
	}
	
	
}
