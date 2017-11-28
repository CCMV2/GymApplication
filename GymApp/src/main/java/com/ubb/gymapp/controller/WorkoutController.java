package com.ubb.gymapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ubb.gymapp.model.User;
import com.ubb.gymapp.model.UserWorkout;
import com.ubb.gymapp.model.Workout;
import com.ubb.gymapp.service.IAdminService;

@RestController
public class WorkoutController {

	@Autowired
	private IAdminService adminService;

	@RequestMapping(value = "/getworkout", method = RequestMethod.POST)
	public Workout findOneWorkout(@RequestBody Long parameter) {
		return adminService.getWorkoutById(parameter);
	}

	@RequestMapping(value = "/getallworkouts", method = RequestMethod.GET)
	public List<Workout> getAllWorkouts() {
		return adminService.getAllWorkouts();
	}

	@RequestMapping(value = "/addtrainerworkout", method = RequestMethod.POST)
	public boolean addWorkout(@RequestBody UserWorkout userWorkout) {
		try {
			adminService.addTrainerWorkout(userWorkout);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@RequestMapping(value = "/gettrainerworkouts", method = RequestMethod.GET)
	public List<UserWorkout> findAllWorkouts() {
		return adminService.getTrainerWorkouts();
	}

	@RequestMapping(value = "/deleteworkout", method = RequestMethod.POST)
	public boolean deleteWorkout(@RequestBody Workout parameter) {
		try {
			adminService.deleteWorkout(parameter);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@RequestMapping(value = "/getalltrainers", method = RequestMethod.GET)
	public List<User> getAllTrainers() {
		return adminService.getAllTrainers();
	}

	@RequestMapping(value = "/getalluserworkoutsbyworkout", method = RequestMethod.GET)
	public List<UserWorkout> getAllUserWorkoutsByWorkout(@RequestBody Workout workout) {
		return adminService.getAllUserWorkoutsForWorkout(workout);

	}
	
//	@RequestMapping(value = "/getusersbyworkout", method = RequestMethod.GET)
//	public List<User> getAllUsersByWorkout(@RequestBody Workout workout) {
//		return adminService.getAllUsersForWorkout(workout);
//
//	}

	@RequestMapping(value = "/updatetrainerworkout", method = RequestMethod.POST)
	public String updateTrainerWorkout(@RequestBody UserWorkout userWorkout) {
		try {
			adminService.updateTrainerWorkout(userWorkout);
			return "Successful";
		} catch (Exception e) {
			return "Failed: " + e.getMessage();
		}

	}
}