package edu.mum.tmAttendanceReport.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.tmAttendanceReport.entity.Place;
import edu.mum.tmAttendanceReport.repository.PlaceRepository;
import edu.mum.tmAttendanceReport.service.PlaceService;

@Service
public class PlaceServiceImpl implements PlaceService{

	@Autowired
	private PlaceRepository placeRepository;
	
	@Override
	public Place getPlaceByName(String name) {
		return placeRepository.getPlaceByName(name);
	}

}
