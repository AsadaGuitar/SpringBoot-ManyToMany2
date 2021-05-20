package com.example.serviceB;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.entityB.Room;
import com.example.repositoryB.RoomRepository;

@Service
public class RoomService {

	@Autowired
	RoomRepository roomRepository;
	
	public Room save(Room room) {
		return roomRepository.save(room);
	}
	
	public Room update(Room room) {
		return roomRepository.save(room);
	}
	
	public Room findByName(String name) {
		return roomRepository.findByName(name);
	}

}
