package edu.mum.tmAttendanceReport.service;

import java.util.Date;
import java.util.List;

import edu.mum.tmAttendanceReport.entity.Block;
import edu.mum.tmAttendanceReport.entity.Course;



public interface BlockService {

	public List<Block> findAll();
	public Block findById(Long id);
	public List<Block> findByStartDateAfter(Date startDate);
}
