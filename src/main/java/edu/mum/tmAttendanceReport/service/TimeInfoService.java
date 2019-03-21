package edu.mum.tmAttendanceReport.service;

import edu.mum.tmAttendanceReport.entity.TimeInfo;

public interface TimeInfoService {
	
	public TimeInfo getByTimeOfDay(String timeOfDay);
}
