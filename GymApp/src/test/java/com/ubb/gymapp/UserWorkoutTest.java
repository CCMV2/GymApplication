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

import com.ubb.gymapp.model.User;
import com.ubb.gymapp.model.UserWorkout;
import com.ubb.gymapp.model.Workout;
import com.ubb.gymapp.repository.UserRepository;
import com.ubb.gymapp.repository.UserWorkoutRepository;
import com.ubb.gymapp.repository.WorkoutRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserWorkoutTest {
	@Autowired
	private UserWorkoutRepository userWorkoutRepo;
	@Autowired
	private WorkoutRepository workoutRepo;
	@Autowired
	private UserRepository userRepo;
	
	@Test
	public void testAdd() {
		Workout workout = new Workout(0L,"Test","Test","Test");
		User user = new User(0L, "aaa", "aaa", "aaa", "aaa", "aaa", "aaa", null);
		workout = workoutRepo.save(workout);
		user = userRepo.save(user);
		UserWorkout worklist = new UserWorkout(user,workout);
		worklist = userWorkoutRepo.save(worklist);
		assertNotNull(userWorkoutRepo.findOne(worklist.getId()));
		userWorkoutRepo.delete(worklist);
		workoutRepo.delete(workout);
		userRepo.delete(user);
	}
	
	@Transactional
	@Test
	public void testFindOne(){
		Workout workout = new Workout(0L,"Test","Test","Test");
		User user = new User(0L, "aaa", "aaa", "aaa", "aaa", "aaa", "aaa", null);
		workout = workoutRepo.save(workout);
		user = userRepo.save(user);
		UserWorkout worklist = new UserWorkout(user,workout);
		worklist = userWorkoutRepo.save(worklist);
		assertEquals(userWorkoutRepo.findOne(worklist.getId()),worklist);
		userWorkoutRepo.delete(worklist);
		workoutRepo.delete(workout);
		userRepo.delete(user);
	}
	
	@Test
	public void testDelete(){
		Workout workout = new Workout(0L,"Test","Test","Test");
		User user = new User(0L, "aaa", "aaa", "aaa", "aaa", "aaa", "aaa", null);
		workout = workoutRepo.save(workout);
		user = userRepo.save(user);
		UserWorkout worklist = new UserWorkout(user,workout);
		worklist = userWorkoutRepo.save(worklist);
		userWorkoutRepo.delete(worklist);
		assertNull(userWorkoutRepo.findOne(worklist.getId()));
		workoutRepo.delete(workout);
		userRepo.delete(user);
	}

	
	@Transactional
	@Test
	public void testFindAll(){
		Workout workout = new Workout(0L,"Test","Test","Test");
		User user = new User(0L, "aaa", "aaa", "aaa", "aaa", "aaa", "aaa", null);
		User user2 = new User(0L, "aaa", "aaa", "aaa", "aaa", "aaa", "aaa", null);
		User user3 = new User(0L, "aaa", "aaa", "aaa", "aaa", "aaa", "aaa", null);
		workout = workoutRepo.save(workout);
		user = userRepo.save(user);
		user2 = userRepo.save(user2);
		user3 = userRepo.save(user3);
		UserWorkout worklist = new UserWorkout(user,workout);
		UserWorkout worklist2 = new UserWorkout(user2,workout);
		UserWorkout worklist3 = new UserWorkout(user3,workout);
		worklist = userWorkoutRepo.save(worklist);
		worklist2 = userWorkoutRepo.save(worklist2);
		worklist3 = userWorkoutRepo.save(worklist3);
		List<UserWorkout> finalList = userWorkoutRepo.findAll();
		assertThat(finalList,hasItems(worklist,worklist2,worklist3));
		userWorkoutRepo.delete(worklist);
		userWorkoutRepo.delete(worklist2);
		userWorkoutRepo.delete(worklist3);
		workoutRepo.delete(workout);
		userRepo.delete(user);
		userRepo.delete(user2);
		userRepo.delete(user3);
	}

	
	@Transactional
	@Test
	public void testUpdate(){
		Workout workout = new Workout(0L,"Test","Test","Test");
		User user = new User(0L, "aaa", "aaa", "aaa", "aaa", "aaa", "aaa", null);
		User user2 = new User(0L, "aaa", "aaa", "aaa", "aaa", "aaa", "aaa", null);
		workout = workoutRepo.save(workout);
		user = userRepo.save(user);
		UserWorkout worklist = new UserWorkout(user,workout);
		worklist = userWorkoutRepo.save(worklist);
		worklist.setTrainer(user2);
		worklist = userWorkoutRepo.save(worklist);
		UserWorkout worklist2 = userWorkoutRepo.findOne(worklist.getId());
		assertEquals(worklist,worklist2);
		userWorkoutRepo.delete(worklist);
		workoutRepo.delete(workout);
		userRepo.delete(user);
		userRepo.delete(user2);
	}
}
