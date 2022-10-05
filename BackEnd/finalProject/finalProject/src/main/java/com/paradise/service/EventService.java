package com.paradise.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paradise.entity.Event;
import com.paradise.repository.EventRepository;

@Service
@Transactional
public class EventService {

	@Autowired
	private EventRepository eventRepository;


	public String addEvent(Event event) {
		System.out.println(event);
		if(isEventPresent(event)) {
		eventRepository.save(event);
		return "Successfully added.";
		}
		else
			return "Already present.";
	}

	boolean isEventPresent(Event event) {
		System.out.println(event);
		try {
			eventRepository.findById(event.getEventId()).get();
		}catch(NoSuchElementException e) {
			return true;
		}
		return false;
	}

	boolean isEventPresent(int eventId) {

		try {
			eventRepository.findById(eventId).get();
		}catch(NoSuchElementException e) {

			return false;
		}
		return true;
	}
	
public Optional<Event> fetchEvent(String eventname) {
		
		Optional<Event> event = eventRepository.findByName(eventname);
		return event;
	}


	public String updateEvent(int eventId, Event event) {

		if(isEventPresent(eventId)) {
			event.setEventId(eventId);
			eventRepository.save(event);
			return "Successfully updated.";
			}
			else
				return "Event not exist.";
	}

	public List<Event> fetchAllEvent() {
		List<Event> list=eventRepository.findAll();
		return list;
	}

	public Optional<Event> fetchEvent(int eventId) {

		Optional<Event> event = eventRepository.findById(eventId);
		return event;
	}

	public String removeEvent(int eventId) {

		if(isEventPresent(eventId)) {
			eventRepository.deleteById(eventId);
			return "Removed Successfully";
			}
			else
				return "Event not exist.";
	}

}
