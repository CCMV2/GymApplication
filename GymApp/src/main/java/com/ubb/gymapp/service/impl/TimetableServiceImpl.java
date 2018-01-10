package com.ubb.gymapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ubb.gymapp.model.Timetable;
import com.ubb.gymapp.repository.TimetableRepository;
import com.ubb.gymapp.repository.UserTimetableRepository;
import com.ubb.gymapp.service.TimetableService;

@Service
public class TimetableServiceImpl implements TimetableService{
	
	@Autowired
	public TimetableRepository timetableRepo;
	
	@Autowired
	public UserTimetableRepository userTimetableRepo;
	
	@Override
	public void addTimeTable(Timetable timetable) {
		timetableRepo.save(timetable);
		
	}

	@Override
	public void deleteTimeTable(Timetable timetable) {
		timetableRepo.delete(timetable);
	}

	@Override
	public List<Timetable> getAllTimetables() {
		return timetableRepo.findAll();
	}

	@Override
	public List<Timetable> getUserTimetables(String username) {
		return userTimetableRepo.getUserTimetables(username);
	}

}
