package com.cg.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Admin;
import com.cg.model.AdminPayload;
import com.cg.service.AdminServiceImpl;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminServiceImpl adminServiceImpl;

	@GetMapping("/createAdminAccount")
	public ResponseEntity<Admin> saveAdmin() {
		Admin admin = adminServiceImpl.saveAdmin();
		return new ResponseEntity<>(admin, HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<String> loginAdmin(@Valid @RequestBody AdminPayload adminPayload) {
		String message = adminServiceImpl.login(adminPayload);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@DeleteMapping("/logout")
	public ResponseEntity<String> deleteAdminById() {
		adminServiceImpl.logout();
		return new ResponseEntity<>("Logged out Successfully", HttpStatus.OK);
	}
}