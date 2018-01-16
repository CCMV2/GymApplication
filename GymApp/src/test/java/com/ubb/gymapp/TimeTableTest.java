package com.ubb.gymapp;

import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.ubb.gymapp.model.Room;
import com.ubb.gymapp.model.Timetable;
import com.ubb.gymapp.model.Trainer;
import com.ubb.gymapp.model.User;
import com.ubb.gymapp.model.TrainerWorkout;
import com.ubb.gymapp.model.Workout;
import com.ubb.gymapp.model.User.UserType;
import com.ubb.gymapp.model.Workout.Difficulty;
import com.ubb.gymapp.repository.RoomRepository;
import com.ubb.gymapp.repository.TimetableRepository;
import com.ubb.gymapp.repository.UserRepository;
import com.ubb.gymapp.repository.WorkoutRepository;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TimeTableTest {
	
	@Autowired
	private TimetableRepository timeRepo ;
	
	@Autowired
	private RoomRepository roomRepo;
	
	@Autowired
	private WorkoutRepository workRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Test
	public void addTimetable() {
		Date dat=new Date();
		Workout work = new Workout();
		work.setWorkoutType("r");
		Room room = new Room();
		Trainer user = new Trainer("1234","1234","1234","1234","1234",null);
		userRepo.save(user);
		workRepo.save(work);
		roomRepo.save(room);
		assertNotNull(work);
		assertNotNull(room);
		assertNotNull(user);
		Timetable pro =new Timetable("Joi", dat, 2L, room, work);
		pro.setTrainer(user);
		timeRepo.save(pro);
		assertNotNull(pro.getId());
		timeRepo.delete(pro);
		workRepo.delete(work);
		roomRepo.delete(room);	
		userRepo.delete(user);
	}
	
	
	@Test
	public void readTimetable() {
		Date dat=new Date();
		Workout work = new Workout();
		work.setWorkoutType("r");
		Room room = new Room();
		Trainer user = new Trainer("1234","1234","1234","1234","1234",null);
		userRepo.save(user);
		workRepo.save(work);
		roomRepo.save(room);
		assertNotNull(work);
		assertNotNull(room);
		assertNotNull(user);
		Timetable pro1 =new Timetable("Joi", dat, 2L, room, work);
		pro1.setTrainer(user);
		timeRepo.save(pro1);
		List<Timetable> pro = timeRepo.findByDay("Joi");
		assertNotNull(pro.get(0).getId());
		assertEquals(pro.get(0).getDay(), "Joi");
		assertEquals(pro.get(0).getDuration(), 2L);
		timeRepo.delete(pro1);
		workRepo.delete(work);
		roomRepo.delete(room);
		userRepo.delete(user);
	} 
	
	@Test 
	public void deleteTimetable() {
		Date dat=new Date();
		Workout work = new Workout();
		work.setWorkoutType("r");
		Room room = new Room();
		Trainer user = new Trainer("1234","1234","1234","1234","1234",null);
		userRepo.save(user);
		workRepo.save(work);
		roomRepo.save(room);
		Timetable pro1 =new Timetable("Joi", dat, 2L, room, work);
		pro1.setTrainer(user);
		pro1 = timeRepo.save(pro1);
		List<Timetable> pro = timeRepo.findByDay("Joi");
		Long id = pro.get(0).getId();
		timeRepo.delete(pro1);
		assertFalse(timeRepo.exists(pro1.getId()));
		workRepo.delete(work);
		roomRepo.delete(room);
		userRepo.delete(user);
	}
	
	@Test
	public void updateTimetable() {
		Date dat=new Date();
		Workout work = new Workout();
		work.setWorkoutType("r");
		Room room = new Room();
		workRepo.save(work);
		roomRepo.save(room);
		Timetable pro1 =new Timetable("Joi", dat, 2L, room, work);
		Trainer user = new Trainer("1234","1234","1234","1234","1234",null);
		user = userRepo.save(user);
		pro1.setTrainer(user);
		timeRepo.save(pro1);
		Timetable pro = timeRepo.save(pro1);
		pro.setDay("Vineri");
		timeRepo.save(pro);
		Timetable pro_updated = timeRepo.findOne(pro.getId());
		assertEquals(pro_updated.getDay(), "Vineri");
		timeRepo.delete(pro);
		workRepo.delete(work);
		roomRepo.delete(room);
		userRepo.delete(user);
	}
	
	@Test
	public void deleteByWorkout(){
		Workout work1 = new Workout("Zumba", Difficulty.MEDIUM, "Pretty much the most awesome workout ever. Dance to great music, with great people, and burn a ton of calories without even realizing it.");
		workRepo.save(work1);
		Room room1 = new Room("Main room");
		roomRepo.save(room1);
		Timetable timetable = new Timetable("Monday", new Date(), 10, room1, work1);
		Trainer user = new Trainer("1234","1234","1234","1234","1234",null);
		user = userRepo.save(user);
		timetable.setTrainer(user);
		timeRepo.save(timetable);
		long id = timetable.getId();
		timeRepo.deleteByWorkout(work1);
		boolean isDeleted = !timeRepo.exists(id);
		assertTrue(isDeleted);
		roomRepo.delete(room1);
		workRepo.delete(work1);
		userRepo.delete(user);

	}

}
