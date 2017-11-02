package com.ubb.gymapp.service;

import java.util.List;

import com.ubb.gymapp.model.Room;
import com.ubb.gymapp.model.User;
import com.ubb.gymapp.model.Workout;

public interface IAdminService {

	public Room getRoom(Long id);
	
	public List<User> getAllUsers();
	
	public User addUser(User user);
	
	public Workout getWorkoutById(long id);
}
