package edu.mum.tmAttendanceReport.service;

import java.util.Date;
import edu.mum.tmAttendanceReport.entity.DateInfo;

public interface DateInfoService {

	public DateInfo getDateInfoByDate(Date date);
}
