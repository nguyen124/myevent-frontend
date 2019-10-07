package com.afs.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.afs.model.Event;

@Service
@PropertySource("classpath:application.properties")
public class EventRestTemplateImpl implements EventRestTemplate {

	@Autowired
	RestTemplate restTemplate;

	@Value("${service.endPoint}")
	private String endPoint;

	public Event[] getEvents() {
		final String uri = endPoint + "/events";
		ResponseEntity<Event[]> response = restTemplate.getForEntity(uri, Event[].class);
		Event[] events = response.getBody();
		return events;
	}

	public Event getEvent(Long id) {
		final String uri = endPoint + "/events/{id}";
		Map<String, Long> params = new HashMap<String, Long>();
		params.put("id", id);

		ResponseEntity<Event> response = restTemplate.getForEntity(uri, Event.class, params);
		Event event = response.getBody();
		return event;
	}

	public boolean saveOrUpdateEvent(Event event) {
		final String uri = endPoint + "/events";

		HttpEntity<Event> requestEntity = new HttpEntity<Event>(event);
		ResponseEntity<Boolean> result = restTemplate.exchange(uri, HttpMethod.POST, requestEntity, Boolean.class);
		return result.getBody();
	}

	public int deleteEvent(Long id) {
		final String uri = endPoint + "/events/{id}";

		Map<String, Long> params = new HashMap<String, Long>();
		params.put("id", id);
		ResponseEntity<Integer> result = restTemplate.exchange(uri, HttpMethod.DELETE, null, Integer.class);
		return result.getBody();
	}
}
