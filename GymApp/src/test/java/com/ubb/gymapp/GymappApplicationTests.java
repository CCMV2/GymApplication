package com.ubb.gymapp;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ubb.gymapp.model.User;
import com.ubb.gymapp.repository.UserRepository;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GymappApplicationTests {
	
	@Autowired
	private UserRepository userRepo;
	
	@Test
	public void addUser() {
		User user = new User(1L, "aaa", "aaa", "aaa", "aaa", "aaa", "aaa", null);
		userRepo.save(user);
		assertNotNull(user.getId());
		//assertNotNull(lista);
		//assertNotEquals(lista.size(), 0);
	}
	
	

}
