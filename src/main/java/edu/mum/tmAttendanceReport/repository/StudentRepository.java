package edu.mum.tmAttendanceReport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.tmAttendanceReport.entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

	
	
@Query(value= "SELECT s FROM Student s WHERE s.entry.id=:id")
public List<Student> findAllById(@Param("id") Long id);

}
