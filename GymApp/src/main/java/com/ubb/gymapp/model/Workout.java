package com.ubb.gymapp.model;

public class Workout {

	private Integer workoutId;
	private String workoutType;
	private User trainer;
	private String difficulty;
	private String description;

	private enum Difficulties {
		EASY, MEDIUM, HARD
	};

	public Workout(Integer workoutId, String workoutType, User trainer, String difficulty, String description) {
		this.workoutId = workoutId;
		this.workoutType = workoutType;
		this.trainer = trainer;
		this.difficulty = difficulty;
		this.description = description;
	}

	public Integer getWorkoutId() {
		return workoutId;
	}

	public void setWorkoutId(Integer workoutId) {
		this.workoutId = workoutId;
	}

	public String getWorkoutType() {
		return workoutType;
	}

	public void setWorkoutType(String workoutType) {
		this.workoutType = workoutType;
	}

	public User getTrainer() {
		return trainer;
	}

	public void setTrainer(User trainer) {
		this.trainer = trainer;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Difficulties difficulty) {
		this.difficulty = difficulty.toString();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
