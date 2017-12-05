package com.ubb.gymapp;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ubb.gymapp.model.Subscription;
import com.ubb.gymapp.model.Workout;
import com.ubb.gymapp.model.WorkoutList;
import com.ubb.gymapp.model.Workout.Difficulty;
import com.ubb.gymapp.repository.SubscriptionRepository;
import com.ubb.gymapp.repository.WorkoutListRepository;
import com.ubb.gymapp.repository.WorkoutRepository;

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
	        Workout workout = new Workout("Swimming", Difficulty.HARD, "You will get wet!");
	        workout = workoutRepo.save(workout);
	        Subscription subscription = new Subscription("abo1",500.0, null);
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
		 	Workout workout = new Workout("Swimming", Difficulty.HARD, "You will get wet!");
	        workout = workoutRepo.save(workout);
	        Subscription subscription = new Subscription("abo1",500.0, null);
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
		Workout workout = new Workout("Swimming", Difficulty.HARD, "You will get wet!");
        workout = workoutRepo.save(workout);
        Subscription subscription = new Subscription("abo1",500.0, null);
        subscription = subscriptionRepo.save(subscription);
        WorkoutList workoutList = new WorkoutList(subscription,workout);
        workoutList = wlRepo.save(workoutList);
        
        Workout workout1 = new Workout("Swimming", Difficulty.HARD, "You will get wet!");
        workout1 = workoutRepo.save(workout1);
        Subscription subscription1 = new Subscription("abo2",500.0, null);
        subscription1 = subscriptionRepo.save(subscription);
        WorkoutList workoutList1 = new WorkoutList(subscription1,workout1);
        workoutList1 = wlRepo.save(workoutList1);
        
        Workout workout2 = new Workout("Swimming", Difficulty.MEDIUM, "You will get wet!");
        workout2 = workoutRepo.save(workout2);
        Subscription subscription2 = new Subscription("abo3",500.0, null);
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
        assertFalse(wlRepo.exists(wId));
        
        wlRepo.delete(workoutList);
        wlRepo.delete(workoutList1);
        
        
        workoutRepo.delete(workout);
        workoutRepo.delete(workout1);
        
        subscriptionRepo.delete(subscription);
        subscriptionRepo.delete(subscription1);
	}
	
	@Test
	public void findWorkoutsBySubscription() {
		Subscription sub1 = new Subscription("Standard", 100.0, null);
		subscriptionRepo.save(sub1);
		Workout work1 = new Workout("Zumba", Difficulty.MEDIUM, "Pretty much the most awesome workout ever. Dance to great music, with great people, and burn a ton of calories without even realizing it.");
		Workout work2 = new Workout("Pilates", Difficulty.HARD, "Pilates is a physical fitness system developed in the early 20th century by Joseph Pilates, after whom it was named. It is practiced worldwide.");
		Workout work3 = new Workout("Tae-Bo", Difficulty.HARD, "Tae Bo is a total body fitness system that incorporates martial arts techniques such as kicks and punches, which became quite popular in the 1990s.");
		workoutRepo.save(work1);
		workoutRepo.save(work2);
		workoutRepo.save(work3);
		WorkoutList wl1 = new WorkoutList(sub1, work1);
		WorkoutList wl2 = new WorkoutList(sub1, work2);
		WorkoutList wl3 = new WorkoutList(sub1, work3);
		wlRepo.save(wl1);
		wlRepo.save(wl2);
		wlRepo.save(wl3);
		
		List<Workout> wls = wlRepo.findWorkoutsBySubscription(sub1);
		assertNotNull(wls);
		assertEquals(wls.size(), 3);
		wlRepo.delete(wl1);
		wlRepo.delete(wl2);
		wlRepo.delete(wl3);
		workoutRepo.delete(work1);
		workoutRepo.delete(work2);
		workoutRepo.delete(work3);
		subscriptionRepo.delete(sub1);
		
	}
	
	@Test
	public void deleteByWorkout() {
		Subscription sub1 = new Subscription("Standard", 100.0, null);
		subscriptionRepo.save(sub1);
		Workout work1 = new Workout("Zumba", Difficulty.MEDIUM, "Pretty much the most awesome workout ever. Dance to great music, with great people, and burn a ton of calories without even realizing it.");
		workoutRepo.save(work1);
		WorkoutList wl1 = new WorkoutList(sub1, work1);
		wlRepo.save(wl1);
		long id = wl1.getId();
		
		wlRepo.deleteByWorkout(work1);
		boolean isDeleted = !wlRepo.exists(id);
		assertTrue(isDeleted);
		wlRepo.delete(wl1);
		workoutRepo.delete(work1);
		subscriptionRepo.delete(sub1);
		
	}
}
