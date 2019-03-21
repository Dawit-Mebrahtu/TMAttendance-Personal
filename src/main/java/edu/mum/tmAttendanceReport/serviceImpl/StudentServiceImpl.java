package edu.mum.tmAttendanceReport.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.tmAttendanceReport.entity.Student;
import edu.mum.tmAttendanceReport.entity.User;
import edu.mum.tmAttendanceReport.repository.StudentRepository;
import edu.mum.tmAttendanceReport.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public Student findById(long id) {
		return studentRepository.findById(id).get();
	}

	@Override
	public Student findByUser(User user) {
		return studentRepository.findByUser(user);
	}

}
