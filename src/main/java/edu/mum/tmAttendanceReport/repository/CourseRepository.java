package edu.mum.tmAttendanceReport.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.tmAttendanceReport.entity.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, String>{

}
