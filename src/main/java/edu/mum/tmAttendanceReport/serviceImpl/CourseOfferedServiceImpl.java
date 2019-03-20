package edu.mum.tmAttendanceReport.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.tmAttendanceReport.entity.Block;
import edu.mum.tmAttendanceReport.entity.Course;
import edu.mum.tmAttendanceReport.entity.CourseOffered;
import edu.mum.tmAttendanceReport.repository.CourseOfferedRepository;
import edu.mum.tmAttendanceReport.service.CourseOfferedService;

@Service
public class CourseOfferedServiceImpl implements CourseOfferedService{


	@Autowired 
	private CourseOfferedRepository courseOfferedRepository;
	
	@Override
	public CourseOffered findByCourseAndBlock(Course course, Block block) {
		return courseOfferedRepository.findByCourseAndBlock(course, block);
	}
}
