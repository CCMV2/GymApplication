package com.ubb.gymapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ubb.gymapp.model.Room;
import com.ubb.gymapp.model.User;
import com.ubb.gymapp.service.IAdminService;

@RestController
public class Controller {
	
	@Autowired
	private IAdminService adminService;
	
	@RequestMapping (value = "/getallusers", method = RequestMethod.GET)
	public List<User> findAllUsers() {
		return adminService.getAllUsers();
	}
	
	@RequestMapping (value = "/getroom", method = RequestMethod.POST)
	public Room findOneRoom(@RequestBody Long parameter) {
		return adminService.getRoom(parameter);
	}
	
	@RequestMapping (value = "/adduser", method = RequestMethod.POST)
	public User addUser(@RequestBody User user) {
		return adminService.addUser(user);
	}
}
