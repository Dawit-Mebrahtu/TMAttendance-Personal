package edu.mum.tmAttendanceReport.serviceImpl;

import java.util.List;

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

}
