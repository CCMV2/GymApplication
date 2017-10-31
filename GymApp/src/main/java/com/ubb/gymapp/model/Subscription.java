package com.ubb.gymapp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table (name = "subscription")
public class Subscription implements Serializable{

	// trainer has special pass

	/**
	 * 
	 */
	private static final long serialVersionUID = 3371998938019434314L;
	private Long subscriptionId;
	private String name;
	private Double price;
	private List<Workout> workoutList;
	private Date start;
	private Integer duration;
	private List<User> userList;

	public Subscription(long subscriptionId, String name, Double price, List<Workout> workoutList, List<User> userList) {
		this.subscriptionId = subscriptionId;
		this.name = name;
		this.price = price;
		this.workoutList = workoutList;
		this.userList = userList;
	}
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "idSubscription", unique = true, nullable = false)
	public long getPassId() {
		return subscriptionId;
	}

	public void setPassId(long passId) {
		this.subscriptionId = passId;
	}
	@Column (name = "Name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column (name = "Price")
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
	@Column (name = "Start")
	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}
	@Column (name = "Availability")
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		result = prime * result
				+ (int) (subscriptionId ^ (subscriptionId >>> 32));
		result = prime * result
				+ ((userList == null) ? 0 : userList.hashCode());
		result = prime * result
				+ ((workoutList == null) ? 0 : workoutList.hashCode());
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
		Subscription other = (Subscription) obj;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		if (subscriptionId != other.subscriptionId)
			return false;
		if (userList == null) {
			if (other.userList != null)
				return false;
		} else if (!userList.equals(other.userList))
			return false;
		if (workoutList == null) {
			if (other.workoutList != null)
				return false;
		} else if (!workoutList.equals(other.workoutList))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Subscription [subscriptionId=" + subscriptionId + ", name="
				+ name + ", price=" + price + ", workoutList=" + workoutList
				+ ", start=" + start + ", duration=" + duration + ", userList="
				+ userList + "]";
	}
	
	
	


}
