package com.ubb.gymapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ubb.gymapp.model.Rating;
import com.ubb.gymapp.model.Subscription;
import com.ubb.gymapp.repository.SubscriptionRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SubscriptionTest {
	
	@Autowired 
	private SubscriptionRepository subscriptionRepo;
	/**
	 * Test for CREATE
	 */
	@Test 
	public void addSubscription() {
		Subscription subscription = new Subscription("abo1",500.0,10, null);
		subscription.setDuration(2);
		subscription = subscriptionRepo.save(subscription);
		Long id = subscription.getSubscriptionId();
		Subscription subscriptionSaved = subscriptionRepo.findOne(id);
		assertNotNull(subscriptionSaved);
		assertEquals(subscription.getName(),subscriptionSaved.getName());
	    assertEquals(subscription.getPrice(),subscriptionSaved.getPrice(),0);
	    assertEquals(subscription.getDuration(),subscriptionSaved.getDuration());
	    subscriptionRepo.delete(subscription);
	}
	
	/**
	 * Tests for READ
	 */
	
	@Test
	public void readOneSubscription(){
		Subscription subscription = new Subscription("testAbo",680.0,23, null);
		subscription = subscriptionRepo.save(subscription);
		Subscription dbSubscription = subscriptionRepo.findOne(subscription.getSubscriptionId());
		assertEquals(subscription, dbSubscription);
		subscriptionRepo.delete(subscription);
	}
	
	
	
	@Test
	public void readSubscriptions(){
		Subscription s1 = new Subscription("testAbo1",500.0, 23,null);
		Subscription s2 = new Subscription("testAbo2",700.0,23, null);
		Subscription s3 = new Subscription("testAbo3",840.0, 23,null);
		Subscription s4 = new Subscription("testAbo4",1000.0,23, null);
		long currentSubscriptions = subscriptionRepo.count();
		
		s1 = subscriptionRepo.save(s1);
		s2 = subscriptionRepo.save(s2);
		s3 = subscriptionRepo.save(s3);
		s4 = subscriptionRepo.save(s4);
		
		currentSubscriptions +=4;
		List<Subscription> dbSubscriptions = subscriptionRepo.findAll();
		

		assertNotNull(dbSubscriptions);
		assertEquals(dbSubscriptions.size(), currentSubscriptions);
		
		subscriptionRepo.delete(s1);
		subscriptionRepo.delete(s2);
		subscriptionRepo.delete(s3);
		subscriptionRepo.delete(s4);
	}
	

	/**
	 * Test for UPDATE
	 */
	@Test
	public void updateSubscriptions(){
		
		Date date = new GregorianCalendar(2017, 11, 17).getTime(); // month is December
		
		Subscription sub = new Subscription("testAbo",1000.0,23, null);
		sub = subscriptionRepo.save(sub);
		sub.setName("test");
		sub.setPrice(700.0);
		sub.setDuration(1);
		subscriptionRepo.save(sub);
		
		Subscription newSubscription = subscriptionRepo.findOne(sub.getSubscriptionId());
		assertNotNull(newSubscription);
		
		assertEquals(sub.getName(),newSubscription.getName());
		assertEquals(sub.getPrice(),newSubscription.getPrice());
		assertEquals(sub.getDuration(),Integer.valueOf(newSubscription.getDuration()));
		
		subscriptionRepo.delete(sub);
	}
	/**
	 * Test for DELETE
	 */
	
	@Test
	public void deleteSubscription(){
		Subscription subscription = new Subscription("testSubscriptions",890.0,23, null);
		subscription = subscriptionRepo.save(subscription);
		assertNotNull(subscription);
		subscriptionRepo.delete(subscription);
		boolean subscriptionExists = subscriptionRepo.exists(subscription.getSubscriptionId());
		assertFalse(subscriptionExists);
	}
	@Test
	public void testUpdateSubscriptionRating() {
		Subscription subscription = new Subscription("testSubscriptions",890.0, 23,null);
		subscription.setRat(new Rating(5.0,(long) 2));
		subscriptionRepo.save(subscription);
		Long id = subscription.getRat().getIdRating();
		assertNotNull(id);
	}

	
		
	

}
