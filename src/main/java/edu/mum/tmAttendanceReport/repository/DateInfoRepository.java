package edu.mum.tmAttendanceReport.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.tmAttendanceReport.entity.Block;
import edu.mum.tmAttendanceReport.entity.DateInfo;

@Repository
public interface DateInfoRepository extends CrudRepository<DateInfo, Long>{

	public List<DateInfo> findByDateAfter(Date startDate);


}
