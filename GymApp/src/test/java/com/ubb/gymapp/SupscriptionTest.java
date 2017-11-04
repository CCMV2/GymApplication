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

import com.ubb.gymapp.model.Subscription;
import com.ubb.gymapp.repository.SubscriptionRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SupscriptionTest {
	
	@Autowired 
	private SubscriptionRepository subscriptionRepo;
	/**
	 * Test for CREATE
	 */
	@Test 
	public void addSubscription() {
		Subscription subscription = new Subscription("abo1",500.0);
		Date date = new GregorianCalendar(2017,10,04).getTime();
		subscription.setStart(date);
		subscription.setDuration(2);
		subscription = subscriptionRepo.save(subscription);
		Long id = subscription.getSubscriptionId();
		assertNotNull(id);
		Subscription subscriptionSaved = subscriptionRepo.findOne(id);
		
		assertEquals(subscription.getName(),subscriptionSaved.getName());
	    assertEquals(subscription.getPrice(),subscriptionSaved.getPrice(),0);
	    assertEquals(subscription.getStart(),subscriptionSaved.getStart());
	    assertEquals(subscription.getDuration(),subscriptionSaved.getDuration());
	   
//		subscriptionRepo.delete(subscription);
	}
	/**
	 * Tests for READ
	 */
	
	@Test
	public void readSubscriptions(){
//		Date dat = new GregorianCalendar(2017, 10, 04).getTime();
		Subscription s = subscriptionRepo.findOne(1L);
		assertNotNull(s);
		assertEquals(s.getName(),"abo1");
		assertEquals(s.getPrice(),500.0,0);
//		assertEquals(s.getStart(),dat);
		assertEquals(s.getDuration(),Integer.valueOf(2));
		
	}
	
	@Test
	public void readAllSubscriptions(){
		List<Subscription> subscriptionList = subscriptionRepo.findAll();
		assertNotNull(subscriptionList);
		assertEquals(subscriptionList.size(),1);
		
	}
	/**
	 * Test for UPDATE
	 */
	@Test
	public void updateSubscriptions(){
		Date date = new GregorianCalendar(2017, 11, 17).getTime(); // month is 12
		Subscription subscription = subscriptionRepo.findOne(1L);
		assertNotNull(subscription);
		
		subscription.setName("test");
		subscription.setPrice(700.0);
		subscription.setStart(date);
		subscription.setDuration(1);
		subscriptionRepo.save(subscription);
		Subscription dbSubscription = subscriptionRepo.findOne(subscription.getSubscriptionId());
		assertEquals(subscription.getName(),dbSubscription.getName());
		assertEquals(subscription.getPrice(),dbSubscription.getPrice());
		assertEquals(subscription.getStart(),dbSubscription.getStart());
		assertEquals(subscription.getDuration(),Integer.valueOf(dbSubscription.getDuration()));
	}
	/**
	 * Test for DELETE
	 */
	
	@Test
	public void deleteSubscription(){
		Subscription subscription = subscriptionRepo.findOne(1L);
		assertNotNull(subscription);
		subscriptionRepo.delete(subscription);
		boolean subscriptionExists = subscriptionRepo.exists(1L);
		assertFalse(subscriptionExists);
	}
	

	
		
	

}
