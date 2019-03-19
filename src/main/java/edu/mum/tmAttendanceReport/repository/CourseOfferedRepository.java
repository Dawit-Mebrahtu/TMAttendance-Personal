package edu.mum.tmAttendanceReport.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.tmAttendanceReport.entity.CourseOffered;
import edu.mum.tmAttendanceReport.entity.CourseOfferedIdentity;

@Repository
public interface CourseOfferedRepository extends CrudRepository<CourseOffered, CourseOfferedIdentity> {

}
