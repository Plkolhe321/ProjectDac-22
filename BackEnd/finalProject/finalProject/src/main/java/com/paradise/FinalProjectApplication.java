package com.paradise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;

import com.paradise.service.EmailService;

@SpringBootApplication
@ComponentScan(basePackages="com")
public class FinalProjectApplication {


	
	public static void main(String[] args) {
		SpringApplication.run(FinalProjectApplication.class, args);
		
	}
		
	
	
}
