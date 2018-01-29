package com.ubb.gymapp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "timetable")

public class Timetable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8162903751765800461L;
	private Long id;
	private String day;
	private Date start;
	private long duration;
	private Room room;
	private Workout workout;
	private Trainer trainer;
	
	public Timetable() {
	}
	
	public Timetable(String day, Date start, long duration, Room room,Workout workout) {
		this.day = day;
		this.start = start;
		this.duration = duration;
		this.room = room;
		this.workout = workout;
		
	}

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "idTimetable", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column (name = "day")	
	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}
	
	@Column (name = "start")	
	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	@Column (name = "duration")	
	public long getDuration() {
		return duration;
	}
	
	@OneToOne( fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "idTrainer", unique = true, nullable = false)
	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idRoom")
	public Room getRoom() {
		return room;
	}


	 
	public void setRoom(Room room) {
		this.room = room;
	}

	 @ManyToOne(fetch=FetchType.EAGER)
	 @JoinColumn(name="idWorkout")
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
		result = prime * result + ((day == null) ? 0 : day.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((room == null) ? 0 : room.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
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
		Timetable other = (Timetable) obj;
		if (day == null) {
			if (other.day != null)
				return false;
		} else if (!day.equals(other.day))
			return false;
		if (duration != other.duration)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (room == null) {
			if (other.room != null)
				return false;
		} else if (!room.equals(other.room))
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
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
		return "Timetable [id=" + id + ", day=" + day + ", start=" + start + ", duration=" + duration + ", room=" + room
				+ ", workout=" + workout + "]";
	}

	

	
}
