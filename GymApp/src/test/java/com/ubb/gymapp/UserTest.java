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
public class UserTest {
	
	@Autowired
	private UserRepository userRepo;
	
	@Test
	public void addUser() {
		User user = new User(0L, "aaa", "aaa", "aaa", "aaa", "aaa", "aaa", null);
		user = userRepo.save(user);
		User user1 = userRepo.findOne(user.getId());
		assertNotNull(user1.getId());
		userRepo.delete(user.getId());
		//assertNotNull(lista);
		//assertNotEquals(lista.size(), 0);
	}
	
	@Test
	public void deleteUser(){
		User newUser = new User(0L, "aaa", "aaa", "aaa", "aaa", "aaa", "aaa", null);
		newUser = userRepo.save(newUser);
		userRepo.delete(newUser.getId());
		assertNull(userRepo.findOne(newUser.getId()));
	}
	
	@Test
	public void testFindUserById(){
		User newUser = new User(0L, "aaa", "aaa", "aaa", "aaa", "aaa", "aaa", null);
		User dbUser = userRepo.save(newUser);
		User user = userRepo.findOne(dbUser.getId());
		assertNotNull(user);
		userRepo.delete(dbUser.getId());
	}
	
	@Test
	public void testGetAllUsers(){
		User newUser = new User(0L, "aaa", "aaa", "aaa", "aaa", "aaa", "aaa", null);
		newUser = userRepo.save(newUser);
		List<User> listOfUsers = userRepo.findAll();
		assertNotNull(listOfUsers);
		userRepo.delete(newUser.getId());
	}
	
	@Test
	public void testUpdateUsers(){
		User user = new User(0L, "aaa", "aaa", "aaa", "aaa", "aaa", "aaa", null);
		user = userRepo.save(user);
		user.setName("test");
		userRepo.save(user);
		User dbUser = userRepo.findOne(user.getId());
		assertEquals(dbUser.getName(),"test");
		userRepo.delete(user.getId());
	}
	

}