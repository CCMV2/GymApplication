package com.ubb.gymapp.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.ubb.gymapp.model.Rating;

@Entity
@DiscriminatorValue(value = "TRAINER")
public class Trainer extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String password;
	private Rating rat;
	private String imageBase64;
	private byte[] image;

	public Trainer() {
		super();
	}

	public Trainer(String password, String name, String surname, String email, String phonenumber, byte[] image) {
		super(name, surname, email, phonenumber);
		this.password = password;
		this.rat = new Rating(0.0, 0L);
		this.image = image;
	}

	@Column(name = "Passw")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "Rating")
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

}
