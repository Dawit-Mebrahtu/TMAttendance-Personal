package edu.mum.tmAttendanceReport.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.tmAttendanceReport.entity.Check;
import edu.mum.tmAttendanceReport.entity.Retreat;
import edu.mum.tmAttendanceReport.entity.Student;
import edu.mum.tmAttendanceReport.repository.CheckRepository;
import edu.mum.tmAttendanceReport.service.CheckService;


@Service
public class CheckServiceImpl implements CheckService {

	@Autowired
	CheckRepository checkRepository;
	
	@Override
	public Check findById(long id) {
		return checkRepository.findById(id).get();
	}

	@Override
	public Check save(Check check) {
		return checkRepository.save(check);
	}

	@Override
	public void deleteById(long id) {
		checkRepository.deleteById(id);
	}
	
	public Check findByStudentid(Student student) {
		return checkRepository.findByStudentId(student);
	}

}
