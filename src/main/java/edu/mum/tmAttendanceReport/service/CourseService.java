package edu.mum.tmAttendanceReport.service;

import java.util.List;

import edu.mum.tmAttendanceReport.entity.Course;

public interface CourseService {
	public List<Course> findAll();
	public Course findById(String id);
}
