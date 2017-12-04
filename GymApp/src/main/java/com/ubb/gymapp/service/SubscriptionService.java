package com.ubb.gymapp.service;

import java.util.List;

import com.ubb.gymapp.dto.SubscriptionWorkouts;
import com.ubb.gymapp.model.Subscription;

public interface SubscriptionService {
	
	void addSubscription(SubscriptionWorkouts subscriptionWorkouts);
	List<Subscription> findAllSubscriptions();
	List<SubscriptionWorkouts> findSubcriptionsAndWorkouts();
	void deleteSubscription(Subscription subscription);


}
