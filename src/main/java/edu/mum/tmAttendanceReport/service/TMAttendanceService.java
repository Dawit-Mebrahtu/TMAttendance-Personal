package edu.mum.tmAttendanceReport.service;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;

import edu.mum.tmAttendanceReport.entity.TMAttendance;


public interface TMAttendanceService {

	public List<TMAttendance> findAttendanceByDates(Long student, Date startDate, Date endDate);
	public List<TMAttendance> findTotalAttendance( Long student, Date startDate);
}
