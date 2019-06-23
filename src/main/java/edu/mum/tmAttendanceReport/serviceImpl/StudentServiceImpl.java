package edu.mum.tmAttendanceReport.serviceImpl;

import java.util.List;

import edu.mum.tmAttendanceReport.dto.SingleStudentReport;
import edu.mum.tmAttendanceReport.entity.Block;
import edu.mum.tmAttendanceReport.entity.TMAttendance;
import edu.mum.tmAttendanceReport.service.TMAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.mum.tmAttendanceReport.entity.Student;
import edu.mum.tmAttendanceReport.entity.User;
import edu.mum.tmAttendanceReport.repository.StudentRepository;
import edu.mum.tmAttendanceReport.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private TMAttendanceService tmAttendanceService;
	
	@Override
	public Student getStudentByBarCode(String barCode) {
		System.out.println(barCode);
		return studentRepository.getStudentByBarCode(barCode);
	}

//	@Override
//	public List<Student> checkIfStudentBarCodeExist(String studentBarCode) {
//		return studentRepository.checkIfStudentBarCodeExist(studentBarCode);
//	}	
//	public List<Student> findByBarCode(String barCode){
//		return studentRepository.findByBarCode(barCode);
//	}
	
	public List<Student> findAllByEntry(Long id) {

		return (List<Student>) studentRepository.findAllById(id);
	}


//	@Override
//	public List<Student> findAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	@Override
	public Student findById(long id) {
		return studentRepository.findById(id).get();
	}

	@Override
	public Student findByUser(User user) {
		return studentRepository.findByUser(user);
	}


	@Override
	public SingleStudentReport generateResult(Student student, Block block) {
		java.sql.Date startDate = new java.sql.Date(block.getStartDate().getTime());
		java.sql.Date endDate = new java.sql.Date(block.getEndDate().getTime());
		Integer numberOfDaysInBlock = Integer.parseInt(block.getPeriod());


		SingleStudentReport studentReport = new SingleStudentReport();


		List<TMAttendance> studentBlockAttendanceList = tmAttendanceService
				.findAttendanceByDates(student.getStudentId(), startDate, endDate);

		double percentage = ((double) studentBlockAttendanceList.size() / numberOfDaysInBlock) * 100;

		studentReport.setSessions(String.valueOf(numberOfDaysInBlock));
		studentReport.setAttended(String.valueOf(studentBlockAttendanceList.size()));
		studentReport.setPercentage(String.valueOf(percentage));
		studentReport.setTmAttendance(studentBlockAttendanceList);


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

		return studentReport;
	}
}
