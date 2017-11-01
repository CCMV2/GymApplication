package com.ubb.gymapp;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ubb.gymapp.model.Timetable;
import com.ubb.gymapp.repository.TimetableRepository;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GymappApplicationTests {
	
	@Autowired
	private TimetableRepository timeRepo;
	
	@Test
	public void tetfindby() {
		//List<Timetable> a= timeRepo.findByDay("mo");
		//assertNull(a);
	}
	
	

}
