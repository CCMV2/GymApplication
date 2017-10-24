package com.ubb.gymapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.ubb.gymapp.model.Workout;

public interface WorkoutRepository extends CrudRepository<Workout,Long>{

}
