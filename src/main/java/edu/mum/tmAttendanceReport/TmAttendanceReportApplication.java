package edu.mum.tmAttendanceReport;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import edu.mum.tmAttendanceReport.data.LoadData;
import edu.mum.tmAttendanceReport.entity.Sample;

@SpringBootApplication
public class TmAttendanceReportApplication implements CommandLineRunner {

	public static void main(String[] args) {
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
