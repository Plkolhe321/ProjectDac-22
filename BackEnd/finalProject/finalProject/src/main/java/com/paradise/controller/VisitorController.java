package com.paradise.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paradise.entity.Visitor;

import com.paradise.service.VisitorService;

@RestController
@Validated
@CrossOrigin("http://localhost:3000/")
@RequestMapping("/visitor")
public class VisitorController {
	
@Autowired
private VisitorService visitorService;
	
@GetMapping("/login.paradise/{username}/{password}")
Visitor VisitorLoginController(@PathVariable(value="username") String username,@PathVariable(value="password") String password){
	
	if(visitorService.visitorLogin(username,password) == null)
	return null;
	else
	return visitorService.visitorLogin(username,password);
}

@GetMapping("/find.paradise")
List<Visitor> allVisitorDetailsController(){
	return visitorService.fetchAllVisitor();
}

@GetMapping("/find.paradise/{username}")
Optional<Visitor> visitorDetailsController(@PathVariable(value="username") String username){
	return visitorService.fetchVisitor(username);
}

@PostMapping("/register.paradise")
String registrationController(@RequestBody Visitor visitor) {
	System.out.println(visitor.getMobno());
	return visitorService.addVisitor(visitor);
}

@PutMapping("/update.paradise/{username}")
String visitorUpdationController(@PathVariable(value="username") String visitorUsername,@RequestBody Visitor visitor) {
	return visitorService.updateVisitor(visitorUsername,visitor);
}

@DeleteMapping("/delete.paradise/{id}")
String visitorDeletionController(@PathVariable(value="id") int visitorId) {
	return visitorService.removeVisitor(visitorId);
}

}
