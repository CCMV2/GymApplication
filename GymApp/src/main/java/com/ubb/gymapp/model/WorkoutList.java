package com.ubb.gymapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "workoutlist")
public class WorkoutList {
	
	private Long id;
	
	private Subscription subscription;
	
	private Workout workout;

	public WorkoutList(Subscription subscription, Workout workout) {
		super();
		this.subscription = subscription;
		this.workout = workout;
	}
	
	public WorkoutList() {
	}
	
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn (name = "idSubscription")
	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn (name = "idWorkout")
	public Workout getWorkout() {
		return workout;
	}

	public void setWorkout(Workout workout) {
		this.workout = workout;
	}
}
