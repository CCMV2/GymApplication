package com.ubb.gymapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="user")
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5987013838974216597L;
	private Long id;
	private String password;
	private String name;
	private String surname;
	private String email;
	private String phonenumber;
	private String userPermission;
	private Subscription subscription;
	
	public enum UserType {
		ADMIN, TRAINER, CLIENT
	};

	public User(String password, String name, String surname, String email, String phonenumber, String userType,
			Subscription pass) {
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phonenumber = phonenumber;
		this.userPermission = userType;
		this.subscription = pass;
	}
	
	public User() {
	}

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "idUser", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column (name = "Passw")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column (name = "Name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column (name = "Surname")
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	@Column (name = "Email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Column (name = "PhoneNr")
	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	@Column (name = "Type")
	public String getUserPermission() {
		return userPermission;
	}

	public void setUserPermission(String type) {
		this.userPermission = type;
	}
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn (name = "idSubscription")
	public Subscription getPass() {
		return subscription;
	}

	public void setPass(Subscription pass) {
		this.subscription = pass;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phonenumber == null) ? 0 : phonenumber.hashCode());
		result = prime * result + ((subscription == null) ? 0 : subscription.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result + ((userPermission == null) ? 0 : userPermission.hashCode());
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
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phonenumber == null) {
			if (other.phonenumber != null)
				return false;
		} else if (!phonenumber.equals(other.phonenumber))
			return false;
		if (subscription == null) {
			if (other.subscription != null)
				return false;
		} else if (!subscription.equals(other.subscription))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		if (userPermission == null) {
			if (other.userPermission != null)
				return false;
		} else if (!userPermission.equals(other.userPermission))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", name=" + name + ", surname=" + surname + ", email="
				+ email + ", phonenumber=" + phonenumber + ", userPermission=" + userPermission + ", subscription="
				+ subscription + "]";
	}
	
	
}
