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
@Table (name = "user_has_workout")
public class UserWorkout implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3427660410017207062L;

	private Long id;
	
	private User trainer;
	
	private Workout workout;

	public UserWorkout() {
	}
	
	public UserWorkout(User trainer, Workout workout) {
		super();
		this.trainer = trainer;
		this.workout = workout;
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
	@JoinColumn (name = "idUser")
	public User getTrainer() {
		return trainer;
	}

	public void setTrainer(User trainer) {
		this.trainer = trainer;
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
		result = prime * result + ((trainer == null) ? 0 : trainer.hashCode());
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
		UserWorkout other = (UserWorkout) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (trainer == null) {
			if (other.trainer != null)
				return false;
		} else if (!trainer.equals(other.trainer))
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
		return "UserWorkout [id=" + id + ", trainer=" + trainer + ", workout=" + workout + "]";
	}
	
	
}
