package edu.mum.tmAttendanceReport.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.tmAttendanceReport.entity.Entry;
import edu.mum.tmAttendanceReport.repository.EntryRepository;
import edu.mum.tmAttendanceReport.service.EntryService;


@Service
public class EntryServiceImpl implements EntryService {

	
	@Autowired
	EntryRepository entryrepository;
	@Override
	public List<Entry> findAll() {
		return (List<Entry>) entryrepository.findAll();
	}
	@Override
	public Entry getEntryID(Long longid) {
		return entryrepository.getEntryID(longid);
		
	}

}
