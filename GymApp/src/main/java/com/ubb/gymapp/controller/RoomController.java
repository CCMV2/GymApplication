package com.ubb.gymapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ubb.gymapp.model.Room;
import com.ubb.gymapp.service.RoomService;

@RestController
public class RoomController {

	@Autowired
	private RoomService roomService;

	

	@RequestMapping(value = "/getallrooms", method = RequestMethod.GET)
	public List<Room> findAllRooms() {
		return roomService.getAllRooms();
	}

	@RequestMapping(value = "/addroom", method = RequestMethod.POST)
	public String adddRoom(@RequestBody Room parameter) {
		roomService.addRoom(parameter);
		return "Save successful";
	}

	@RequestMapping(value = "/deleteroom", method = RequestMethod.POST)
	public String deleteRoom(@RequestBody Room parameter) {
		roomService.deleteRoom(parameter);
		return "Delete successful";
	}
}
