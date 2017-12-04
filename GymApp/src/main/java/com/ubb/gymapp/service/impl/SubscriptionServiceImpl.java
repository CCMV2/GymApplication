package com.ubb.gymapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ubb.gymapp.dto.SubscriptionWorkouts;
import com.ubb.gymapp.model.Subscription;
import com.ubb.gymapp.model.Workout;
import com.ubb.gymapp.model.WorkoutList;
import com.ubb.gymapp.repository.SubscriptionRepository;
import com.ubb.gymapp.repository.WorkoutListRepository;
import com.ubb.gymapp.service.SubscriptionService;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
	
	@Autowired
	public SubscriptionRepository subscriptionRepo;
	
	@Autowired
	public WorkoutListRepository workoutListRepo;


	@Override
	public void addSubscription(SubscriptionWorkouts subscriptionWorkouts) {
		Subscription subscription = subscriptionWorkouts.getSubscription();
		subscription = subscriptionRepo.save(subscription);
		workoutListRepo.deleteBySubscription(subscription);
		for(Workout workout: subscriptionWorkouts.getWorkouts()){
			WorkoutList workoutList = new WorkoutList(subscription, workout);
			workoutListRepo.save(workoutList);
		}
	}

	@Override
	public List<Subscription> findAllSubscriptions() {
		return subscriptionRepo.findAll();
	}

	/*!
	 * 
	 */
	public List<SubscriptionWorkouts> findSubcriptionsAndWorkouts() {
		List<Subscription> subscriptions = this.findAllSubscriptions();
		List<SubscriptionWorkouts> subscriptionWorkoutsList = new ArrayList<SubscriptionWorkouts>();
		for(Subscription sub: subscriptions) {
			List<Workout> workouts = workoutListRepo.findWorkoutsBySubscription(sub);
			SubscriptionWorkouts sw = new SubscriptionWorkouts(sub, workouts);
			subscriptionWorkoutsList.add(sw);
		}
		return subscriptionWorkoutsList;
	}	
	

	@Override
	public void deleteSubscription(Subscription subscription) {
		workoutListRepo.deleteBySubscription(subscription);
		subscriptionRepo.delete(subscription);
	}



}
