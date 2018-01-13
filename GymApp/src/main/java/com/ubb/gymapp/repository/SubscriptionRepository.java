package com.ubb.gymapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ubb.gymapp.model.Client;
import com.ubb.gymapp.model.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription,Long> {
	
	@Query("select s.clients from Subscription s where s.subscriptionId  in  (?1)")
	public List<Client> findClients(List<Long> list);
	
	/*Subscription findBySubscriptionId(Long subscriptionId);
	
	Subscription findByName(String name);
	
	Subscription findByPrice(Double price);
	
	Subscription findByDuration(Integer duration);
	
	Subscription findByRating(Double rat);*/

}
