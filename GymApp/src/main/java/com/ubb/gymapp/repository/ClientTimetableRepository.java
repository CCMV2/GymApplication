package com.ubb.gymapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ubb.gymapp.model.Timetable;
import com.ubb.gymapp.model.Client;
import com.ubb.gymapp.model.ClientTimetable;

public interface ClientTimetableRepository extends JpaRepository<ClientTimetable, Long>{
	@Transactional
	@Modifying
	@Query("delete from ClientTimetable u where u.client = ?1")
	public void deleteByClient(Client client);
	
	@Transactional
	@Modifying
	@Query("delete from ClientTimetable u where u.timetable = ?1")
	public void deleteByTimetable(Timetable timetable);
	
	public ClientTimetable findByClientAndTimetable(Client client, Timetable timetable);

	@Query("select u.timetable from ClientTimetable u where u.client.email = ?1")
	public List<Timetable> getClientTimetables(String username);
	
	public List<ClientTimetable> findByClient(Client client);
}
