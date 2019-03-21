package edu.mum.tmAttendanceReport.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import edu.mum.tmAttendanceReport.entity.Place;

@Repository
public interface PlaceRepository extends CrudRepository<Place, Long> {

	@Query(value="SELECT p FROM Place p WHERE p.name=:name")
	public Place getPlaceByName(String name);
}