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

import com.afs.model.EventSession;

@Service
@PropertySource("classpath:application.properties")
public class SessionRestTemplateImpl implements SessionRestTemplate {

	@Autowired
	RestTemplate restTemplate;

	@Value("${service.endPoint}")
	private String endPoint;

	public EventSession[] getAllSessionsInAnEvent(Long eventId) {
		final String uri = endPoint + "/events/{id}/sessions";
		Map<String, Long> params = new HashMap<String, Long>();
		params.put("id", eventId);
		ResponseEntity<EventSession[]> result = restTemplate.getForEntity(uri, EventSession[].class, params);
		return result.getBody();
	}

	public EventSession getEventSessionById(Long sessionNo) {
		final String uri = endPoint + "/events/sessions/{id}";

		Map<String, Long> params = new HashMap<String, Long>();
		params.put("id", sessionNo);
		ResponseEntity<EventSession> result = restTemplate.getForEntity(uri, EventSession.class, params);
		return result.getBody();
	}

	public boolean saveOrUpdateSessionInAnEvent(Long eventId, EventSession session) {
		final String uri = endPoint + "/events/{id}/sessions";
		Map<String, Long> params = new HashMap<String, Long>();
		params.put("id", eventId);
		HttpEntity<EventSession> entity = new HttpEntity<EventSession>(session);
		ResponseEntity<Boolean> result = restTemplate.exchange(uri, HttpMethod.POST, entity, Boolean.class, params);
		return result.getBody();
	}

	public int deleteEventSessionById(Long sessionNo) {
		final String uri = endPoint + "/events/sessions/{id}";
		Map<String, Long> params = new HashMap<String, Long>();
		params.put("id", sessionNo);
		ResponseEntity<Integer> result = restTemplate.exchange(uri, HttpMethod.DELETE, null, Integer.class, params);
		return result.getBody();
	}

	public EventSession[] searchEventSessionByTerm(String term) {
		final String uri = endPoint + "/events/sessions/search?name=" + term;
		ResponseEntity<EventSession[]> result = restTemplate.getForEntity(uri, EventSession[].class);
		return result.getBody();
	}

}
