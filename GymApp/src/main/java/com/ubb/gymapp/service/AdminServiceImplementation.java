package com.ubb.gymapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ubb.gymapp.dto.SubscriptionWorkouts;
import com.ubb.gymapp.model.Room;
import com.ubb.gymapp.model.Subscription;
import com.ubb.gymapp.model.Timetable;
import com.ubb.gymapp.model.User;
import com.ubb.gymapp.model.UserWorkout;
import com.ubb.gymapp.model.Workout;
import com.ubb.gymapp.model.WorkoutList;
import com.ubb.gymapp.model.User.UserType;
import com.ubb.gymapp.repository.RoomRepository;
import com.ubb.gymapp.repository.SubscriptionRepository;
import com.ubb.gymapp.repository.TimetableRepository;
import com.ubb.gymapp.repository.UserRepository;
import com.ubb.gymapp.repository.UserWorkoutRepository;
import com.ubb.gymapp.repository.WorkoutListRepository;
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
	
	@Autowired
	public WorkoutListRepository workoutListRepo;

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
	public void addSubscription(SubscriptionWorkouts subscriptionWorkouts) {
		Subscription subscription = subscriptionWorkouts.getSubscription();
		subscriptionRepo.save(subscription);
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
		List<WorkoutList> workoutList = new ArrayList<WorkoutList>();
		List<Workout> workouts = new ArrayList<Workout>();
		List<SubscriptionWorkouts> subscriptionWorkoutsList = new ArrayList<SubscriptionWorkouts>();
	//	SubscriptionWorkouts subscriptionWorkout = new SubscriptionWorkouts();
		List<Subscription> s = new ArrayList<Subscription>();
		for(Subscription sub: subscriptions){
			workoutList = workoutListRepo.findBySubscription(sub);   //asta are cate 1 subscr. si 1 workout.
			s.add(sub);
			
			
		for (WorkoutList workList: workoutList){
			workouts.add(workList.getWorkout());
					
		}
			SubscriptionWorkouts subscriptionWorkout = new SubscriptionWorkouts(sub,workouts);	
			subscriptionWorkoutsList.add(subscriptionWorkout);		
		}
		
		return subscriptionWorkoutsList;
		}
	
	

	@Override
	public void deleteSubscription(Subscription subscription) {
		subscriptionRepo.delete(subscription);
	}
	
	@Override
	public void deleteUser(User user){
		userRepo.delete(user);
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

	@Override
	public List<Workout> getAllWorkouts() {
		return workoutRepo.findAll();
	}


}



