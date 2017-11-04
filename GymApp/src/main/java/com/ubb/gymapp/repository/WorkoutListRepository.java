package com.ubb.gymapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ubb.gymapp.model.Subscription;
import com.ubb.gymapp.model.Workout;
import com.ubb.gymapp.model.WorkoutList;

public interface WorkoutListRepository extends JpaRepository<WorkoutList,Long>{
	public void deleteBySubscription(Subscription subscription);
	
	public List<WorkoutList> findBySubscription(Subscription subscription);
	
	public List<WorkoutList> findByWorkout(Workout workout);
}
