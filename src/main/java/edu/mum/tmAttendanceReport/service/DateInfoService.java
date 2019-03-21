package edu.mum.tmAttendanceReport.service;

import java.util.List;

import edu.mum.tmAttendanceReport.entity.DateInfo;

public interface DateInfoService {

	List<DateInfo> Daysgreaterthan(java.sql.Date startDate);

}
