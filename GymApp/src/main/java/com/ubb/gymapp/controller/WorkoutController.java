package com.ubb.gymapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ubb.gymapp.dto.WorkoutTrainers;
import com.ubb.gymapp.model.User;
import com.ubb.gymapp.model.Workout;
import com.ubb.gymapp.service.UserService;
import com.ubb.gymapp.service.WorkoutService;

@RestController
public class WorkoutController {

	@Autowired
	private WorkoutService workoutService;
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/getallworkouts", method = RequestMethod.GET)
	public List<Workout> getAllWorkouts() {
		return workoutService.getAllWorkouts();
	}

	@RequestMapping(value = "/gettrainerworkouts", method = RequestMethod.GET)
	public List<WorkoutTrainers> findAllWorkoutTrainers() {
		return workoutService.getTrainerWorkouts();
	}

	@RequestMapping(value = "/deleteworkout", method = RequestMethod.POST)
	public String deleteWorkout(@RequestBody Workout parameter) {
		try {
			workoutService.deleteWorkout(parameter);
			return "Successful";
		} catch (Exception e) {
			return "Failed:" + e.getMessage(); 
		}
	}

	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/getalltrainers", method = RequestMethod.GET)
	public List<User> getAllTrainers() {
		return userService.getAllTrainers();
	}
	
	@RequestMapping(value = "/addworkouttrainers", method = RequestMethod.POST)
	public String addWorkoutTrainers(@RequestBody WorkoutTrainers workoutTrainers) {
		try {
			workoutService.addWorkoutTrainers(workoutTrainers);
			return "Successful";
		} catch (Exception e) {
			return "Failed: " + e.getMessage();
		}
	}
}