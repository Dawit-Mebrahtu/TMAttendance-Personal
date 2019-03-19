package edu.mum.tmAttendanceReport.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.tmAttendanceReport.entity.TMAttendance;

@Repository
public interface TMAttendanceRepository extends CrudRepository<TMAttendance, Long> {

}
