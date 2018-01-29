package com.ubb.gymapp.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ubb.gymapp.model.Room;
import com.ubb.gymapp.model.Timetable;
import com.ubb.gymapp.model.Trainer;
import com.ubb.gymapp.model.Workout;

public interface TimetableRepository extends JpaRepository<Timetable, Long>{
	
    List<Timetable> findByDay(String day);
	
    List<Timetable> findByRoom(Room room);
	
    List<Timetable> findByWorkout(Workout workout);
    
	 @Transactional
	 @Modifying
	 @Query("delete from Timetable t where t.workout = ?1")
	 public void deleteByWorkout(Workout workout);
	 
	 @Transactional
	 @Modifying
	 @Query("delete from Timetable t where t.trainer = ?1")
	 public void deleteByTrainer(Trainer trainer);
	 
	 @Transactional
	 @Modifying
	 @Query("delete from Timetable t where t.room = ?1")
	 public void deleteByRoom(Room room);
}