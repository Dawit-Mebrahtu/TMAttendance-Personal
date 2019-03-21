package edu.mum.tmAttendanceReport.service;

import java.util.Date;
import java.util.List;
import edu.mum.tmAttendanceReport.entity.DateInfo;

public interface DateInfoService {
	
	public DateInfo getDateInfoByDate(Date date);
	public List<DateInfo> findByDateAfter(Date startDate);
	public List<DateInfo> Daysgreaterthan(java.sql.Date startDate);


}
