package edu.mum.tmAttendanceReport.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import edu.mum.tmAttendanceReport.dto.FileUploadInfo;
import edu.mum.tmAttendanceReport.exceptionHandler.MyException;

@Controller
@RequestMapping(value="/admin")
public class AdminController {

	public static final String uploadingDir = System.getProperty("user.dir")+ "/uploads" ;

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
}
