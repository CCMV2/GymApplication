package com.ubb.gymapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ubb.gymapp.model.Administrator;
import com.ubb.gymapp.model.Client;
import com.ubb.gymapp.model.Rating;
import com.ubb.gymapp.model.Room;
import com.ubb.gymapp.model.Timetable;
import com.ubb.gymapp.model.Trainer;
import com.ubb.gymapp.model.User;
import com.ubb.gymapp.model.Workout;
import com.ubb.gymapp.model.User.UserType;
import com.ubb.gymapp.repository.RoomRepository;
import com.ubb.gymapp.repository.TimetableRepository;
import com.ubb.gymapp.repository.UserRepository;
import com.ubb.gymapp.repository.WorkoutRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
	
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private TimetableRepository timeRepo ;
	
	@Autowired
	private RoomRepository roomRepo;
	
	@Autowired
	private WorkoutRepository workRepo;
	@Test
	public void testTimetable() {
		Client user = new Client("aaa", "aaa", "aaa", "aaa", "aaa");
		user = userRepo.save(user);
		User user1 = userRepo.findOne(user.getId());
		assertNotNull(user1.getId());
		
		
		Date dat=new Date();
		Workout work = new Workout();
		work.setWorkoutType("r");
		Room room = new Room();
		workRepo.save(work);
		roomRepo.save(room);
		assertNotNull(work);
		assertNotNull(room);
		Trainer trainer = new Trainer("aaa", "aaa", "aaa", "aaa", "aaa", null);
	
		userRepo.save(trainer);
	
		Timetable pro =new Timetable("Joi", dat, 2L, room, work);
		pro.setTrainer(trainer);
		timeRepo.save(pro);
		
		
		
		user.addTimeTable(pro);
		user=userRepo.save(user);
		
		assertNotNull(user.getUserTimetable());
		
		assertNotNull(pro.getId());
		
		
		
		userRepo.delete(user.getId());	
		
		
		timeRepo.delete(pro);
		roomRepo.delete(room);

		workRepo.delete(work);
	}
	@Test
	public void authenticateUser(){
		
		Administrator user = new Administrator("aaa", "aaa", "aaa", "superAdmin2", "aaa");
		user = userRepo.save(user);
		User user1 = userRepo.findByEmail("superAdmin2");
		assertEquals(user.getId(), user1.getId());
		userRepo.delete(user);
	}
	
	@Test
	public void addUser() {
		Administrator user = new Administrator("aaa", "aaa", "aaa", "aaa", "aaa");
		user = userRepo.save(user);
		User user1 = userRepo.findOne(user.getId());
		assertNotNull(user1.getId());
		userRepo.delete(user.getId());
		//assertNotNull(lista);
		//assertNotEquals(lista.size(), 0);
	}
	
	@Test
	public void deleteUser(){
		Administrator newUser = new Administrator("aaa", "aaa", "aaa", "aaa", "aaa");
		newUser = userRepo.save(newUser);
		userRepo.delete(newUser.getId());
		assertNull(userRepo.findOne(newUser.getId()));
	}
	
	@Test
	public void testFindUserById(){
		Administrator newUser = new Administrator("aaa", "aaa", "aaa", "aaa", "aaa");
		User dbUser = userRepo.save(newUser);
		User user = userRepo.findOne(dbUser.getId());
		assertNotNull(user);
		userRepo.delete(dbUser.getId());
	}
	
	@Test
	public void testGetAllUsers(){
		Administrator newUser = new Administrator("aaa", "aaa", "aaa", "aaa", "aaa");
		newUser = userRepo.save(newUser);
		List<User> listOfUsers = userRepo.findAll();
		assertNotNull(listOfUsers);
		userRepo.delete(newUser.getId());
	}
	
	@Test
	public void testUpdateUsers(){
		Administrator user = new Administrator("aaa", "aaa", "aaa", "aaa", "aaa");
		user = userRepo.save(user);
		user.setName("test");
		userRepo.save(user);
		User dbUser = userRepo.findOne(user.getId());
		assertEquals(dbUser.getName(),"test");
		userRepo.delete(user.getId());
	}
	
	@Test
	public void testFindAllByUserType() {
		Trainer trainer = new Trainer("password", "Don","Huan","huan@mail.com", "0721878974", null);
		trainer.setRat(new Rating(2.3, 4L));
		Client user1 = new Client("1234567", "Don","Huan","huan@mail.com", "0721878974");
		Client user2 = new Client("2345678", "Don","Huan","huan@mail.com", "0721878974");
		
		userRepo.save(trainer);
		userRepo.save(user1);
		userRepo.save(user2);
		List<User> trainerList = userRepo.findAllByUserType(UserType.TRAINER);
		assertNotNull(trainerList);
		userRepo.delete(trainer.getId());
		userRepo.delete(user1.getId());
		userRepo.delete(user2.getId());
	}
	
	@Test
	public void testUpdateUserRating() {
		Trainer trainer = new Trainer("password", "Don","Huan","huan@mail.com", "0721878974", null);
		trainer.setRat(new Rating(5.0,(long) 2));
		userRepo.save(trainer);
		Long id = trainer.getRat().getIdRating();
		assertNotNull(id);
	}
	
}