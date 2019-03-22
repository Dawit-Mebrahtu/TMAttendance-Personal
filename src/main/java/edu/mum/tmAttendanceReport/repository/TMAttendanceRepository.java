package edu.mum.tmAttendanceReport.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.tmAttendanceReport.entity.TMAttendance;
import edu.mum.tmAttendanceReport.entity.TMAttendanceIdentity;

@Repository
public interface TMAttendanceRepository extends CrudRepository<TMAttendance, TMAttendanceIdentity> {

	@Query(value = "SELECT t FROM TMAttendance t WHERE t.tmAttendanceIdentity.studentId.studentId=:student AND t.tmAttendanceIdentity.date.date BETWEEN :startDate AND :endDate")
	public List<TMAttendance> findAttendanceByDates(@Param("student") Long student,
			@Param("startDate") Date startDate, @Param("endDate") Date endDate);
	
	@Query(value = "SELECT t FROM TMAttendance t WHERE t.tmAttendanceIdentity.studentId.studentId=:student AND t.tmAttendanceIdentity.date.date >= :startDate")
	public List<TMAttendance> findTotalAttendance(@Param("student") Long student,
			@Param("startDate") Date startDate);

	
	@Query(value = "SELECT t FROM TMAttendance t WHERE t.tmAttendanceIdentity.studentId.studentId=:studentid AND t.tmAttendanceIdentity.date.date >= :date ")
	public List<TMAttendance> findAttendanceById(Long studentid,Date date);

}
