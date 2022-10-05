package com.paradise.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paradise.entity.Booking;
import com.paradise.entity.Visitor;
import com.paradise.repository.BookingRepository;
import com.paradise.repository.VisitorRepository;


@Service
@Transactional
public class BookingService {
	
	@Autowired
	private VisitorRepository visitorRepository;
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private EmailService eservice;
	
	
	public String addBooking(Booking booking, int visitorId) {
		
		if(!isVisitorPresent(visitorId,booking)) {
		bookingRepository.save(booking);
		
		eservice.emailAfterBooking(booking.getVisitor().getEmail());

		return "Successfully added.";
		}
		else
			return "Already present.";
	}

	boolean isVisitorPresent(int visitorId,Booking booking) {

		try {
		Visitor visitor = visitorRepository.findById(visitorId).get();
		booking.setVisitor(visitor);
		}catch(NoSuchElementException e) {
			
			return true;
		}
		return false;
	}   
	
//	boolean isCampPresent(int campId,Booking booking) {
//		
//		try {
//		Camp camp = campRepository.findById(campId).get();
//		booking.setCamp(camp);
//		}catch(NoSuchElementException e) {
//			
//			return true;
//		}
//		return false;
//	}
//	
//	boolean isEventPresent(int eventId,Booking booking) {
//		System.out.println(eventId);
//		try {
//			Event event = eventRepository.findById(eventId).get();
//			booking.setEvent(event);
//		}catch(NoSuchElementException e) {
//			
//			return true;
//		}
//		return false;
//	}

	public List<Booking> fetchAllBookings() {
		
		return   bookingRepository.findAll();
		
	}


	public Optional<Booking> fetchBooking(int bookingId) {
	
	Optional<Booking> booking = bookingRepository.findById(bookingId);
	return booking;
}

	public List<Booking> fetchBookingList(String username) {
		
	List<Booking> bookingList = bookingRepository.findIdByUserName(username);
//	System.out.println("aaa  "+bookingList.toString());
	return bookingList;
}

	public String removeBooking(int bookingId) {
		
		if(isBookingPresent(bookingId)) {
			bookingRepository.deleteBooking(bookingId);
			return "Removed Successfully";
			}
			else
				return "Booking not exist.";
	}

	boolean isBookingPresent(int bookingId) {
		
		try {
		bookingRepository.findById(bookingId).get();
		}catch(NoSuchElementException e) {
			return false;
		}
		return true;
	}

}