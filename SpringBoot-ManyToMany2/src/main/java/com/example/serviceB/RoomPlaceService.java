package com.example.serviceB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.entityB.RoomPlace;
import com.example.repositoryB.RoomPlaceRepository;

@Service
public class RoomPlaceService {

	@Autowired
	RoomPlaceRepository roomPlaceRepository;
	
	public RoomPlace create(RoomPlace roomPlace) {
		return roomPlaceRepository.save(roomPlace);
	}
}
