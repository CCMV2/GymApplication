package com.ubb.gymapp.dto;

import java.util.List;

import com.ubb.gymapp.model.User;
import com.ubb.gymapp.model.Workout;

public class WorkoutTrainers {
	Workout workout;
	
	List<User> trainers;
	
	public WorkoutTrainers (Workout workout, List<User> trainers) {
		this.workout = workout;
		this.trainers = trainers;
	}
	
	public WorkoutTrainers (){}
	
	public Workout getWorkout() {
		return workout;
	}

	public void setWorkout(Workout workout) {
		this.workout = workout;
	}

	public List<User> getTrainers() {
		return trainers;
	}

	public void setTrainers(List<User> trainers) {
		this.trainers = trainers;
	}	

}
