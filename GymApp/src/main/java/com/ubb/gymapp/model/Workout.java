package com.ubb.gymapp.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "workout")
public class Workout implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5485075350217272508L;
	private Long idWorkout;
	private String workoutType;
	private Difficulty difficulty;
	private String description;

	public enum Difficulty {
		EASY, MEDIUM, HARD
	};

	public Workout() {
	}

	public Workout(String workoutType, Difficulty difficulty, String description) {
		this.workoutType = workoutType;
		this.difficulty = difficulty;
		this.description = description;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idWorkout", unique = true, nullable = false)
	public Long getIdWorkout() {
		return idWorkout;
	}

	@Column(name = "WorkoutType")
	public String getWorkoutType() {
		return workoutType;
	}

	public void setIdWorkout(Long idWorkout) {
		this.idWorkout = idWorkout;
	}

	public void setWorkoutType(String workoutType) {
		this.workoutType = workoutType;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "Difficulty")
	public Difficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	@Column(name = "Descr")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "workout", cascade = CascadeType.PERSIST)
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((difficulty == null) ? 0 : difficulty.hashCode());
		result = prime * result + ((idWorkout == null) ? 0 : idWorkout.hashCode());
		result = prime * result + ((workoutType == null) ? 0 : workoutType.hashCode());
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
		Workout other = (Workout) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (difficulty == null) {
			if (other.difficulty != null)
				return false;
		} else if (!difficulty.equals(other.difficulty))
			return false;
		if (idWorkout == null) {
			if (other.idWorkout != null)
				return false;
		} else if (!idWorkout.equals(other.idWorkout))
			return false;
		if (workoutType == null) {
			if (other.workoutType != null)
				return false;
		} else if (!workoutType.equals(other.workoutType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Workout [workoutId=" + idWorkout + ", workoutType=" + workoutType + ", difficulty=" + difficulty
				+ ", description=" + description + "]";
	}

}
