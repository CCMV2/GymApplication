package com.ubb.gymapp;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ubb.gymapp.model.User;
import com.ubb.gymapp.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GymappApplicationTests {
	
	@Autowired
	private UserRepository userRepo;
	
	@Test
	public void addUser() {
		User user = new User(1L, "aaa", "aaa", "aaa", "aaa", 2L, "aaa", null);
		userRepo.save(user);
		assertNotNull(user.getId());
		//assertNotNull(lista);
		//assertNotEquals(lista.size(), 0);
	}
	
	@Test
	public void deleteUser(){
		User newUser = new User(1L, "aaa", "aaa", "aaa", "aaa", 2L, "aaa", null);
		userRepo.save(newUser);
		User user =userRepo.findOne(newUser.getId());
		userRepo.delete(user.getId());
		assertNull(user.getId());
	}
	
	@Test
	public void testFindUserById(){
		User user = userRepo.findOne((long) 1);
		assertNotNull(user);
	}
	
	@Test
	public void testGetAllUsers(){
		List<User> listOfUsers = userRepo.findAll();
		assertNotNull(listOfUsers);
	}
	
	@Test
	public void testUpdateUsers(){
		
	}
	
	
	
	
	

}
