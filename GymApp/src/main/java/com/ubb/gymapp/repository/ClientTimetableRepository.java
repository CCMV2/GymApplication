package com.ubb.gymapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ubb.gymapp.model.Timetable;
import com.ubb.gymapp.model.Trainer;
import com.ubb.gymapp.model.Workout;
import com.ubb.gymapp.model.Client;
import com.ubb.gymapp.model.ClientTimetable;
import com.ubb.gymapp.model.Room;

public interface ClientTimetableRepository extends JpaRepository<ClientTimetable, Long>{
	@Transactional
	@Modifying
	@Query("delete from ClientTimetable u where u.client = ?1")
	public void deleteByClient(Client client);
	
	@Transactional
	@Modifying
	@Query("delete from ClientTimetable u where u.timetable = ?1")
	public void deleteByTimetable(Timetable timetable);
	
	@Transactional
	@Modifying
	@Query("delete from ClientTimetable u where u.timetable.id in (select id from Timetable t where t.room= ?1)")
	public void deleteByTimetableRoom(Room room);
	
	@Transactional
	@Modifying
	@Query("delete from ClientTimetable u where u.timetable.id in (select id from Timetable t where t.workout= ?1)")
	public void deleteByTimetableWorkout(Workout workout);

	@Transactional
	@Modifying
	@Query("delete from ClientTimetable u where u.timetable.id in (select id from Timetable t where t.trainer= ?1)")
	public void deleteByTimetableTrainer(Trainer trainer);
	
	public ClientTimetable findByClientAndTimetable(Client client, Timetable timetable);

	@Query("select u.timetable from ClientTimetable u where u.client.email = ?1")
	public List<Timetable> getClientTimetables(String username);
	
	public List<ClientTimetable> findByClient(Client client);
}
