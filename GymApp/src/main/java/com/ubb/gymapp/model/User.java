package com.ubb.gymapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="users")
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
	private long phonenumber;
	private String userPermission;
	private Subscription pass;
	
	private enum UserType {
		ADMIN, TRAINER, CLIENT
	};

	public User(Long id, String password, String name, String surname, String email, long phonenumber, String userType,
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
	public long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	@Column (name = "Type")
	public String getUserPermission() {
		return userPermission;
	}

	public void setUserPermission(UserType type) {
		this.userPermission = type.toString();
	}
	@Column (name = "PassID")
	public Subscription getPass() {
		return pass;
	}

	public void setPass(Subscription pass) {
		this.pass = pass;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userPermission == null) ? 0 : userPermission.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (int) (phonenumber ^ (phonenumber >>> 32));
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
		if (id != other.id)
			return false;
		
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		
		if (userPermission == null) {
			if (other.userPermission != null)
				return false;
		} else if (!userPermission.equals(other.userPermission))
			return false;
		
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		
		if (phonenumber != other.phonenumber)
			return false;
		
		if (pass == null) {
			if (other.pass != null)
				return false;
			
			
		} else if (!pass.equals(other.pass))
			return false;
		
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}
}
