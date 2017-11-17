package com.ubb.gymapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.ubb.gymapp.repository.WorkoutRepository;
import com.ubb.gymapp.service.IAdminService;

@RestController
public class Controller {
	
	@Autowired
	private IAdminService adminService;
	@Autowired
	WorkoutRepository workoutRepo;
	
	@RequestMapping (value = "/getallusers", method = RequestMethod.GET)
	public List<User> findAllUsers() {
		return adminService.getAllUsers();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping (value = "/getallrooms", method = RequestMethod.GET)
	public List<Room> findAllRooms() {
		return adminService.getAllRooms();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping (value = "/addroom", method = RequestMethod.POST)
	public String adddRoom(@RequestBody Room parameter) {
		adminService.addRoom(parameter);
		return "Save successful";
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping (value = "/deleteroom", method = RequestMethod.POST)
	public String deleteRoom(@RequestBody Room parameter) {
		adminService.deleteRoom(parameter);
		return "Delete successful";
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
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping (value = "/addworkout", method = RequestMethod.POST)
	public Workout addWorkout(@RequestBody Workout workout) {
		
		return workoutRepo.save(workout);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping (value = "/getallworkouts", method = RequestMethod.GET)
	public List<Workout> findAllWorkouts() {
		return adminService.getAllWorkouts();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping (value = "/deleteworkout", method = RequestMethod.POST)
	public String deleteWorkout(@RequestBody Workout parameter) {
		adminService.deleteWorkout(parameter);
		return "Delete successful";
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping (value = "/getalltrainers", method = RequestMethod.GET)
	public List<User> getAllTrainers () {
		return adminService.getAllTrainers();
	}
	
}
