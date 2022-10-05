package com.paradise.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender emailSender;

	public void emailAfterNewRegistration(String email) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("travelersparadise59@gmail.com");
		message.setTo(email);
		message.setSubject("Thank you for Registering with us!");
		message.setText("WELCOME to the Traveler's Paradise ");
		emailSender.send(message);
	}
	
	public void emailAfterBooking(String email) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("travelersparadise59@gmail.com");
		message.setTo(email);
		message.setSubject("Travelers Paradise");
		message.setText("Thank you for Booking with us!");
		emailSender.send(message);
	}


//	public void sendOtp(String email, String otp) {
//		SimpleMailMessage message = new SimpleMailMessage();
//		message.setTo(email);
//		message.setSubject("OTP");
//		message.setText(otp);
//		emailSender.send(message);
//	}
}