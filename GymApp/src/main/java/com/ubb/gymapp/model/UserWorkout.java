package com.ubb.gymapp.model;

public class UserWorkout {

	private User trainer;
	
	private Workout workout;

	public User getUser() {
		return trainer;
	}

	public void setUser(User user) {
		this.trainer = user;
	}

	public Workout getWorkout() {
		return workout;
	}

	public void setWorkout(Workout workout) {
		this.workout = workout;
	}
}
