package com.ubb.gymapp.dto;

public class ClientTimetable {
	private String client;
	private Long timetable;
	
	public ClientTimetable (String client, Long timetable) {
		this.client = client;
		this.timetable = timetable;
	}
	
	public ClientTimetable() {}
	
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public Long getTimetable() {
		return timetable;
	}
	public void setTimetable(Long timetable) {
		this.timetable = timetable;
	}
}
