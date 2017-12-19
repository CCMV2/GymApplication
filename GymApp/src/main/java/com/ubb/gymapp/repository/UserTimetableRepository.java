package com.ubb.gymapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ubb.gymapp.model.User;

public interface UserTimetableRepository extends JpaRepository<User, Long>{
	@Transactional
	@Modifying
	@Query("delete from UserTimetable u where u.user = ?1")
	public void deleteByUser(User user);
}
