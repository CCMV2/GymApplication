package com.ubb.gymapp.model;

public class User {

	private long id;
	private String password;
	private String name;
	private String surname;
	private String email;
	private long phonenumber;
	private String userPermission;
	private Subscription pass;

	private enum UserType {
		ADMIN, TRAINER, CLIENT
	};

	public User(long id, String password, String name, String surname, String email, long phonenumber, String userType,
			Subscription pass) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phonenumber = phonenumber;
		this.userPermission = userType;
		this.pass = pass;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getUserPermission() {
		return userPermission;
	}

	public void setUserPermission(UserType type) {
		this.userPermission = type.toString();
	}

	public Subscription getPass() {
		return pass;
	}

	public void setPass(Subscription pass) {
		this.pass = pass;
	}

}
