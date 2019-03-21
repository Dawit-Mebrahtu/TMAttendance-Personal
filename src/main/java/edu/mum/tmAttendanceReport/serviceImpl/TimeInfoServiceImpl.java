package edu.mum.tmAttendanceReport.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.tmAttendanceReport.entity.TimeInfo;
import edu.mum.tmAttendanceReport.repository.TimeInfoRepository;
import edu.mum.tmAttendanceReport.service.TimeInfoService;

@Service
public class TimeInfoServiceImpl implements TimeInfoService{

	@Autowired
	private TimeInfoRepository timeInfoRepository;
	
	@Override
	public TimeInfo getByTimeOfDay(String timeOfDay) {
		return timeInfoRepository.getByTimeOfDay(timeOfDay);
	}

}
