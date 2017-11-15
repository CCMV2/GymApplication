package com.ubb.gymapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ubb.gymapp.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	public List<User> findAllByUserPermission(String userPermission);
	
}
