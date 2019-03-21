package edu.mum.tmAttendanceReport.service;

import edu.mum.tmAttendanceReport.entity.Student;
import edu.mum.tmAttendanceReport.entity.User;

public interface StudentService {
	
	public Student findById(long id);
	public Student findByUser(User user);

}
