package edu.mum.tmAttendanceReport.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.tmAttendanceReport.entity.Block;
import edu.mum.tmAttendanceReport.repository.BlockRepository;
import edu.mum.tmAttendanceReport.service.BlockService;

@Service
public class BlockServiceImpl implements BlockService {

	@Autowired
	private BlockRepository blockRepository;
	
	public List<Block> findAll(){
		return (List<Block>) blockRepository.findAll();
	}

	@Override
	public Block findById(Long id) {
		return blockRepository.findById(id).get();
	}

	@Override
	public List<Block> findByStartDateAfter(Date startDate) {
		return blockRepository.findByStartDateAfter(startDate);
	}
}
