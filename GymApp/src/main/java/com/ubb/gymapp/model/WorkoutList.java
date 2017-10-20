package com.ubb.gymapp.model;

public class WorkoutList {
	
	private Subscription subscription;
	
	private Workout workout;

	public WorkoutList(Subscription subscription, Workout workout) {
		super();
		this.subscription = subscription;
		this.workout = workout;
	}

	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

	public Workout getWorkout() {
		return workout;
	}

	public void setWorkout(Workout workout) {
		this.workout = workout;
	}
}
