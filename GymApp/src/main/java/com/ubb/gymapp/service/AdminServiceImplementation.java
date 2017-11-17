 package com.ubb.gymapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ubb.gymapp.model.Room;
import com.ubb.gymapp.model.Subscription;
import com.ubb.gymapp.model.Timetable;
import com.ubb.gymapp.model.User;
import com.ubb.gymapp.model.Workout;
import com.ubb.gymapp.repository.RoomRepository;
import com.ubb.gymapp.repository.SubscriptionRepository;
import com.ubb.gymapp.repository.TimetableRepository;
import com.ubb.gymapp.repository.UserRepository;
import com.ubb.gymapp.repository.WorkoutRepository;

@Service
public class AdminServiceImplementation implements IAdminService {
	
	@Autowired
	public WorkoutRepository workoutRepo;
	
	@Autowired
	public UserRepository userRepo;
	
	@Autowired
	public RoomRepository roomRepo;
	
	@Autowired
	public SubscriptionRepository subscriptionRepo;
	
	@Autowired
	public TimetableRepository timetableRepo;

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public Room getRoom(Long id) {
		return roomRepo.findOne(id);
	}

	@Override
	public User addUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public Workout getWorkoutById(Long id) {
		return workoutRepo.findOne(id);
	}
	

	@Override
	public List<Workout> getAllWorkouts() {
		return workoutRepo.findAll();
	}

	@Override
	public void addWorkout(Workout workout) {
		workoutRepo.save(workout);
		
	}

	@Override
	public void deleteWorkout(Workout workout) {
		workoutRepo.delete(workout);
		
	}
	
	@Override
	public List<User> getAllTrainers() {
		return userRepo.findAllByUserPermission("TRAINER");
	}

	@Override
	public Timetable getTimetableById(Long id) {
		return timetableRepo.findOne(id);
	}

	@Override
	public Subscription getSubscriptionById(Long id) {
		return subscriptionRepo.findOne(id);
	}

	@Override
	public List<Room> getAllRooms() {
		return roomRepo.findAll();
	}

	@Override
	public void addRoom(Room room) {
		roomRepo.save(room);
		
	}

	@Override
	public void deleteRoom(Room room) {
		roomRepo.delete(room);
	}
	
}
