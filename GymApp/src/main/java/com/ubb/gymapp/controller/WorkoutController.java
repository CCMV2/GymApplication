package com.ubb.gymapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ubb.gymapp.dto.WorkoutTrainers;
import com.ubb.gymapp.model.User;
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

	@RequestMapping(value = "/gettrainerworkouts", method = RequestMethod.GET)
	public List<WorkoutTrainers> findAllWorkoutTrainers() {
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
	
	@RequestMapping(value = "/addworkouttrainers", method = RequestMethod.POST)
	public String addWorkoutTrainers(@RequestBody WorkoutTrainers workoutTrainers) {
		try {
			adminService.addWorkoutTrainers(workoutTrainers);
			return "Successful";
		} catch (Exception e) {
			return "Failed: " + e.getMessage();
		}
	}
}