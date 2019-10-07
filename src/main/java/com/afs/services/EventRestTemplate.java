package com.afs.services;

import com.afs.model.Event;

public interface EventRestTemplate {
	Event[] getEvents();

	Event getEvent(Long id);

	boolean saveOrUpdateEvent(Event event);

	int deleteEvent(Long id);
}
