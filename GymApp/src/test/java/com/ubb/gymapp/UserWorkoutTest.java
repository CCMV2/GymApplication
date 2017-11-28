package com.ubb.gymapp;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ubb.gymapp.model.User;
import com.ubb.gymapp.model.User.UserType;
import com.ubb.gymapp.model.UserWorkout;
import com.ubb.gymapp.model.Workout;
import com.ubb.gymapp.model.Workout.Difficulty;
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
		Workout workout = new Workout("Test", Difficulty.EASY,"Test");
		User user = new User("aaa", "aaa", "aaa", "aaa", "aaa", UserType.ADMIN);
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
		Workout workout = new Workout("Test", Difficulty.EASY,"Test");
		User user = new User("aaa", "aaa", "aaa", "aaa", "aaa", UserType.ADMIN);
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
		Workout workout = new Workout("Test", Difficulty.EASY,"Test");
		User user = new User("aaa", "aaa", "aaa", "aaa", "aaa", UserType.ADMIN);
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
		Workout workout = new Workout("Test", Difficulty.EASY, "Test");
		User user = new User("aaa", "aaa", "aaa", "aaa", "aaa", UserType.ADMIN);
		User user2 = new User("aaa", "aaa", "aaa", "aaa", "aaa", UserType.ADMIN);
		User user3 = new User("aaa", "aaa", "aaa", "aaa", "aaa", UserType.ADMIN);
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
		Workout workout = new Workout("Test", Difficulty.EASY,"Test");
		User user = new User("aaa", "aaa", "aaa", "aaa", "aaa", UserType.ADMIN);
		User user2 = new User("aaa", "aaa", "aaa", "aaa", "aaa", UserType.ADMIN);
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
	
	@Test
	public void deleteByWorkout(){
		Workout work1 = new Workout("Zumba", Difficulty.MEDIUM, "Pretty much the most awesome workout ever. Dance to great music, with great people, and burn a ton of calories without even realizing it.");
		workoutRepo.save(work1);
		User trainer1 = new User("trainer1", "John", "Doe", "john.doe@gmail.com", "0758914523", UserType.TRAINER);
		userRepo.save(trainer1);
		UserWorkout uw1 = new UserWorkout(trainer1, work1);
		userWorkoutRepo.save(uw1);
		long uw1Id = uw1.getId();
		userWorkoutRepo.deleteByWorkout(work1);
		boolean isDeleted = !userWorkoutRepo.exists(uw1Id);
		assertTrue(isDeleted);
		workoutRepo.delete(work1);
		userRepo.delete(trainer1);

	}
	
	@Test
	public void findAllByWorkout() {
		Workout workout1 = new Workout("Zumba", Difficulty.EASY,"Test");
		Workout workout2 = new Workout("Zumba", Difficulty.HARD,"Test");
		Workout workout3 = new Workout("Swimming", Difficulty.MEDIUM,"Test");
		workoutRepo.save(workout1);
		workoutRepo.save(workout2);
		workoutRepo.save(workout3);
		User trainer1 = new User("trainer1", "John", "Doe", "john.doe@gmail.com", "0758914523", UserType.TRAINER);
		User trainer2 = new User("trainer2", "Jane", "Doe", "jane.doe@gmail.com", "0758914523", UserType.TRAINER);
		userRepo.save(trainer1);
		userRepo.save(trainer2);
		UserWorkout uw1 = new UserWorkout(trainer1, workout1);
		UserWorkout uw2 = new UserWorkout(trainer1, workout2);
		UserWorkout uw3 = new UserWorkout(trainer1, workout3);
		UserWorkout uw4 = new UserWorkout(trainer2, workout1);
		userWorkoutRepo.save(uw1);
		userWorkoutRepo.save(uw2);
		userWorkoutRepo.save(uw3);
		userWorkoutRepo.save(uw4);
		List<UserWorkout> uwList = userWorkoutRepo.findAllByWorkout(workout1);
		assertEquals(uwList.size(), 2);
		userWorkoutRepo.delete(uw1);
		userWorkoutRepo.delete(uw2);
		userWorkoutRepo.delete(uw3);
		userWorkoutRepo.delete(uw4);
		workoutRepo.delete(workout1);
		workoutRepo.delete(workout2);
		workoutRepo.delete(workout3);
		userRepo.delete(trainer1);
		userRepo.delete(trainer2);
	}
}
