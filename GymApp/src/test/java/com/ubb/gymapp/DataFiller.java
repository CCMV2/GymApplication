package com.ubb.gymapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ubb.gymapp.model.Room;
import com.ubb.gymapp.model.Subscription;
import com.ubb.gymapp.model.User;
import com.ubb.gymapp.model.User.UserType;
import com.ubb.gymapp.model.UserWorkout;
import com.ubb.gymapp.model.Workout;
import com.ubb.gymapp.model.Workout.Difficulty;
import com.ubb.gymapp.model.WorkoutList;
import com.ubb.gymapp.repository.RoomRepository;
import com.ubb.gymapp.repository.SubscriptionRepository;
import com.ubb.gymapp.repository.UserRepository;
import com.ubb.gymapp.repository.UserWorkoutRepository;
import com.ubb.gymapp.repository.WorkoutListRepository;
import com.ubb.gymapp.repository.WorkoutRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataFiller {
	
	@Autowired
	private SubscriptionRepository subRepo;
	
	@Autowired
	private WorkoutRepository workoutRepo;
	
	@Autowired
	private WorkoutListRepository workoutListRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserWorkoutRepository userWorkoutRepo;
	
	@Autowired
	private RoomRepository roomRepo;
	
	@Test
	public void fillData() {
		Subscription sub1 = new Subscription("Standard", 100.0);
		Subscription sub2 = new Subscription("Full", 150.0);
		Subscription sub3 = new Subscription("Silver", 200.0);
		Subscription sub4 = new Subscription("Premium", 400.0);
		subRepo.save(sub1);
		subRepo.save(sub2);
		subRepo.save(sub3);
		subRepo.save(sub4);
		
		Workout work1 = new Workout("Zumba", Difficulty.MEDIUM, "Pretty much the most awesome workout ever. Dance to great music, with great people, and burn a ton of calories without even realizing it.");
		Workout work2 = new Workout("Pilates", Difficulty.HARD, "Pilates is a physical fitness system developed in the early 20th century by Joseph Pilates, after whom it was named. It is practiced worldwide.");
		Workout work3 = new Workout("Tae-Bo", Difficulty.HARD, "Tae Bo is a total body fitness system that incorporates martial arts techniques such as kicks and punches, which became quite popular in the 1990s.");
		Workout work4 = new Workout("Kangoo Jumps", Difficulty.EASY, "Kangoo Jumps rebound shoes are perfect for cross-training activities and provide many additional health and fitness benefits. They are designed for all ages.");
		Workout work5 = new Workout("Step Basic", Difficulty.EASY, "Basic aerobic workout which will make you feel free and have fun in the same time.");
		Workout work6 = new Workout("Step Advanced", Difficulty.MEDIUM, "Step it up with the next level aerobic workout which will make you feel free and have fun in the same time.");
		workoutRepo.save(work1);
		workoutRepo.save(work2);
		workoutRepo.save(work3);
		workoutRepo.save(work4);
		workoutRepo.save(work5);
		workoutRepo.save(work6);
		
		WorkoutList wl1 = new WorkoutList(sub1, work1);
		WorkoutList wl2 = new WorkoutList(sub1, work2);
		WorkoutList wl3 = new WorkoutList(sub1, work5);
		WorkoutList wl4 = new WorkoutList(sub2, work1);
		WorkoutList wl5 = new WorkoutList(sub2, work2);
		WorkoutList wl6 = new WorkoutList(sub2, work3);
		WorkoutList wl7 = new WorkoutList(sub2, work5);
		WorkoutList wl8 = new WorkoutList(sub3, work1);
		WorkoutList wl9 = new WorkoutList(sub3, work2);
		WorkoutList wl10 = new WorkoutList(sub3, work3);
		WorkoutList wl11 = new WorkoutList(sub3, work4);
		WorkoutList wl12 = new WorkoutList(sub3, work5);
		WorkoutList wl13 = new WorkoutList(sub4, work1);
		WorkoutList wl14 = new WorkoutList(sub4, work2);
		WorkoutList wl15 = new WorkoutList(sub4, work3);
		WorkoutList wl16 = new WorkoutList(sub4, work4);
		WorkoutList wl17 = new WorkoutList(sub4, work5);
		WorkoutList wl18 = new WorkoutList(sub4, work6);
		workoutListRepo.save(wl1);
		workoutListRepo.save(wl2);
		workoutListRepo.save(wl3);
		workoutListRepo.save(wl4);
		workoutListRepo.save(wl5);
		workoutListRepo.save(wl6);
		workoutListRepo.save(wl7);
		workoutListRepo.save(wl8);
		workoutListRepo.save(wl9);
		workoutListRepo.save(wl10);
		workoutListRepo.save(wl11);
		workoutListRepo.save(wl12);
		workoutListRepo.save(wl13);
		workoutListRepo.save(wl14);
		workoutListRepo.save(wl15);
		workoutListRepo.save(wl16);
		workoutListRepo.save(wl17);
		workoutListRepo.save(wl18);
		
		User trainer1 = new User("trainer1", "John", "Doe", "john.doe@gmail.com", "0758914523", UserType.TRAINER);
		User trainer2 = new User("trainer2", "Jane", "Doe", "jane.doe@gmail.com", "0758914524", UserType.TRAINER);
		User trainer3 = new User("trainer3", "Jillian", "Miles", "jillian.miles@gmail.com", "0758914525", UserType.TRAINER);
		userRepo.save(trainer1);
		userRepo.save(trainer2);
		userRepo.save(trainer3);
		
		UserWorkout uw1 = new UserWorkout(trainer1, work3);
		UserWorkout uw2 = new UserWorkout(trainer1, work5);
		UserWorkout uw3 = new UserWorkout(trainer1, work6);
		UserWorkout uw4 = new UserWorkout(trainer2, work4);
		UserWorkout uw5 = new UserWorkout(trainer3, work1);
		UserWorkout uw6 = new UserWorkout(trainer3, work2);
		userWorkoutRepo.save(uw1);
		userWorkoutRepo.save(uw2);
		userWorkoutRepo.save(uw3);
		userWorkoutRepo.save(uw4);
		userWorkoutRepo.save(uw5);
		userWorkoutRepo.save(uw6);
		
		Room room1 = new Room("Main room");
		Room room2 = new Room("Aerobic");
		Room room3 = new Room("Martial arts");
		roomRepo.save(room1);
		roomRepo.save(room2);
		roomRepo.save(room3);
	}

}
