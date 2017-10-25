package com.ubb.gymapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ubb.gymapp.model.Timetable;

public interface TimetableRepository extends JpaRepository<Timetable, Long>{
	
	List<Timetable> findByDay(String day);

}
