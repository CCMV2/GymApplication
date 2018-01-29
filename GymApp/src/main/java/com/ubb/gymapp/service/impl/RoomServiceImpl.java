package com.ubb.gymapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ubb.gymapp.model.Room;
import com.ubb.gymapp.repository.ClientTimetableRepository;
import com.ubb.gymapp.repository.RoomRepository;
import com.ubb.gymapp.repository.TimetableRepository;
import com.ubb.gymapp.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService{

	@Autowired
	private RoomRepository roomRepo;
	
	@Autowired
	private TimetableRepository timetableRepo;
	
	@Autowired
	private ClientTimetableRepository clientTimetableRepo;
	
	@Override
	public List<Room> getAllRooms() {
		return roomRepo.findAll();
	}

	@Override
	public void addRoom(Room room) {
		roomRepo.save(room);

	}

	@Override
	public void deleteRoom(Room room) {
		clientTimetableRepo.deleteByTimetableRoom(room);
		timetableRepo.deleteByRoom(room);
		roomRepo.delete(room);
	}

}
