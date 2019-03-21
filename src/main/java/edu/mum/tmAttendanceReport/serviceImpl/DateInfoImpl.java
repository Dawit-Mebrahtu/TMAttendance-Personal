package edu.mum.tmAttendanceReport.serviceImpl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.tmAttendanceReport.entity.DateInfo;
import edu.mum.tmAttendanceReport.repository.DateInfoSeriviceRepository;
import edu.mum.tmAttendanceReport.service.DateInfoService;


@Service
public class DateInfoImpl implements DateInfoService {
	
	
	@Autowired
	DateInfoSeriviceRepository dateInfoSeriviceRepository;

	@Override
	public List<DateInfo> Daysgreaterthan(java.sql.Date startDate) {
		// TODO Auto-generated method stub
		return dateInfoSeriviceRepository.Daysgreaterthan(startDate);
	}

	@Override
	public List<DateInfo> findByDateAfter(Date startDate) {
		// TODO Auto-generated method stub
		return null;
	}

}
