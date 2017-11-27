package com.ubb.gymapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ubb.gymapp.model.UserWorkout;
import com.ubb.gymapp.model.Workout;

public interface UserWorkoutRepository extends JpaRepository<UserWorkout,Long>{

	 @Transactional
	 @Modifying
	 @Query("delete from UserWorkout u where u.workout = ?1")
	 public void deleteByWorkout(Workout workout);
}
