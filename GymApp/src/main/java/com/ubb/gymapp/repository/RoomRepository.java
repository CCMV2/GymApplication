package com.ubb.gymapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ubb.gymapp.model.Room;

public interface RoomRepository extends CrudRepository<Room,Long> {
	public List<Room> findRoomByName(String name);
}
