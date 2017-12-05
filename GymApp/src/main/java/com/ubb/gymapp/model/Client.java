package com.ubb.gymapp.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue(value = "CLIENT")
public class Client extends User{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cnp;
	private Subscription subscription;
	private Date start;
	private List<Timetable> userTimetable;
	public Client() {
		super();
	}
	
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name="user_timetable",
        joinColumns = @JoinColumn( name="idUser"),
        inverseJoinColumns = @JoinColumn( name="idTimetable")
    )
	public List<Timetable> getUserTimetable() {
		return userTimetable;
	}



	public void setUserTimetable(List<Timetable> userTimetable) {
		this.userTimetable = userTimetable;
	}



	public Client(String cnp, String name, String surname, String email, String phonenumber) {
		super(name, surname, email, phonenumber);
		this.cnp = cnp;
	}
	
	@Column(name = "Passw")
	public String getCnp() {
		return cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idSubscription")
	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription pass) {
		this.subscription = pass;
	}

	@Column (name = "Start")
	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	
	@Override
	@Transient
	public String getPassword() {
		return this.cnp;
	}
	
	public  void addTimeTable(Timetable timeTable){
		if(userTimetable == null){
			userTimetable = new ArrayList<Timetable>();
		}
		
		userTimetable.add(timeTable);
	}
}