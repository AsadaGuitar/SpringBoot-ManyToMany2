package com.example.domain.entityB;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="room_place")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomPlace {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Integer roomId;
	
	private Integer friendId;
	
	@ManyToMany(mappedBy="roomPlaces", fetch=FetchType.LAZY)
	private List<Account> accounts;
}
