package com.ubb.gymapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ubb.gymapp.dto.WorkoutTrainers;
import com.ubb.gymapp.model.Trainer;
import com.ubb.gymapp.model.TrainerWorkout;
import com.ubb.gymapp.model.User;
import com.ubb.gymapp.model.Workout;
import com.ubb.gymapp.repository.TimetableRepository;
import com.ubb.gymapp.repository.TrainerWorkoutRepository;
import com.ubb.gymapp.repository.WorkoutListRepository;
import com.ubb.gymapp.repository.WorkoutRepository;
import com.ubb.gymapp.service.WorkoutService;

@Service
public class WorkoutServiceImpl implements WorkoutService {

	@Autowired
	public WorkoutRepository workoutRepo;

	@Autowired
	public TrainerWorkoutRepository userWorkoutRepo;

	@Autowired
	public WorkoutListRepository workoutListRepo;
	
	@Autowired
	public TimetableRepository timetableRepo;
	
	@Override
	public List<WorkoutTrainers> getTrainerWorkouts() {
		List<Workout> workoutList = workoutRepo.findAll();
		List<WorkoutTrainers> workoutTrainersList = new ArrayList<>();
		for(Workout workout : workoutList) {
			List<Trainer> userList = userWorkoutRepo.findTrainersByWorkout(workout);
			WorkoutTrainers workoutTrainers = new WorkoutTrainers(workout, userList);
			workoutTrainersList.add(workoutTrainers);
		}
		return workoutTrainersList;
	}

	@Override
	public void deleteWorkout(Workout workout) {
		userWorkoutRepo.deleteByWorkout(workout);
		timetableRepo.deleteByWorkout(workout);
		workoutListRepo.deleteByWorkout(workout);
		workoutRepo.delete(workout);

	}
	
	@Override
	public List<Workout> getAllWorkouts() {
		return workoutRepo.findAll();
	}
	
	@Override
	public void addWorkoutTrainers(WorkoutTrainers workoutTrainers) {
		Workout workout = workoutTrainers.getWorkout();
		workout = workoutRepo.save(workout);
		userWorkoutRepo.deleteByWorkout(workout);
		for(User user: workoutTrainers.getTrainers()) {
			TrainerWorkout userWorkout = new TrainerWorkout((Trainer) user, workout);
			userWorkoutRepo.save(userWorkout);
		}
	}


}
