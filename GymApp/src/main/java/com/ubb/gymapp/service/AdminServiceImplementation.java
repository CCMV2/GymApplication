package com.ubb.gymapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ubb.gymapp.model.Workout;
import com.ubb.gymapp.repository.WorkoutRepository;

@Service
public class AdminServiceImplementation implements IAdminService {
	
	@Autowired
	public WorkoutRepository workoutRepo;
	
	public Workout getWorkoutById(long id){
		return workoutRepo.findOne(id);
	}
}
