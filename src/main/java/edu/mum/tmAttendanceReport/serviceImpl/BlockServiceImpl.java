package edu.mum.tmAttendanceReport.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.tmAttendanceReport.dto.StudentReport;
import edu.mum.tmAttendanceReport.entity.Block;
import edu.mum.tmAttendanceReport.entity.Student;
import edu.mum.tmAttendanceReport.entity.TMAttendance;
import edu.mum.tmAttendanceReport.repository.BlockRepository;
import edu.mum.tmAttendanceReport.service.BlockService;
import edu.mum.tmAttendanceReport.service.TMAttendanceService;

@Service
public class BlockServiceImpl implements BlockService {

	@Autowired
	private BlockRepository blockRepository;
	
	@Autowired
	private TMAttendanceService tmAttendanceService;
	
	public List<Block> findAll(){
		return (List<Block>) blockRepository.findAll();
	}

	@Override
	public Block findById(Long id) {
		return blockRepository.findById(id).get();
	}

	@Override
	public List<Block> findByStartDateAfter(Date startDate) {
		return blockRepository.findByStartDateAfter(startDate);
	}

	@Override
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
