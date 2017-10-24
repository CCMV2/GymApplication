package com.ubb.gymapp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name = "timetable")
@SequenceGenerator (sequenceName = "timetable_seq", allocationSize = 1, name = "timetableSequence")

public class Timetable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8162903751765800461L;
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

	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "timetableSequence")
	@Column (name = "idTimetable", unique = true, nullable = false)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column (name = "Day")	
	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}
	
	@Column (name = "Start")	
	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	@Column (name = "Duration")	
	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	@Column (name = "room_idroom")	
	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	@Column (name = "idWorkout")	
	public Workout getWorkoutId() {
		return workout;
	}

	public void setWorkoutId(Workout workout) {
		this.workout = workout;
	}

}
