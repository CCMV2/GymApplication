package com.ubb.gymapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ubb.gymapp.dto.WorkoutTrainers;
import com.ubb.gymapp.model.Workout;

@Service
public interface WorkoutService {

	List<WorkoutTrainers> getTrainerWorkouts();
	List<Workout> getAllWorkouts();
	void addWorkoutTrainers(WorkoutTrainers workoutTrainers);
	void deleteWorkout(Workout workout);

}
