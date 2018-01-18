package com.ubb.gymapp.service;

import java.util.List;

import com.ubb.gymapp.model.Client;
import com.ubb.gymapp.model.ClientTimetable;
import com.ubb.gymapp.model.User;

public interface UserService {

	List<User> getAllUsers();
	List<User> getAllTrainers();
	User addUser(User user);
	void deleteUser(User user);
	User findUserByEmail(String email);
	User findUserById(Long id);
	String addUserTimetable(ClientTimetable clientTimetable);
	String deleteUserTimetable(ClientTimetable userTimetable);
	List<ClientTimetable> findByClient(Client client);
}
