package com.ubb.gymapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ubb.gymapp.model.Timetable;

public interface TimetableRepository extends JpaRepository<Timetable, Long>{
	
	List<Timetable> findByDay(String day);
	List<Timetable> findByidTimetable(int id);
	List<Timetable> findByidWorkout(int id);
	List<Timetable> findByroom_idroom(int id);
	
	void deleteInTimetable(List<Timetable> entities);
	
}