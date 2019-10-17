package com.afs.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.afs.model.Event;
import com.afs.services.EventRestTemplate;

import junit.framework.Assert;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockApplication.class)
public class EventServiceTest {
	@Autowired
	private EventRestTemplate eventSvc;

	@Test
	public void when() {
		Event event = new Event();
		event.setId(1L);
		event.setName("Event1");
		Mockito.when(eventSvc.getEvent(1L)).thenReturn(event);
		
		Event ev = eventSvc.getEvent(1L);
		Assert.assertEquals("Event1", ev.getName());
	}
	
	
}
