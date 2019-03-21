package edu.mum.tmAttendanceReport.service;

import edu.mum.tmAttendanceReport.entity.Retreat;
import edu.mum.tmAttendanceReport.entity.Student;

public interface RetreatService {
	
	public Retreat findById(long id);
	public Retreat save(Retreat retreat);
	public void deleteById(long id);
	public Retreat findByStudentid(Student student);

}
