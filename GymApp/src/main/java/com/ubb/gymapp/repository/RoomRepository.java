package com.ubb.gymapp.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ubb.gymapp.model.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
	
	List<Room> findByRoomName(String roomName);
}
