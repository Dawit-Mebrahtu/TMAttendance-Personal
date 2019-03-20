package edu.mum.tmAttendanceReport.service;

import edu.mum.tmAttendanceReport.entity.Block;
import edu.mum.tmAttendanceReport.entity.Course;
import edu.mum.tmAttendanceReport.entity.CourseOffered;

public interface CourseOfferedService {

	 public  CourseOffered findByCourseAndBlock(Course course, Block block);

}
