package com.ubb.gymapp.service;

import java.util.List;

import com.ubb.gymapp.dto.ClientTimetable;
import com.ubb.gymapp.model.User;

public interface UserService {

	List<User> getAllUsers();
	List<User> getAllTrainers();
	User addUser(User user);
	void deleteUser(User user);
	User findUserByEmail(String email);
	String addUserTimetable(ClientTimetable clientTimetable);
}
