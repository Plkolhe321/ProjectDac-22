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

import com.paradise.entity.Admin;
import com.paradise.entity.Visitor;
import com.paradise.service.AdminService;

@CrossOrigin(origins="http://localhost:3000/")
@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

//	@GetMapping("/login.paradise/{ausername}/{apassword}")
//	String adminLoginController(@PathVariable(value="ausername") String ausername,@PathVariable(value="apassword") String apassword){
//		System.out.println(ausername+" "+apassword);
//		if(adminService.adminLogin(ausername,apassword))
//		return ausername+" "+apassword;
//		else
//		return "invalid";
//	}


	
@GetMapping("/login.paradise/{ausername}/{apassword}")
Admin adminLoginController(@PathVariable(value="ausername") String ausername,@PathVariable(value="apassword") String apassword){
	
	if(adminService.adminLogin(ausername,apassword) == null)
	return null;
	else
	return adminService.adminLogin(ausername,apassword);
}

	
	@GetMapping("/find.paradise")
	List<Admin> allAdminDetailsController(){
		return adminService.fetchAllAdmin();
	}

	@GetMapping("/find.paradise/{id}")
	Optional<Admin> adminDetailsController(@PathVariable(value="id") int adminId){
		return adminService.fetchAdmin(adminId);
	}

	@PostMapping("/addAdmin.paradise")
	String adminAdditionController(@RequestBody Admin admin) {

		return adminService.addAdmin(admin);
	}

	@PutMapping("/update.paradise/{id}")
	String adminUpdationController(@PathVariable(value="id") int adminId,@RequestBody Admin admin) {

		return adminService.updateAdmin(adminId,admin);
	}

	@DeleteMapping("/delete.paradise/{id}")
	String adminDeletionController(@PathVariable(value="id") int adminId) {

		return adminService.removeAdmin(adminId);
	}
}
