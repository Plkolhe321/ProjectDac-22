package com.paradise.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paradise.entity.Event;
import com.paradise.service.EventService;
@CrossOrigin(origins="http://localhost:3000/")
@RestController
@RequestMapping("/event")
public class EventController {

	@Autowired
	private EventService eventService;

	@GetMapping("/find.paradise")
	List<Event> allEventDetailsController() {
		return eventService.fetchAllEvent();
	}

	@GetMapping("/find.paradise/{id}")
	Optional<Event> eventDetailsController(@PathVariable(value = "id") int eventId) {
		return eventService.fetchEvent(eventId);
	}
	
	@GetMapping("/find.paradise2/{eventname}")
	Optional<Event> eventDetailsController1(@PathVariable(value = "eventname") String eventname) {
		System.out.println(eventname);
		return eventService.fetchEvent(eventname);
	}


	@PostMapping("/addEvent.paradise")
	String registrationController(@RequestBody Event event) {
		System.out.println(event);
		return eventService.addEvent(event);
	}

	@PutMapping("/update.paradise/{id}")
	String eventUpdationController(@PathVariable(value = "id") int eventId,@RequestBody Event event) {

		return eventService.updateEvent(eventId,event);
	}

	@DeleteMapping("/delete.paradise/{id}")
	String eventDeletionController(@PathVariable(value = "id") int eventId) {

		return eventService.removeEvent(eventId);
	}

}
