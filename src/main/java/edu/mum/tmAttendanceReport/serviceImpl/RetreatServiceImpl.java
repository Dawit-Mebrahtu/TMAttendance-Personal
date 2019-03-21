package edu.mum.tmAttendanceReport.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.tmAttendanceReport.entity.Retreat;
import edu.mum.tmAttendanceReport.entity.Student;
import edu.mum.tmAttendanceReport.repository.RetreatRepository;
import edu.mum.tmAttendanceReport.service.RetreatService;

@Service
public class RetreatServiceImpl implements RetreatService {

	@Autowired
	RetreatRepository retreatRepository;
	
	@Override
	public Retreat findById(long id) {
		return retreatRepository.findById(id).get();
	}

	@Override
	public Retreat save(Retreat retreat) {
		return retreatRepository.save(retreat);
	}

	@Override
	public void deleteById(long id) {
		retreatRepository.deleteById(id);
	}
	
	public Retreat findByStudentid(Student student) {
		return retreatRepository.findByStudentid(student);
	}

}
