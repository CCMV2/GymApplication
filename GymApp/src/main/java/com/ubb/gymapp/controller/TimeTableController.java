package com.ubb.gymapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ubb.gymapp.model.Timetable;
import com.ubb.gymapp.service.IAdminService;

@RestController
public class TimeTableController {
	
	@Autowired
	private IAdminService adminService;
	
	@RequestMapping(value = "/gettimetable", method = RequestMethod.POST)
	public Timetable findOneTimetable(@RequestBody Long parameter) {
		return adminService.getTimetableById(parameter);
	}
	
	@RequestMapping(value = "/getalltimetables", method = RequestMethod.GET)
	public List<Timetable> getAllTimetables() {
		return adminService.getAllTimetables();
	}
	
	@RequestMapping(value = "/addtimetable", method = RequestMethod.POST)
	public String addTimeTable(@RequestBody Timetable parameter) {
		try {
			adminService.addTimeTable(parameter);
			return "The timetable has been saved!";
		} catch (Exception e) {
			return "Failed: " + e.getMessage();
		}
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/updatetimetable", method = RequestMethod.POST)
	public String updateTimeTable(@RequestBody Timetable parameter) {
		try {
			adminService.updateTimeTable(parameter);
			return "Update successful";
		} catch (Exception e) {
			return "Failed: " + e.getMessage();
		}
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/deletetimetable", method = RequestMethod.POST)
	public String deleteTimeTable(@RequestBody Timetable parameter) {
		adminService.deleteTimeTable(parameter);
		return "Delete successful";
	}

}
