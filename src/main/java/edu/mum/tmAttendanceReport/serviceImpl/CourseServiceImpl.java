package edu.mum.tmAttendanceReport.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.tmAttendanceReport.entity.Course;
import edu.mum.tmAttendanceReport.repository.CourseRepository;
import edu.mum.tmAttendanceReport.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseRepository courseRepository;
	
	@Override
	public List<Course> findAll(){
		return (List<Course>) courseRepository.findAll();
	}

	@Override
	public Course findById(String id) {
		return courseRepository.findById(id).get();
	}
}
