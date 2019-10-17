package com.afs.test;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.afs.services.EventRestTemplate;

@Profile("test")
@Configuration
public class EventServiceTestConfig {
	@Bean
	@Primary
	public EventRestTemplate eventRestTemplate() {
		return Mockito.mock(EventRestTemplate.class);
	}
}
