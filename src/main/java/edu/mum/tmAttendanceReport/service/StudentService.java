package edu.mum.tmAttendanceReport.service;

import java.util.List;

import edu.mum.tmAttendanceReport.entity.Student;

public interface StudentService {

	//List<Student> findAll();

	List<Student> findAllByEntry(Long id);

}
