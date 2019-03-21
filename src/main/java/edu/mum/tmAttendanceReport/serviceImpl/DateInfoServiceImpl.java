package edu.mum.tmAttendanceReport.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mum.tmAttendanceReport.entity.DateInfo;
import edu.mum.tmAttendanceReport.repository.DateInfoRepository;
import edu.mum.tmAttendanceReport.service.DateInfoService;

@Repository
public class DateInfoServiceImpl implements DateInfoService {

	@Autowired
	DateInfoRepository dateInfoRepository;
	
	@Override
	public List<DateInfo> findByDateAfter(Date startDate) {
		return dateInfoRepository.findByDateAfter(startDate);
	}

}
