package com.ubb.gymapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ubb.gymapp.model.Subscription;
import com.ubb.gymapp.model.User;
import com.ubb.gymapp.model.User.UserType;

public interface UserRepository extends JpaRepository<User, Long>{
	
	public List<User> findAllByUserType(UserType userType);
	
	//public List<User> findAllByWorkout(Workout workout);
	
	public User findByEmail(String email);
	
	@Transactional
	@Modifying
	@Query("update Client c set c.subscription = null, start = null where c.subscription= ?1)")
	public void deleteSubscriptionReference(Subscription subscription);
	
}
