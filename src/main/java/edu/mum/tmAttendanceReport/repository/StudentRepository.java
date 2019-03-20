package edu.mum.tmAttendanceReport.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.tmAttendanceReport.entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

}
