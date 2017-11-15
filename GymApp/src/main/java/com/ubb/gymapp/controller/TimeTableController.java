package com.ubb.gymapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.ubb.gymapp.model.Timetable;
import com.ubb.gymapp.service.IAdminService;

public class TimeTableController {
	
	@Autowired
	private IAdminService adminService;
	
	@RequestMapping(value = "/gettimetable", method = RequestMethod.POST)
	public Timetable findOneTimetable(@RequestBody Long parameter) {
		return adminService.getTimetableById(parameter);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/addtimetable", method = RequestMethod.POST)
	public String addTimeTable(@RequestBody Timetable parameter) {
		adminService.addTimeTable(parameter);
		return "Save successful";
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/updatetimetable", method = RequestMethod.POST)
	public String updateTimeTable(@RequestBody Timetable parameter) {
		adminService.updateTimeTable(parameter);
		return "Update successful";
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/deletetimetable", method = RequestMethod.POST)
	public String deleteTimeTable(@RequestBody Timetable parameter) {
		adminService.deleteTimeTable(parameter);
		return "Delete successful";
	}

}
