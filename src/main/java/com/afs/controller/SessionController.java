package com.afs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.afs.model.EventSession;
import com.afs.services.SessionRestTemplate;

@RestController
public class SessionController {
	@Autowired
	SessionRestTemplate eventSessionService;

	@RequestMapping(value = "/events/{id}/sessions", method = RequestMethod.GET)
	public ResponseEntity<EventSession[]> getAllSessionsInAnEvent(@PathVariable("id") Long eventId) {
		EventSession[] result = eventSessionService.getAllSessionsInAnEvent(eventId);
		return new ResponseEntity<EventSession[]>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/events/{id}/sessions", method = RequestMethod.POST)
	public ResponseEntity<Boolean> saveSession(@PathVariable("id") Long eventId, @RequestBody EventSession session) {
		boolean result = eventSessionService.saveOrUpdateSessionInAnEvent(eventId, session);
		return new ResponseEntity<Boolean>(result, HttpStatus.OK);
	}
}
