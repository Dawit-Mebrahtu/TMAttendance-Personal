package edu.mum.tmAttendanceReport.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.tmAttendanceReport.entity.Student;
import edu.mum.tmAttendanceReport.entity.TMAttendance;

@Repository
public interface TMAttendanceRepository extends CrudRepository<TMAttendance, Long> {

	@Query(value = "SELECT t FROM TMAttendance t WHERE t.tmAttendanceIdentity.student=:student AND t.tmAttendanceIdentity.date.date=>startDate "
			+ "AND t.tmAttendanceIdentity.date.date<=endDate")
	public List<TMAttendance> findAttendanceByDates(@Param("student") Student student,
			@Param("startDate") Date startDate, @Param("endDate") Date endDate);

}
