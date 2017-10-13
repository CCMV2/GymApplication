package com.ubb.gymapp.model;

import java.util.Date;
import java.util.List;

public class Pass {

	// trainer has special pass

	private long passId;
	private String name;
	private Double price;
	private List<Workout> workoutList;
	private Date start;
	private Integer duration;
	private List<User> userList;

	public Pass(long passId, String name, Double price, List<Workout> workoutList, List<User> userList) {
		this.passId = passId;
		this.name = name;
		this.price = price;
		this.workoutList = workoutList;
		this.userList = userList;
	}

	public long getPassId() {
		return passId;
	}

	public void setPassId(long passId) {
		this.passId = passId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public List<Workout> getWorkoutList() {
		return workoutList;
	}

	public void setWorkoutList(List<Workout> workoutList) {
		this.workoutList = workoutList;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

}
