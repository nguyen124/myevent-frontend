package com.afs.services;

import com.afs.model.Event;

public interface EventRestTemplate {
	Event[] getEvents();

	Event getEvent(Long id);

	void saveOrUpdateEvent(Event event);

	void deleteEvent(Long id);
}
