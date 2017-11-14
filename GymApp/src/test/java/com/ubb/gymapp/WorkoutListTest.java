package com.ubb.gymapp;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ubb.gymapp.model.Subscription;
import com.ubb.gymapp.model.Timetable;
import com.ubb.gymapp.model.Workout;
import com.ubb.gymapp.model.WorkoutList;
import com.ubb.gymapp.repository.SubscriptionRepository;
import com.ubb.gymapp.repository.TimetableRepository;
import com.ubb.gymapp.repository.WorkoutListRepository;
import com.ubb.gymapp.repository.WorkoutRepository;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WorkoutListTest {
	
	@Autowired
	private WorkoutListRepository wlRepo ;
	
	
	@Autowired
	private WorkoutRepository workoutRepo ;
	
	@Autowired
	private SubscriptionRepository subscriptionRepo ;
	
	
	 @Test
	    public void testAdd() {
	        Workout workout = new Workout("Swimming", "Hard", "You will get wet!");
	        workout = workoutRepo.save(workout);
	        Subscription subscription = new Subscription("abo1",500.0);
	        subscription = subscriptionRepo.save(subscription);
	        WorkoutList workoutList = new WorkoutList(subscription,workout);
	        workoutList = wlRepo.save(workoutList);
	        assertNotNull(workoutList);
	        assertEquals(workoutList.getSubscription(),subscription);
	        assertEquals(workoutList.getWorkout(),workout);
	        wlRepo.delete(workoutList);
	        workoutRepo.delete(workout);
	        subscriptionRepo.delete(subscription);
	        
	    }
	 
	 @Test
	 public void testFind(){
		 	Workout workout = new Workout("Swimming", "Hard", "You will get wet!");
	        workout = workoutRepo.save(workout);
	        Subscription subscription = new Subscription("abo1",500.0);
	        subscription = subscriptionRepo.save(subscription);
	        WorkoutList workoutList = new WorkoutList(subscription,workout);
	        workoutList = wlRepo.save(workoutList);
	        assertNotNull(workoutList.getSubscription().getSubscriptionId());
	        assertNotNull(workoutList.getWorkout().getIdWorkout());
	        wlRepo.delete(workoutList);
	        workoutRepo.delete(workout);
	        subscriptionRepo.delete(subscription);
	 }
	 
	@Test
	public void testDelete(){
		Workout workout = new Workout("Swimming", "Hard", "You will get wet!");
        workout = workoutRepo.save(workout);
        Subscription subscription = new Subscription("abo1",500.0);
        subscription = subscriptionRepo.save(subscription);
        WorkoutList workoutList = new WorkoutList(subscription,workout);
        workoutList = wlRepo.save(workoutList);
        
        Workout workout1 = new Workout("Swimming", "Easy", "You will get wet!");
        workout1 = workoutRepo.save(workout1);
        Subscription subscription1 = new Subscription("abo2",500.0);
        subscription1 = subscriptionRepo.save(subscription);
        WorkoutList workoutList1 = new WorkoutList(subscription1,workout1);
        workoutList1 = wlRepo.save(workoutList1);
        
        Workout workout2 = new Workout("Swimming", "Medium", "You will get wet!");
        workout2 = workoutRepo.save(workout2);
        Subscription subscription2 = new Subscription("abo3",500.0);
        subscription2 = subscriptionRepo.save(subscription2);
        WorkoutList workoutList2 = new WorkoutList(subscription2,workout2);
        workoutList2 = wlRepo.save(workoutList2);
        
        List<WorkoutList> subList = wlRepo.findBySubscription(subscription2);
        List<WorkoutList> wList = wlRepo.findByWorkout(workout2);
        Long sId = subList.get(0).getId();
        Long wId = wList.get(0).getId();
        
        
        wlRepo.delete(subList.get(0));
        
        wlRepo.delete(wList.get(0));
        
        
        assertFalse(wlRepo.exists(sId));
        assertFalse(wlRepo.exists(sId));
        
        wlRepo.delete(workoutList);
        wlRepo.delete(workoutList1);
        
        
        workoutRepo.delete(workout);
        workoutRepo.delete(workout1);
        
        subscriptionRepo.delete(subscription);
        subscriptionRepo.delete(subscription1);
        
        

	}
}
