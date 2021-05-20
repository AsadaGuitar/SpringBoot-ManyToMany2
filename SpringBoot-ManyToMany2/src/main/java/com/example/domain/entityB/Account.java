package com.example.domain.entityB;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="account")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	@ManyToMany
	@JoinTable(name="accounts_room_places",
				joinColumns=@JoinColumn(name="account_id", referencedColumnName="id"),
				inverseJoinColumns=@JoinColumn(name="room_place_id", referencedColumnName="id"))
	private List<RoomPlace> roomPlaces;
	
	@ManyToMany(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	@JoinTable(name="accounts_rooms",
			joinColumns=@JoinColumn(name="account_id", referencedColumnName="id"),
			inverseJoinColumns=@JoinColumn(name="room_id", referencedColumnName="id"))
	private List<Room> rooms;
}
