package com.ubb.gymapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ubb.gymapp.model.User;
import com.ubb.gymapp.model.User.UserType;

public interface UserRepository extends JpaRepository<User, Long>{
	
	public List<User> findAllByUserType(UserType userType);
	
	//public List<User> findAllByWorkout(Workout workout);
	
	public User findByEmail(String email);
}
