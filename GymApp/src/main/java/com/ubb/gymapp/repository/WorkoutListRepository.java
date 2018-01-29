package com.ubb.gymapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ubb.gymapp.model.Subscription;
import com.ubb.gymapp.model.Workout;
import com.ubb.gymapp.model.WorkoutList;

public interface WorkoutListRepository extends JpaRepository<WorkoutList,Long>{
	
	public List<WorkoutList> findBySubscription(Subscription subscription);
	
	@Query("select w.workout from WorkoutList w where w.subscription = ?1")
	public List<Workout> findWorkoutsBySubscription(Subscription subscription);
	
	public List<WorkoutList> findByWorkout(Workout workout);
	
	 @Transactional
	 @Modifying
	 @Query("delete from WorkoutList w where w.workout = ?1")
	 public void deleteByWorkout(Workout workout);
	 
	 @Transactional
	 @Modifying
	 @Query("delete from WorkoutList w where w.subscription = ?1")
	 public void deleteBySubscription(Subscription subscripition);
	 
	
		 
	 
}
