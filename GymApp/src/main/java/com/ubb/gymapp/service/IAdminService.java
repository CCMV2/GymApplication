package com.ubb.gymapp.service;

import java.util.List;

import com.ubb.gymapp.dto.SubscriptionWorkouts;
import com.ubb.gymapp.model.Room;
import com.ubb.gymapp.model.Subscription;
import com.ubb.gymapp.model.Timetable;
import com.ubb.gymapp.model.User;
import com.ubb.gymapp.model.UserWorkout;
import com.ubb.gymapp.model.Workout;

public interface IAdminService {

	public Room getRoom(Long id);
	
	public List<User> getAllUsers();
	
	public List<User> getAllTrainers();
	
	public User addUser(User user);
	
	public Workout getWorkoutById(Long id);
	
	public List<UserWorkout> getTrainerWorkouts();
	
	public List<Workout> getAllWorkouts();
	
	public void addTrainerWorkout(UserWorkout userWorkout);
	
	public void addSubscription(SubscriptionWorkouts subscriptionWorkouts);
	
	public Subscription getSubscriptionById(Long id);
	
	public List<Subscription> findAllSubscriptions();
	
	public 	void deleteSubscription(Subscription subscription);
	
	
	
	public void deleteWorkout(Workout workout);
	
	public Timetable getTimetableById(Long id);
	
	public List<Timetable> getAllTimetables();
	
	public void addTimeTable(Timetable timetable);
	
	public void updateTimeTable(Timetable timetable);
	
	public void deleteTimeTable(Timetable timetable);
	
	
	public List<Room> getAllRooms();
	
	public void addRoom(Room room);
	
	public void deleteRoom(Room room);
}
