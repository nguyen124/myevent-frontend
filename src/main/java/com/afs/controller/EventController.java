package com.afs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

	@RequestMapping(value = "/events/{id}", method = RequestMethod.GET)
	public ResponseEntity<Event> getEvent(@PathVariable("id") Long id) {
		Event result = eventService.getEvent(id);
		return new ResponseEntity<Event>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/events", method = RequestMethod.POST)
	public ResponseEntity<Boolean> saveEvent(@RequestBody Event event) {
		eventService.saveOrUpdateEvent(event);
		return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(value = "/events/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteEvent(@PathVariable("id") Long id) {
		eventService.deleteEvent(id);
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}
