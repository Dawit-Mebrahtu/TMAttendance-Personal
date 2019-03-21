package edu.mum.tmAttendanceReport.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import edu.mum.tmAttendanceReport.entity.TimeInfo;

@Repository
public interface TimeInfoRepository extends CrudRepository<TimeInfo, Long> {

	@Query(value="SELECT t FROM TimeInfo t WHERE t.timeOfDay=:timeOfDay")
	public TimeInfo getByTimeOfDay(String timeOfDay);
}
