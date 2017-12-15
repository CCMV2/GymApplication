package com.ubb.gymapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ubb.gymapp.model.Timetable;
import com.ubb.gymapp.service.TimetableService;

@RestController
public class TimeTableController {
	
	@Autowired
	private TimetableService timeTableService;
	
	@RequestMapping(value = "/getalltimetables", method = RequestMethod.GET)
	public List<Timetable> getAllTimetables() {
		return timeTableService.getAllTimetables();
	}
	
	@RequestMapping(value = "/addtimetable", method = RequestMethod.POST)
	public String addTimeTable(@RequestBody Timetable parameter) {
		try {
			timeTableService.addTimeTable(parameter);
			return "The timetable has been saved!";
		} catch (Exception e) {
			return "Failed: " + e.getMessage();
		}
	}
	

	@RequestMapping(value = "/deletetimetable", method = RequestMethod.POST)
	public String deleteTimeTable(@RequestBody Timetable parameter) {
		timeTableService.deleteTimeTable(parameter);
		return "Delete successful";
	}

}
