package com.ubb.gymapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ubb.gymapp.dto.SubscriptionWorkouts;
import com.ubb.gymapp.model.Subscription;
import com.ubb.gymapp.service.IAdminService;

@RestController
public class SubscriptionController {
	@Autowired
	private IAdminService adminService;
	
	@RequestMapping(value = "/listsubscription", method = RequestMethod.POST)
	public List<Subscription> findAllSubscriptions() {
		return adminService.findAllSubscriptions();
	}
	
	@RequestMapping(value="/createsubscription", method = RequestMethod.POST)
	public String addSubscription(@RequestBody SubscriptionWorkouts subscriptionWorkouts){
		try {
			adminService.addSubscription(subscriptionWorkouts);
			return "Successful";
		} catch (Exception e) {
			return "Failed: " + e.getMessage();
		}
		
	}
	@RequestMapping(value="/deletesubscription",method = RequestMethod.POST)
	public String deleteSubscription(@RequestBody Subscription subscription){
		try {
			adminService.deleteSubscription(subscription);
			return "Successful";
		} catch (Exception e) {
			return "Failed: " + e.getMessage();
		}
	}
}
