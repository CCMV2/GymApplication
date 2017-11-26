package com.ubb.gymapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ubb.gymapp.model.User;
import com.ubb.gymapp.service.IAdminService;

@RestController
public class UserController {
	@Autowired
	private IAdminService adminService;
	
	@RequestMapping(value = "/listusers", method = RequestMethod.POST)
	public List<User> findAllUsers(){
		return adminService.getAllUsers();
	}
	
	@RequestMapping(value = "/createuser", method = RequestMethod.POST)
	public String addUser(@RequestBody User user){
		try{
			adminService.addUser(user);
			return "Successful";
		} catch (Exception e) {
			return "Failed:" + e.getMessage();
		}
	}
	
	@RequestMapping(value = "/deleteuser", method=RequestMethod.POST)
	public String deleteUser(@RequestBody User user){
		try {
			adminService.deleteUser(user);
			return "Successful";
		} catch (Exception e) {
			return "Failed:" + e.getMessage(); 
		}
	}
	
	
}
