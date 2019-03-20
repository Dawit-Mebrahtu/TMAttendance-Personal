package edu.mum.tmAttendanceReport.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.tmAttendanceReport.entity.Block;
import edu.mum.tmAttendanceReport.entity.Course;
import edu.mum.tmAttendanceReport.entity.CourseOffered;
import edu.mum.tmAttendanceReport.entity.CourseOfferedIdentity;

@Repository
public interface CourseOfferedRepository extends CrudRepository<CourseOffered, CourseOfferedIdentity> {
     
	@Query(value="SELECT c FROM CourseOffered c WHERE c.courseOfferedIdentity.course=:course AND c.courseOfferedIdentity.block=:block")
	public CourseOffered findByCourseAndBlock(@Param("course") Course course, @Param("block") Block block);
}
