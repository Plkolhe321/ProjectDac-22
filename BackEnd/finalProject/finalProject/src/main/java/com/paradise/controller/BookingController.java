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

import com.paradise.entity.Booking;
import com.paradise.entity.Review;
import com.paradise.service.BookingService;
import com.paradise.service.ReviewService;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	@GetMapping("/find.paradise")
	List<Booking> allBookingDetailsController(){
		return bookingService.fetchAllBookings();
	}
	
	@GetMapping("/find.paradise/{id}")
	Optional<Booking> bookingDetailsController(@PathVariable(value="id") int bookingId){
		return bookingService.fetchBooking(bookingId);
	}
	
	@GetMapping("/find.paradise2/{username}")
	List<Booking> bookingDetailsController(@PathVariable(value="username") String username){
		return bookingService.fetchBookingList(username);
	}
	
	
	@PostMapping("/addBooking.paradise/{visitorId}")
	String bookingAdditionController(@PathVariable(value="visitorId") int visitorId,@RequestBody Booking booking) {
		System.out.println(visitorId + "	" + booking);
		return bookingService.addBooking(booking,visitorId);
	}
	
	@DeleteMapping("/delete.paradise/{id}")
	String visitorDeletionController(@PathVariable(value="id") int bookingId) {
		
		return bookingService.removeBooking(bookingId);
	}
	
}