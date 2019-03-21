package edu.mum.tmAttendanceReport.service;

import java.util.List;

import edu.mum.tmAttendanceReport.entity.Student;
import edu.mum.tmAttendanceReport.entity.User;

public interface StudentService {
	
	public Student findById(long id);
	public Student findByUser(User user);

	//List<Student> findAll();

	List<Student> findAllByEntry(Long id);

}
