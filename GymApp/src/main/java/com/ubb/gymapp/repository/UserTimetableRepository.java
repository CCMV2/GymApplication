package com.ubb.gymapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ubb.gymapp.model.Timetable;
import com.ubb.gymapp.model.User;
import com.ubb.gymapp.model.UserTimetable;

public interface UserTimetableRepository extends JpaRepository<UserTimetable, Long>{
	@Transactional
	@Modifying
	@Query("delete from UserTimetable u where u.user = ?1")
	public void deleteByUser(User user);
	
	@Transactional
	@Modifying
	@Query("delete from UserTimetable u where u.timetable = ?1")
	public void deleteByTimetable(Timetable timetable);
	
	public UserTimetable findByUserAndTimetable(User user, Timetable timetable);

	@Query("select u.timetable from UserTimetable u where u.user.email = ?1")
	public List<Timetable> getUserTimetables(String username);
}
