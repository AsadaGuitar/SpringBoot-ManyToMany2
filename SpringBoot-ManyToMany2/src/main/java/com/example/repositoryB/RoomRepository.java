package com.example.repositoryB;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.entityB.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer>{
	
	public Room findByName(String name);
}
