package com.sana.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sana.models.Events;
import com.sana.service.EventsService;

@RestController
public class EventsApi {
	
	@Autowired
	private EventsService eventsService;
	
	@GetMapping("/api/allEvents")
	public List<Events> getallEvents(){
		return eventsService.getAlleventsbypostDate();
	}

}
