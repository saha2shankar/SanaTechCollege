package com.sana.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sana.models.Events;
import com.sana.repository.EventsRepository;
import com.sana.service.EventsService;

@Service
public class EventsServiceImpl implements EventsService{
	
	@Autowired
	private EventsRepository repo;

	@Override
	public void addEvent(Events events) {
		repo.save(events);
		
	}

	@Override
	public void deleteEvent(int id) {
		repo.deleteById(id);
		
	}

	@Override
	public void update(Events events) {
		repo.save(events);
	}

	@Override
	public Events getEventsbyId(int id) {
		
		return repo.findById(id).get();
	}

	@Override
	public List<Events> getAlleventsbypostDate() {
		List<Events> events =repo.findAll();
		List<Events> sortedEvents = events.stream().sorted((e1, e2) -> e2.getDate().compareTo(e1.getDate())).collect(Collectors.toList());
		return sortedEvents;
	}

	@Override
	public Long countEvents() {
		
		return repo.count();
	}

}
