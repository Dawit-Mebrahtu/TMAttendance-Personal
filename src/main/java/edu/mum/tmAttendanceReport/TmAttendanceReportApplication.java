package edu.mum.tmAttendanceReport;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import edu.mum.tmAttendanceReport.controller.AdminController;
import edu.mum.tmAttendanceReport.data.LoadData;

@SpringBootApplication
@ComponentScan("edu.mum.tmAttendanceReport")
public class TmAttendanceReportApplication {

	public static void main(String[] args) {
		new File(AdminController.uploadingDir).mkdir();
		SpringApplication.run(TmAttendanceReportApplication.class, args);
		
		
	}

	
//	@Override
//	public void run(String... args) throws Exception {
//			
//			LoadData.load();
//			
//			//System.out.println(listOfStudent.get(0));
//			
//	}

}

