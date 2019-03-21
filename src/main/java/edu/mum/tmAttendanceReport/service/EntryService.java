package edu.mum.tmAttendanceReport.service;

import java.util.List;

import edu.mum.tmAttendanceReport.entity.Entry;

public interface EntryService {

	List<Entry> findAll();

	Entry getEntryID(Long longid);

	
	
}
