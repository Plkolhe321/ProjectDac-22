package com.paradise.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paradise.entity.Admin;
import com.paradise.entity.Visitor;
import com.paradise.repository.AdminRepository;

@Service
@Transactional
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;

	public String addAdmin(Admin admin) {
		if(!isAdminPresent(admin.getAdminId())) {
			adminRepository.save(admin);
		return "Admin successfully added.";
		}
		else
			return "Failed.";
	}

	boolean isAdminPresent(int adminId) {

		try {
			adminRepository.findById(adminId).get();
		}catch(NoSuchElementException e) {
			return false;
		}
		return true;
	}

	public List<Admin> fetchAllAdmin() {

		List<Admin> list = adminRepository.findAll();
		return list;
	}


	public Optional<Admin> fetchAdmin(int adminId) {

	Optional<Admin> admin = adminRepository.findById(adminId);
	return admin;
}

	public String updateAdmin(int adminId,Admin admin) {
	if(isAdminPresent(adminId)) {
		admin.setAdminId(adminId);
		adminRepository.save(admin);
	return "Admin successfully updated.";
	}
	else
		return "Failed.";
}

	public String removeAdmin(int adminId) {

		if(isAdminPresent(adminId)) {
			adminRepository.deleteById(adminId);
			return "Admin removed successfully.";
		}
			else
				return "Admin not exist.";
	}

//	public boolean adminLogin(String ausername,String apassword) {
//
//		Admin admin = adminRepository.login(ausername,apassword);
//		if(admin == null) {
//			return false;
//		}else {
//			return true;
//		}
//
//	}

	public Admin adminLogin(String ausername, String apassword) {
		Admin admin = adminRepository.login(ausername,apassword);
		if(admin == null) {
			return null;
		}else {
			return admin;
		}
	}
		
	
	
}
