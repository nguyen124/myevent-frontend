package com.afs.services;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.afs.model.Event;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EventRestTemplateImpl implements EventRestTemplate {

	public Event[] getEvents() {
		final String uri = "http://localhost:9090/MyApp/events";
		ObjectMapper objectMapper = new ObjectMapper();

		RestTemplate restTemplate = new RestTemplate();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setObjectMapper(objectMapper);
		restTemplate.getMessageConverters().add(converter);

		ResponseEntity<Event[]> response = restTemplate.getForEntity(uri, Event[].class);
		Event[] events = response.getBody();
		return events;
	}
}
