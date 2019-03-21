package edu.mum.tmAttendanceReport.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.tmAttendanceReport.entity.Block;

@Repository
public interface BlockRepository extends CrudRepository<Block, Long>{

	public List<Block> findByStartDateAfter(Date startDate);


}
