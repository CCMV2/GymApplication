package com.ubb.gymapp.model;

import java.util.Date;

public class Timetable {

	private long id;
	private String day;
	private Date start;
	private long duration;
	private Room room;
	private Workout workout;

	public Timetable(long id, String day, Date start, long duration, Room room, Workout workout) {
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

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Workout getWorkoutId() {
		return workout;
	}

	public void setWorkoutId(Workout workout) {
		this.workout = workout;
	}

}
