package edu.mum.tmAttendanceReport.service;

import java.util.Date;
import java.util.List;

import edu.mum.tmAttendanceReport.entity.Student;
import edu.mum.tmAttendanceReport.entity.TMAttendance;

public interface TMAttendanceService {

	public List<TMAttendance> findAttendanceByDates(Student student, Date startDate,Date endDate);
}
