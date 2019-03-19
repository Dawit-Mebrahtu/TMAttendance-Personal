package edu.mum.tmAttendanceReport.controller;

import java.io.File;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import edu.mum.tmAttendanceReport.exceptionHandler.MyException;

@Controller
public class AdminController {

//	@GetMapping(value = "/upload")
//	public String uploadForm(Model model) {
//		FileUploadForm myUploadForm = new MyUploadForm();
//		model.addAttribute("myUploadForm", myUploadForm);
//
//		return "admin";
//	}
//
//	@PostMapping(value = "/upload")
//	public String uploadFile() {
//
//		MultipartFile employeeImage = employee.getEmployeeImage();
//		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
//
//		if (employeeImage != null && !employeeImage.isEmpty()) {
//			try {
//				employeeImage.transferTo(new File(rootDirectory + "/images/" + employee.getId() + ".png"));
//			} catch (Exception e) {
//				throw new MyException(
//						"Employee Image unable to be saved successfully !" + employeeImage.getOriginalFilename());
//			}
//		}
//		return "";
//	}

//	// GET: Show upload form page.
//	@RequestMapping(value = "/uploadOneFile", method = RequestMethod.GET)
//	public String uploadOneFileHandler(Model model) {
//
//		MyUploadForm myUploadForm = new MyUploadForm();
//		model.addAttribute("myUploadForm", myUploadForm);
//
//		return "uploadOneFile";
//	}
//
//	// POST: Do Upload
//	@RequestMapping(value = "/uploadOneFile", method = RequestMethod.POST)
//	public String uploadOneFileHandlerPOST(HttpServletRequest request, //
//			Model model, //
//			@ModelAttribute("myUploadForm") MyUploadForm myUploadForm) {
//
//		return this.doUpload(request, model, myUploadForm);
//
//	}

}
