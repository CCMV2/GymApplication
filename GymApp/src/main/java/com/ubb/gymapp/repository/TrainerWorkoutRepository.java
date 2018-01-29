package com.ubb.gymapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ubb.gymapp.model.Trainer;
import com.ubb.gymapp.model.TrainerWorkout;
import com.ubb.gymapp.model.Workout;

public interface TrainerWorkoutRepository extends JpaRepository<TrainerWorkout, Long> {

	@Transactional
	@Modifying
	@Query("delete from TrainerWorkout u where u.workout = ?1")
	public void deleteByWorkout(Workout workout);

	@Transactional
	@Modifying
	@Query("delete from TrainerWorkout u where u.trainer = ?1")
	public void deleteByTrainer(Trainer trainer);
	
	public List<TrainerWorkout> findAllByWorkout(Workout workout);

	@Query("select w.trainer from TrainerWorkout w where w.workout = ?1")
	public List<Trainer> findTrainersByWorkout(Workout workout);

}
