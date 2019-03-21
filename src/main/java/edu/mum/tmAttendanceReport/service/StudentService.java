package edu.mum.tmAttendanceReport.service;
import java.util.List;

import edu.mum.tmAttendanceReport.entity.Student;

public interface StudentService {
	public Student getStudentByBarCode(String barCode);
   //public List<Student> checkIfStudentBarCodeExist(String studentBarCode);
	//public List<Student> findByBarCode(String barCode);
}
