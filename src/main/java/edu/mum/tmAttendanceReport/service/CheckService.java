package edu.mum.tmAttendanceReport.service;


import edu.mum.tmAttendanceReport.entity.Check;
import edu.mum.tmAttendanceReport.entity.Student;

public interface CheckService {
	
	public Check findById(long id);
	public Check save(Check check);
	public void deleteById(long id);
	public Check findByStudentid(Student student);

}
