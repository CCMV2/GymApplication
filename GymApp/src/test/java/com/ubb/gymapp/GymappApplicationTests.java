package com.ubb.gymapp;

import static org.junit.Assert.assertEquals;
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
		User user = new User(1L, "aaa", "aaa", "aaa", "aaa", "aaa", "aaa", null);
		userRepo.save(user);
		User user1 = userRepo.findOne((long) 1);
		assertNotNull(user1.getId());
		//assertNotNull(lista);
		//assertNotEquals(lista.size(), 0);
	}
	
	@Test
	public void deleteUser(){
		User newUser = new User(1L, "aaa", "aaa", "aaa", "aaa", "aaa", "aaa", null);
		userRepo.save(newUser);
		User user =userRepo.findOne(newUser.getId());
		userRepo.delete(user.getId());
		assertNull(user.getId());
	}
	
	@Test
	public void testFindUserById(){
		User newUser = new User(0L, "aaa", "aaa", "aaa", "aaa", "aaa", "aaa", null);
		User dbUser = userRepo.save(newUser);
		User user = userRepo.findOne(dbUser.getId());
		assertNotNull(user);
	}
	
	@Test
	public void testGetAllUsers(){
		User newUser = new User(1L, "aaa", "aaa", "aaa", "aaa", "aaa", "aaa", null);
		userRepo.save(newUser);
		List<User> listOfUsers = userRepo.findAll();
		assertNotNull(listOfUsers);
	}
	
	@Test
	public void testUpdateUsers(){
		User user = new User(0L, "aaa", "aaa", "aaa", "aaa", "aaa", "aaa", null);
		user = userRepo.save(user);
		user.setName("test");
		userRepo.save(user);
		User dbUser = userRepo.findOne(user.getId());
		assertEquals(dbUser.getName(),"test");
	}
	
	
	
	
	

}
