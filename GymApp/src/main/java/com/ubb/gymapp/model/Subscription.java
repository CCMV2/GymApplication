package com.ubb.gymapp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	private Date start;
	private Integer duration;

	public Subscription(long subscriptionId, String name, Double price) {
		this.subscriptionId = subscriptionId;
		this.name = name;
		this.price = price;
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
	@Column (name = "Start")
	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}
	@Column (name = "Duration")
	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	
	
	
}
