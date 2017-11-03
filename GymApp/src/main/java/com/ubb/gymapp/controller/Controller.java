package com.ubb.gymapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ubb.gymapp.model.Room;
import com.ubb.gymapp.model.Subscription;
import com.ubb.gymapp.model.Timetable;
import com.ubb.gymapp.model.User;
import com.ubb.gymapp.model.Workout;
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
	
	@RequestMapping (value = "/getsubscription", method = RequestMethod.POST)
	public Subscription findOneSubscription(@RequestBody Long parameter) {
		return adminService.getSubscriptionById(parameter);
	}
	
	@RequestMapping (value = "/gettimetable", method = RequestMethod.POST)
	public Timetable findOneTimetable(@RequestBody Long parameter) {
		return adminService.getTimetableById(parameter);
	}
	
	@RequestMapping (value = "/getworkout", method = RequestMethod.POST)
	public Workout findOneWorkout(@RequestBody Long parameter) {
		return adminService.getWorkoutById(parameter);
	}
}
