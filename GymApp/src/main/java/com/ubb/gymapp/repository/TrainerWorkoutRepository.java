package com.ubb.gymapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ubb.gymapp.model.User;
import com.ubb.gymapp.model.UserWorkout;
import com.ubb.gymapp.model.Workout;

public interface UserWorkoutRepository extends JpaRepository<UserWorkout, Long> {

	@Transactional
	@Modifying
	@Query("delete from UserWorkout u where u.workout = ?1")
	public void deleteByWorkout(Workout workout);

	public List<UserWorkout> findAllByWorkout(Workout workout);

	@Query("select w.trainer from UserWorkout w where w.workout = ?1")
	public List<User> findUsersByWorkout(Workout workout);

}
