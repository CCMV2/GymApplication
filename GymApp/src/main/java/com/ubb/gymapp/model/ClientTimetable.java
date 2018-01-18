package com.ubb.gymapp.model;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "user_timetable")
public class ClientTimetable implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2794398082420358379L;
	private Long id;
	private Client client;
	private Timetable timetable;
	private Date day;

	public ClientTimetable(Client client, Timetable timetable) {
		this.client = client;
		this.timetable = timetable;
	}
	
	
	@Column(name = "day")
	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}
	
	public ClientTimetable() {}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idUser")
	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idTimetable")
	public Timetable getTimetable() {
		return timetable;
	}

	public void setTimetable(Timetable timetable) {
		this.timetable = timetable;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
