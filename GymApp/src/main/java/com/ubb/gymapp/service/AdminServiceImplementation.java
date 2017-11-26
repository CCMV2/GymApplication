package com.ubb.gymapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ubb.gymapp.model.Room;
import com.ubb.gymapp.model.Subscription;
import com.ubb.gymapp.model.Timetable;
import com.ubb.gymapp.model.User;
import com.ubb.gymapp.model.UserWorkout;
import com.ubb.gymapp.model.Workout;
import com.ubb.gymapp.model.User.UserType;
import com.ubb.gymapp.repository.RoomRepository;
import com.ubb.gymapp.repository.SubscriptionRepository;
import com.ubb.gymapp.repository.TimetableRepository;
import com.ubb.gymapp.repository.UserRepository;
import com.ubb.gymapp.repository.UserWorkoutRepository;
import com.ubb.gymapp.repository.WorkoutRepository;

@Service
public class AdminServiceImplementation implements IAdminService {

	@Autowired
	public WorkoutRepository workoutRepo;

	@Autowired
	public UserRepository userRepo;

	@Autowired
	public UserWorkoutRepository userWorkoutRepo;

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
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(hashedPassword);
		return userRepo.save(user);
	}

	@Override
	public Workout getWorkoutById(Long id) {
		return workoutRepo.findOne(id);
	}

	@Override
	public List<UserWorkout> getTrainerWorkouts() {
		return userWorkoutRepo.findAll();
	}

	@Override
	public void addTrainerWorkout(UserWorkout userWorkout) {
		workoutRepo.save(userWorkout.getWorkout());
		userWorkoutRepo.save(userWorkout);
	}
	
	@Override
	public void updateTrainerWorkout(UserWorkout userWorkout){
		Workout tempWorkout = workoutRepo.findOne(userWorkout.getWorkout().getIdWorkout());
		tempWorkout.setWorkoutType(userWorkout.getWorkout().getWorkoutType());
		tempWorkout.setDescription(userWorkout.getWorkout().getDescription());
		tempWorkout.setDifficulty(userWorkout.getWorkout().getDifficulty());
		workoutRepo.save(tempWorkout);
		UserWorkout tempUserWorkout = userWorkoutRepo.findOne(userWorkout.getId());
		tempUserWorkout.setWorkout(tempWorkout);
		tempUserWorkout.setTrainer(userWorkout.getTrainer());
		userWorkoutRepo.save(tempUserWorkout);
	}

	@Override
	public void deleteWorkout(Workout workout) {
		workoutRepo.delete(workout);

	}

	@Override
	public List<User> getAllTrainers() {
		return userRepo.findAllByUserType(UserType.TRAINER);
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

	@Override
	public Subscription addSubscription(Subscription subscription) {
		return subscriptionRepo.save(subscription);
		
	}

	@Override
	public List<Subscription> findAllSubscriptions() {
		return subscriptionRepo.findAll();
	}

	@Override
	public void deleteSubscription(Subscription subscription) {
		subscriptionRepo.delete(subscription);
	}

	@Override
	public void addTimeTable(Timetable timetable) {
		timetableRepo.save(timetable);
		
	}

	@Override
	public void updateTimeTable(Timetable timetable) {
		timetableRepo.save(timetable);
		
	}

	@Override
	public void deleteTimeTable(Timetable timetable) {
		timetableRepo.delete(timetable);
		
	}

	@Override
	public List<Timetable> getAllTimetables() {
		// TODO Auto-generated method stub
		return timetableRepo.findAll();
	}


}



