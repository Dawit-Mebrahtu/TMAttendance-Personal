package edu.mum.tmAttendanceReport.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.tmAttendanceReport.entity.Check;
import edu.mum.tmAttendanceReport.entity.Student;

@Repository
public interface CheckRepository extends CrudRepository<Check, Long> {
	
	public Check findByStudentId(Student student);

}
