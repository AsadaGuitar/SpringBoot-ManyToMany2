package com.example.repositoryB;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.entityB.RoomPlace;

@Repository
public interface RoomPlaceRepository extends JpaRepository<RoomPlace, Integer>{

}
