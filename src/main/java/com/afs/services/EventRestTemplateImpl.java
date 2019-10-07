package com.afs.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.afs.model.Event;

@Service
public class EventRestTemplateImpl implements EventRestTemplate {

	@Autowired
	RestTemplate restTemplate;

	public Event[] getEvents() {
		final String uri = "http://localhost:9090/MyApp/events";
		ResponseEntity<Event[]> response = restTemplate.getForEntity(uri, Event[].class);
		Event[] events = response.getBody();
		return events;
	}

	public Event getEvent(Long id) {
		final String uri = "http://localhost:9090/MyApp/events/{id}";
		Map<String, Long> params = new HashMap<String, Long>();
		params.put("id", id);

		ResponseEntity<Event> response = restTemplate.getForEntity(uri, Event.class, params);
		Event event = response.getBody();
		return event;
	}

	public void saveOrUpdateEvent(Event event) {
		final String uri = "http://localhost:9090/MyApp/events";

		HttpEntity<Event> requestEntity = new HttpEntity<Event>(event);
		restTemplate.exchange(uri, HttpMethod.POST, requestEntity, Boolean.class);
	}

	public void deleteEvent(Long id) {
		final String uri = "http://localhost:9090/MyApp/events/{id}";
		Map<String, Long> params = new HashMap<String, Long>();
		params.put("id", id);
		restTemplate.delete(uri, params);
	}
}
