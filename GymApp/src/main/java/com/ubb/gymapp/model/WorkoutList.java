package com.ubb.gymapp.model;

import java.io.Serializable;

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
public class WorkoutList implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 179028133535253208L;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((subscription == null) ? 0 : subscription.hashCode());
		result = prime * result + ((workout == null) ? 0 : workout.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WorkoutList other = (WorkoutList) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (subscription == null) {
			if (other.subscription != null)
				return false;
		} else if (!subscription.equals(other.subscription))
			return false;
		if (workout == null) {
			if (other.workout != null)
				return false;
		} else if (!workout.equals(other.workout))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "WorkoutList [id=" + id + ", subscription=" + subscription + ", workout=" + workout + "]";
	}
	
	
}
