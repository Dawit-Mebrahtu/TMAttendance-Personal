package edu.mum.tmAttendanceReport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import edu.mum.tmAttendanceReport.entity.DateInfo;

public interface DateInfoSeriviceRepository extends CrudRepository<DateInfo, Long> {

	
	@Query(value="SELECT d FROM DateInfo d WHERE d.date >=:startDate ")
	List<DateInfo> Daysgreaterthan(java.sql.Date startDate);

}
