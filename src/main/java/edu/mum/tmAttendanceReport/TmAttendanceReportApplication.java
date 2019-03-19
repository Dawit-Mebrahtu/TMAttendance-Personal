package edu.mum.tmAttendanceReport;

import java.io.File;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import edu.mum.tmAttendanceReport.controller.AdminController;
import edu.mum.tmAttendanceReport.data.LoadData;
import edu.mum.tmAttendanceReport.entity.Sample;

@SpringBootApplication
@ComponentScan("edu.mum.tmAttendanceReport")
public class TmAttendanceReportApplication implements CommandLineRunner {

	public static void main(String[] args) {
		new File(AdminController.uploadingDir).mkdir();
		SpringApplication.run(TmAttendanceReportApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
			Long seconds = System.currentTimeMillis();
			List<Sample> listOfStudent = LoadData.load();
			System.out.println(System.currentTimeMillis() - seconds);
			System.out.println(listOfStudent.get(0));
			
	}

}
