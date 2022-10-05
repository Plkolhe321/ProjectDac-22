package com.paradise.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paradise.entity.Admin;
import com.paradise.entity.Booking;
import com.paradise.entity.Visitor;
import com.paradise.repository.VisitorRepository;

@Service
@Transactional
public class VisitorService {

	@Autowired
	private EmailService eservice;
	@Autowired
	private VisitorRepository visitorRepository;

	public String addVisitor(Visitor visitor) {
		
		if(!isVisitorPresent(visitor)) {
		visitorRepository.save(visitor);
		eservice.emailAfterNewRegistration(visitor.getEmail());
		return "Successfully added.";
		}
		else
			return "Already present.";
	}

	boolean isVisitorPresent(Visitor visitor) {

		String username = visitorRepository.findByUserName2(visitor.getUsername());
		if(username != null)
			return true;
		else
			return false;
	}
	
	boolean isVisitorPresent(int visitorId) {
		
		try {
		visitorRepository.findById(visitorId).get();
		}catch(NoSuchElementException e) {
			
			return false;
		}
		return true;
	}
	
	
	public String updateVisitor(String username,Visitor visitor) {
		
		Visitor visitor1 = visitorRepository.findByUserName(username);
		visitor1.setAadharno(visitor.getAadharno());
		visitor1.setEmail(visitor.getEmail());
		visitor1.setMobno(visitor.getMobno());
		visitor1.setName(visitor.getName());
		visitor1.setPassword(visitor.getPassword());
		//visitor.setUsername(username);
		visitorRepository.save(visitor1);
		return "Successfully updated.";
		
	}
	
	
	public List<Visitor> fetchAllVisitor() {
		
			List<Visitor> list = (List<Visitor>) visitorRepository.findAll();
			return list;
		}
	
	
	public Optional<Visitor> fetchVisitor(String username) {
		
		Optional<Visitor> visitor = Optional.of(visitorRepository.findByUserName(username));
		 List<Booking> l = visitor.get().getBooking();
		 System.out.println(l);
		return visitor;
	}
	
	
	public String removeVisitor(int visitorId) {
		
		if(isVisitorPresent(visitorId)) {
			visitorRepository.deleteVisitor(visitorId);
			return "Removed Successfully";
			}
			else
				return "Visitor not exist.";
	}

	public Visitor visitorLogin(String username, String password) {
		Visitor visitor = visitorRepository.login(username,password);
		if(visitor == null) {
			return null;
		}else {
			return visitor;
		}
	}
	
	
}
