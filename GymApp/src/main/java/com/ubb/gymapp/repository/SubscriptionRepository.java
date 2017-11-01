package com.ubb.gymapp.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ubb.gymapp.model.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription,Long> {
	
	Subscription findBySubscriptionId(Long subscriptionId);
	
	Subscription findByName(String name);
	
	Subscription findByPrice(Double price);
	
	Subscription findByDuration(Integer duration);

}
