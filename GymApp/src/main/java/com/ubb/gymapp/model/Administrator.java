package com.ubb.gymapp.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "ADMIN")
public class Administrator extends User{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String password;
	
	public Administrator() {
		super();
	}

	public Administrator(String password, String name, String surname, String email, String phonenumber) {
		super(name, surname, email, phonenumber);
		this.password = password;
	}
	
	@Column(name = "Passw")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
