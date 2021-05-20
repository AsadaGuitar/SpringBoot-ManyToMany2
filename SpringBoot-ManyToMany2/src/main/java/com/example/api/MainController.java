package com.example.api;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.domain.UserForm;

import com.example.domain.entityB.Account;
import com.example.domain.entityB.Room;
import com.example.domain.entityB.RoomPlace;

import com.example.serviceB.AccountService;
import com.example.serviceB.RoomPlaceService;
import com.example.serviceB.RoomService;

@Controller
@RequestMapping("/")
public class MainController {
	
	/*
	 * メモ
	 * 
	 * @ManyToManyでは所有者側からしか参照出来ない。
	 * 登録出来るのは所有者側からのみ
	 * 登録するインスタンスにはIDが必要
	 * 
	 */
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	RoomService roomService;
	
	@Autowired
	RoomPlaceService roomPlaceService;
	
	
	@ModelAttribute
	UserForm setUserForm() {
		return new UserForm();
	}

	@GetMapping
	public String viewMain(Model model) {
		return "Home";
	}
	
	@PostMapping(path="/create")
	@Transactional
	public String viewCreate(
			@RequestParam("userName") String userName,
			@RequestParam("friendName") String friendName,
			@RequestParam("roomName") String roomName,
			Model model) {
		
		/*
		 * OverView
		 * 
		 * インスタンスの作成
		 * RoomPlaceに設定する Friend と Room のIDを発行
		 * RoomPlaceに Friend と Room のIDを設定
		 * Room と RoomPlace を登録し、IDを持たせる
		 * AccountにIDを持つRoomとRoomPlaceを登録
		 * Accountを登録し、登録された Account をDBから取得
		 * 登録された Account の中身を確認
		 * 
		 */
		
		
		/*
		 * インスタンスの新規作成
		 */
		Account account = new Account();
		account.setName(userName);
		
		Account friend = new Account();
		friend.setName(friendName);
		
		Room room = new Room();
		room.setName(roomName);
		
		RoomPlace roomPlace = new RoomPlace();
		
		/*
		 * RoomPlaceに設定する Friend と Room のIDの発行
		 */
		var createdFriend = accountService.create(friend);
		var createdRoom = roomService.save(room);
		Integer friendId = createdFriend.getId();
		Integer roomId = createdRoom.getId();
		
		/*
		 * RoomPlaceに Friend と Room のIDを設定
		 */
		roomPlace.setFriendId(friendId);
		roomPlace.setRoomId(roomId);
		
		/*
		 * RoomPlace を登録し、IDを持たせる
		 */
		RoomPlace createdRoomPlace = roomPlaceService.create(roomPlace);
		
		/*
		 * AccountにIDを持つRoomとRoomPlaceを登録
		 */
		account.setRooms(Arrays.asList(createdRoom));
		account.setRoomPlaces(Arrays.asList(createdRoomPlace));
		
		/*
		 * Accountを登録、登録された Account をDBから取得
		 */
		var updatedAccount = accountService.create(account);
		
		/*
		 * 登録された Account の中身を確認
		 */
		
		System.out.println(updatedAccount);
		
		return "Home";
		
	}
	
	
	
	
	
	
	
	
}
