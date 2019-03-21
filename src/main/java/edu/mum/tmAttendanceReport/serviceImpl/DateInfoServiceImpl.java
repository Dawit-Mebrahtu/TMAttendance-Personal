package edu.mum.tmAttendanceReport.serviceImpl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.tmAttendanceReport.entity.DateInfo;
import edu.mum.tmAttendanceReport.repository.DateInfoRepository;
import edu.mum.tmAttendanceReport.service.DateInfoService;

@Service
public class DateInfoServiceImpl implements DateInfoService {

	@Autowired
	private DateInfoRepository dateInfoRepository;
	
	@Override
	public DateInfo getDateInfoByDate(Date date) {
		return dateInfoRepository.getDateInfoByDate(date);
	}

	@Override
	public List<DateInfo> findByDateAfter(Date startDate) {
		return dateInfoRepository.findByDateAfter(startDate);
	}

	
	@Override
	public List<DateInfo> Daysgreaterthan(java.sql.Date startDate) {
		// TODO Auto-generated method stub
		return dateInfoRepository.Daysgreaterthan(startDate);
	}


	

}
