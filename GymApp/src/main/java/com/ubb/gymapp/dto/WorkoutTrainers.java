package com.ubb.gymapp.dto;

import java.util.List;

import com.ubb.gymapp.model.Trainer;
import com.ubb.gymapp.model.Workout;

public class WorkoutTrainers {
	Workout workout;
	
	List<Trainer> trainers;
	
	public WorkoutTrainers (Workout workout, List<Trainer> trainers) {
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

	public List<Trainer> getTrainers() {
		return trainers;
	}

	public void setTrainers(List<Trainer> trainers) {
		this.trainers = trainers;
	}	

}
