package com.ubb.gymapp.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.ubb.gymapp.model.User;

public interface UserRepository extends CrudRepository<User, Serializable>{

}
