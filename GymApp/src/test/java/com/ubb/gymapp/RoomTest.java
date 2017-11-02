package com.ubb.gymapp;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.contains;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ubb.gymapp.model.Room;
import com.ubb.gymapp.repository.RoomRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoomTest {
	@Autowired
	private RoomRepository roomRepo;
	
	@Test
	public void testAdd() {
		Room room = new Room(0L,"TestRoom");
		room = roomRepo.save(room);
		assertNotNull(roomRepo.findOne(room.getRoomId()));
		roomRepo.delete(room);
	}
	
	@Test
	public void testFindOne(){
		Room room = new Room(0L,"TestRoom");
		room = roomRepo.save(room);
		Room newRoom = roomRepo.findOne(room.getRoomId());
		assertEquals(room, newRoom);
		roomRepo.delete(room);
	}
	
	@Test
	public void testDelete(){
		Room room = new Room(0L,"TestRoom");
		room = roomRepo.save(room);
		roomRepo.delete(room);
		assertNull(roomRepo.findOne(room.getRoomId()));
	}
	
	@Test
	public void testFindAll(){
		Room room1 = new Room(0L,"TestRoom1");
		Room room2 = new Room(0L,"TestRoom2");
		Room room3 = new Room(0L,"TestRoom3");
		room1 = roomRepo.save(room1);
		room2 = roomRepo.save(room2);
		room3 = roomRepo.save(room3);
		List<Room> dbRooms = roomRepo.findAll();
		assertThat(dbRooms,hasItems(room1,room2,room3));
		roomRepo.delete(room1);
		roomRepo.delete(room2);
		roomRepo.delete(room3);
	}
	
	@Test
	public void testUpdate(){
		Room room = new Room(0L,"TestRoom");
		room = roomRepo.save(room);
		room.setRoomName("newName");
		roomRepo.save(room);
		Room newRoom = roomRepo.findOne(room.getRoomId());
		assertEquals(newRoom.getRoomName(), "newName");
		roomRepo.delete(room);
	}
}
