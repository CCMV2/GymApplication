package com.ubb.gymapp.model;

public class Timetable {

	private long id;
	private String day;
	private Double start;
	private Double duration;
	private String room;
	private Workout workout;

	public Timetable(long id, String day, Double start, Double duration, String room, Workout workout) {
		this.id = id;
		this.day = day;
		this.start = start;
		this.duration = duration;
		this.room = room;
		this.workout = workout;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public Double getStart() {
		return start;
	}

	public void setStart(Double start) {
		this.start = start;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public Workout getWorkoutId() {
		return workout;
	}

	public void setWorkoutId(Workout workout) {
		this.workout = workout;
	}

}
