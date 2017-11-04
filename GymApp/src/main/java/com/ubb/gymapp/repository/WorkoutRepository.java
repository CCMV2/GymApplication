package com.ubb.gymapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ubb.gymapp.model.Workout;

public interface WorkoutRepository extends JpaRepository<Workout,Long>{

}
