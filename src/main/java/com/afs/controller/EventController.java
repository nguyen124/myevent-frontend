package com.afs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.afs.model.Event;
import com.afs.services.EventRestTemplate;

@RestController
public class EventController {

	@Autowired
	private EventRestTemplate eventService;

	@RequestMapping(value = "/events", method = RequestMethod.GET)
	public ResponseEntity<Event[]> getAll() {
		Event[] events = eventService.getEvents();
		return new ResponseEntity<Event[]>(events, HttpStatus.OK);
	}

}
