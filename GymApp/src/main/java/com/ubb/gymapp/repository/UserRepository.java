package com.ubb.gymapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ubb.gymapp.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
