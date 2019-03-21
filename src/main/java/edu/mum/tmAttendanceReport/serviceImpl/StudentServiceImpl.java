package edu.mum.tmAttendanceReport.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.tmAttendanceReport.entity.Student;
import edu.mum.tmAttendanceReport.repository.StudentRepository;
import edu.mum.tmAttendanceReport.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	
	@Autowired
	StudentRepository studentrepository;
	
	public List<Student> findAllByEntry(Long id) {

		return (List<Student>) studentrepository.findAllById(id);
	}

//	@Override
//	public List<Student> findAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public Student findById(long id) {
		return studentRepository.findById(id).get();
	}

}
