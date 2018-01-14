package com.ubb.gymapp.dto;

import java.util.List;

import com.ubb.gymapp.model.Subscription;

public class Mail {
	private String subject;
	private List<Subscription> subs;
	private String body;
	
	public Mail(String subject, List<Subscription> subs, String body){
		this.subject=subject;
		this.subs=subs;
		this.body=body;
	}
	
	public Mail(){
		
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public List<Subscription> getSubs() {
		return subs;
	}

	public void setSubs(List<Subscription> subs) {
		this.subs = subs;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	
}
