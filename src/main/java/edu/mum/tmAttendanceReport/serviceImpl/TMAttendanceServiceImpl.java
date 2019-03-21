package edu.mum.tmAttendanceReport.serviceImpl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.tmAttendanceReport.entity.TMAttendance;
import edu.mum.tmAttendanceReport.repository.TMAttendanceRepository;
import edu.mum.tmAttendanceReport.service.TMAttendanceService;

@Service
public class TMAttendanceServiceImpl implements TMAttendanceService{

	@Autowired
	private TMAttendanceRepository tmAttendanceRepository;
	
	
	@Override
	public List<TMAttendance> findAttendanceByDates(Long student,  Date startDate, Date endDate) {
		return tmAttendanceRepository.findAttendanceByDates(student,startDate, endDate);
	}
	
	@Override
	public TMAttendance save(TMAttendance tma) {
		return tmAttendanceRepository.save(tma);
	}


	@Override
	public List<TMAttendance> findTotalAttendance(Long student, Date startDate) {
		return tmAttendanceRepository.findTotalAttendance(student, startDate);
	}


	@Override
	public List<TMAttendance> findAttendanceById(Long studentid,Date date) {
		
		return tmAttendanceRepository.findAttendanceById(studentid,date) ;
	}

}
