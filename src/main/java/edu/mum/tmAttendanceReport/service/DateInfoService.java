package edu.mum.tmAttendanceReport.service;

import java.util.Date;
import java.util.List;

import edu.mum.tmAttendanceReport.entity.DateInfo;

public interface DateInfoService {
	public List<DateInfo> findByDateAfter(Date startDate);
}
