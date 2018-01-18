package com.ubb.gymapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ubb.gymapp.model.Administrator;
import com.ubb.gymapp.model.Client;
import com.ubb.gymapp.model.ClientTimetable;
import com.ubb.gymapp.model.Trainer;
import com.ubb.gymapp.model.User;
import com.ubb.gymapp.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/listusers", method = RequestMethod.GET)
	public List<User> findAllUsers(){
		return userService.getAllUsers();
	}
	
	@RequestMapping(value = "/createclient", method = RequestMethod.POST)
	public String addClient(@RequestBody Client client){
		try{
			userService.addUser(client);
			return "Successful";
		} catch (Exception e) {
			return "Failed:" + e.getMessage();
		}
	}
	@RequestMapping(value = "/createadmin", method = RequestMethod.POST)
	public String addAdmin(@RequestBody Administrator admin){
		try{
			userService.addUser(admin);
			return "Successful";
		} catch (Exception e) {
			return "Failed:" + e.getMessage();
		}
	}
	@RequestMapping(value = "/createtrainer", method = RequestMethod.POST)
	public String addTrainer(@RequestBody Trainer trainer){
		try{
			userService.addUser(trainer);
			return "Successful";
		} catch (Exception e) {
			return "Failed:" + e.getMessage();
		}
	}
	
	@RequestMapping(value = "/deleteadmin", method=RequestMethod.POST)
	public String deleteAdmin(@RequestBody Administrator admin){
		try {
			userService.deleteUser(admin);
			return "Successful";
		} catch (Exception e) {
			return "Failed:" + e.getMessage(); 
		}
	}
	
	@RequestMapping(value = "/deleteclient", method=RequestMethod.POST)
	public String deleteClient(@RequestBody Client client){
		try {
			userService.deleteUser(client);
			return "Successful";
		} catch (Exception e) {
			return "Failed:" + e.getMessage(); 
		}
	}
	
	@RequestMapping(value = "/deletetrainer", method=RequestMethod.POST)
	public String deleteTrainer(@RequestBody Trainer trainer){
		try {
			userService.deleteUser(trainer);
			return "Successful";
		} catch (Exception e) {
			return "Failed:" + e.getMessage(); 
		}
	}
	
	@RequestMapping(value = "/addclienttimetable", method=RequestMethod.POST)
	public String addClientTimetable(@RequestBody ClientTimetable clientTimetable) {
		try{
			return this.userService.addUserTimetable(clientTimetable);
		}catch (Exception e) {
			return "Failed:" + e.getMessage();
		}
	}
	
	@RequestMapping(value = "/deleteclienttimetable", method=RequestMethod.POST)
	public String deleteClientTimetable(@RequestBody ClientTimetable clientTimetable) {
		try{
			return this.userService.deleteUserTimetable(clientTimetable);
		}catch (Exception e) {
			return "Failed:" + e.getMessage();
		}
	}
	
	@RequestMapping(value = "/getclienttimetables", method=RequestMethod.POST)
	public List<ClientTimetable> getClientTimetables(@RequestBody Client client) {
		return this.userService.findByClient(client);
	}
	
	@RequestMapping(value = "/findUserById", method=RequestMethod.POST)
	public User getUserbyId(@RequestBody Long id) {
		return this.userService.findUserById(id);
	}
}
