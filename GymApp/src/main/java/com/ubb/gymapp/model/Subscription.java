package com.ubb.gymapp.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.ubb.gymapp.model.Rating;

@Entity
@Table(name = "subscription")
public class Subscription implements Serializable {

	// trainer has special pass

	/**
	 * 
	 */
	private static final long serialVersionUID = 3371998938019434314L;
	private Long subscriptionId;
	private String name;
	private Double price;
	private Integer duration;
	private Rating rat;
	private String imageBase64;
	private byte[] image;

	public Subscription(String name, Double price, byte[] image) {
		this.name = name;
		this.price = price;
		this.rat = new Rating(0.0, (long) 0);
		this.image = image;
	}

	public Subscription() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idSubscription", unique = true, nullable = false)
	public Long getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(Long subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	@Column(name = "Name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "Price")
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Column(name = "Duration")
	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "Rating", unique = true, nullable = false, updatable = false)
	public Rating getRat() {
		return rat;
	}

	public void setRat(Rating rat) {
		this.rat = rat;
	}
	
	@Transient
	public String getImageBase64() {
		return imageBase64;
	}

	public void setImageBase64(String imageBase64) {
		this.imageBase64 = imageBase64;
		byte[] bytes = imageBase64.getBytes();
		byte[] theBytes = new byte[bytes.length];
		for (int i = 0; i< bytes.length; i++){
			theBytes[i] =bytes[i];
		}
		this.image = theBytes;
	}
	
	@Column(name= "Pic")
	public byte[] getImage() {
		return image;
	}
	
	public void setImage(byte[] image) {
		if (image != null) {
			this.image = image;
			byte[] imageHelp = new byte[image.length];
			for (int i = 0; i < image.length; i++) {
				imageHelp[i] = image[i];
			}
			imageBase64 = new String(imageHelp);
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((subscriptionId == null) ? 0 : subscriptionId.hashCode());
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
		if (subscriptionId == null) {
			if (other.subscriptionId != null)
				return false;
		} else if (!subscriptionId.equals(other.subscriptionId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Subscription [subscriptionId=" + subscriptionId + ", name=" + name + ", price=" + price + ", start="
				+ ", duration=" + duration + "]";
	}

}
