package com.afs.services;

import com.afs.model.EventSession;

public interface SessionRestTemplate {
	public boolean saveOrUpdateSessionInAnEvent(Long eventId, EventSession session);

	public EventSession[] getAllSessionsInAnEvent(Long eventId);

	public EventSession getEventSessionById(Long sessionNo);

	public int deleteEventSessionById(Long sessionNo);

	public EventSession[] searchEventSessionByTerm(String term);
}
