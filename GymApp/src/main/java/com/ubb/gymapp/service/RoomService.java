package com.ubb.gymapp.service;

import java.util.List;

import com.ubb.gymapp.model.Room;

public interface RoomService {

	List<Room> getAllRooms();
	void addRoom(Room room);
	void deleteRoom(Room room);

}
