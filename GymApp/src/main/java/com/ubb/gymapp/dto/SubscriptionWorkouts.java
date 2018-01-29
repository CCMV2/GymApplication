package com.ubb.gymapp.dto;

import java.util.List;

import com.ubb.gymapp.model.Subscription;
import com.ubb.gymapp.model.Workout;

public class SubscriptionWorkouts {

	private Subscription subscription;
	private List<Workout> workouts;
	
	public Subscription getSubscription() {
		return subscription;
	}
	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}
	public List<Workout> getWorkouts() {
		return workouts;
	}
	public void setWorkouts(List<Workout> workouts) {
		this.workouts = workouts;
	}
	
	
	public SubscriptionWorkouts(Subscription subscription, List<Workout> workouts) {
		super();
		this.subscription = subscription;
		this.workouts = workouts;
	}
	
	public SubscriptionWorkouts(){
		
	}
	@Override
	public String toString() {
		return "SubscriptionWorkouts [subscription=" + subscription + ", workouts=" + workouts + "]";
	}
	
	
	
}
