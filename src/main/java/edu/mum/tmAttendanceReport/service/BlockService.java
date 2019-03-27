package edu.mum.tmAttendanceReport.service;

import java.util.Date;
import java.util.List;

import edu.mum.tmAttendanceReport.dto.StudentReport;
import edu.mum.tmAttendanceReport.entity.Block;
import edu.mum.tmAttendanceReport.entity.Course;
import edu.mum.tmAttendanceReport.entity.Student;



public interface BlockService {

	public List<Block> findAll();
	public Block findById(Long id);
	public List<Block> findByStartDateAfter(Date startDate);
	public List<StudentReport> generateResult(List<Student> list, Block block);
}
