package com.ubb.gymapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ubb.gymapp.model.Room;
import com.ubb.gymapp.service.IAdminService;

@RestController
public class Controller {

	@Autowired
	private IAdminService adminService;

	

	@RequestMapping(value = "/getallrooms", method = RequestMethod.GET)
	public List<Room> findAllRooms() {
		return adminService.getAllRooms();
	}

	@RequestMapping(value = "/addroom", method = RequestMethod.POST)
	public String adddRoom(@RequestBody Room parameter) {
		adminService.addRoom(parameter);
		return "Save successful";
	}

	@RequestMapping(value = "/deleteroom", method = RequestMethod.POST)
	public String deleteRoom(@RequestBody Room parameter) {
		adminService.deleteRoom(parameter);
		return "Delete successful";
	}

	@RequestMapping(value = "/getroom", method = RequestMethod.POST)
	public Room findOneRoom(@RequestBody Long parameter) {
		return adminService.getRoom(parameter);
	}
}
