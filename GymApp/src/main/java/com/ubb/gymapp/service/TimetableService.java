package com.ubb.gymapp.service;

import java.util.List;

import com.ubb.gymapp.model.Timetable;

public interface TimetableService {
	
	List<Timetable> getAllTimetables();
	void addTimeTable(Timetable timetable);
	void deleteTimeTable(Timetable timetable);

}
