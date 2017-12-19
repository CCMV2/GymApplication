package com.ubb.gymapp.service.impl;

import static com.ubb.gymapp.model.User.UserType.TRAINER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ubb.gymapp.model.Administrator;
import com.ubb.gymapp.model.Client;
import com.ubb.gymapp.model.Trainer;
import com.ubb.gymapp.model.User;
import com.ubb.gymapp.repository.TrainerWorkoutRepository;
import com.ubb.gymapp.repository.UserRepository;
import com.ubb.gymapp.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private TrainerWorkoutRepository trainerWorkoutRepo;
	
	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User addUser(User user) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		switch (user.getUserType()) {
		case ADMIN:
			Administrator admin = (Administrator) user;
			admin.setPassword(passwordEncoder.encode(admin.getPassword()));
			return userRepo.save(admin);
		case TRAINER:
			Trainer trainer = (Trainer) user;
			trainer.setPassword(passwordEncoder.encode(trainer.getPassword()));
			return userRepo.save(trainer);
		default:
			Client client = (Client) user;
			return userRepo.save(client);
		}
	}
	
	@Override
	public List<User> getAllTrainers() {
		return userRepo.findAllByUserType(TRAINER);
	}
	
	@Override
	public void deleteUser(User user){
		if (user instanceof Trainer) {
			trainerWorkoutRepo.deleteByTrainer((Trainer) user);
		}
		userRepo.delete(user);
	}

	@Override
	public User findUserByEmail(String email) {
		return userRepo.findByEmail(email);
	}

}
