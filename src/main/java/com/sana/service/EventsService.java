package com.sana.service;

import java.util.List;

import com.sana.models.Events;

public interface EventsService {
	
	void addEvent(Events events);
	void deleteEvent(int id);
	void update(Events events);
	Events getEventsbyId(int id);
	List<Events> getAlleventsbypostDate();
	Long countEvents();
	

}
