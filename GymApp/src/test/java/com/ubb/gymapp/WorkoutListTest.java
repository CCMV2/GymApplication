package com.ubb.gymapp;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ubb.gymapp.model.Room;
import com.ubb.gymapp.model.Subscription;
import com.ubb.gymapp.model.Workout;
import com.ubb.gymapp.model.WorkoutList;
import com.ubb.gymapp.repository.RoomRepository;
import com.ubb.gymapp.repository.SubscriptionRepository;
import com.ubb.gymapp.repository.WorkoutListRepository;
import com.ubb.gymapp.repository.WorkoutRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WorkoutListTest {

	@Autowired
	private WorkoutListRepository workoutListRepo;
	@Autowired
	private WorkoutRepository workoutRepo;
	@Autowired
	private SubscriptionRepository subscriptionRepo;
	
	@Test
	public void testAdd() {
		Workout workout = new Workout(0L,"Test","Test","Test");
		Subscription sub = new Subscription("Test",50.0);
		workout = workoutRepo.save(workout);
		sub = subscriptionRepo.save(sub);
		WorkoutList worklist = new WorkoutList(sub,workout);
		worklist = workoutListRepo.save(worklist);
		assertNotNull(workoutListRepo.findOne(worklist.getId()));
		workoutListRepo.delete(worklist);
		workoutRepo.delete(workout);
		subscriptionRepo.delete(sub);
	}
	
	@Transactional
	@Test
	public void testFindOne(){
		Workout workout = new Workout(0L,"Test","Test","Test");
		Subscription sub = new Subscription("Test",50.0);
		workout = workoutRepo.save(workout);
		sub = subscriptionRepo.save(sub);
		WorkoutList worklist = new WorkoutList(sub,workout);
		worklist = workoutListRepo.save(worklist);
		assertEquals(workoutListRepo.findOne(worklist.getId()),worklist);
		workoutListRepo.delete(worklist);
		workoutRepo.delete(workout);
		subscriptionRepo.delete(sub);
	}
	
	@Test
	public void testDelete(){
		Workout workout = new Workout(0L,"Test","Test","Test");
		Subscription sub = new Subscription("Test",50.0);
		workout = workoutRepo.save(workout);
		sub = subscriptionRepo.save(sub);
		WorkoutList worklist = new WorkoutList(sub,workout);
		worklist = workoutListRepo.save(worklist);
		workoutListRepo.delete(worklist);
		assertNull(workoutListRepo.findOne(worklist.getId()));
		workoutRepo.delete(workout);
		subscriptionRepo.delete(sub);
	}

	
	@Transactional
	@Test
	public void testFindAll(){
		Workout workout = new Workout(0L,"Test","Test","Test");
		Subscription sub = new Subscription("Test",50.0);
		Subscription sub2 = new Subscription("Test2",50.0);
		Subscription sub3 = new Subscription("Test3",50.0);
		workout = workoutRepo.save(workout);
		sub = subscriptionRepo.save(sub);
		sub2 = subscriptionRepo.save(sub2);
		sub3 = subscriptionRepo.save(sub3);
		WorkoutList worklist = new WorkoutList(sub,workout);
		WorkoutList worklist2 = new WorkoutList(sub2,workout);
		WorkoutList worklist3 = new WorkoutList(sub3,workout);
		worklist = workoutListRepo.save(worklist);
		worklist2 = workoutListRepo.save(worklist2);
		worklist3 = workoutListRepo.save(worklist3);
		List<WorkoutList> finalList = workoutListRepo.findAll();
		assertThat(finalList,hasItems(worklist,worklist2,worklist3));
		workoutListRepo.delete(worklist);
		workoutListRepo.delete(worklist2);
		workoutListRepo.delete(worklist3);
		workoutRepo.delete(workout);
		subscriptionRepo.delete(sub);
		subscriptionRepo.delete(sub2);
		subscriptionRepo.delete(sub3);
	}

	
	@Transactional
	@Test
	public void testUpdate(){
		Workout workout = new Workout(0L,"Test","Test","Test");
		Subscription sub = new Subscription("Test",50.0);
		Subscription sub2 = new Subscription("Test2",50.0);
		workout = workoutRepo.save(workout);
		sub = subscriptionRepo.save(sub);
		WorkoutList worklist = new WorkoutList(sub,workout);
		worklist = workoutListRepo.save(worklist);
		worklist.setSubscription(sub2);
		worklist = workoutListRepo.save(worklist);
		WorkoutList worklist2 = workoutListRepo.findOne(worklist.getId());
		assertEquals(worklist,worklist2);
		workoutListRepo.delete(worklist);
		workoutRepo.delete(workout);
		subscriptionRepo.delete(sub);
		subscriptionRepo.delete(sub2);
	}
}
