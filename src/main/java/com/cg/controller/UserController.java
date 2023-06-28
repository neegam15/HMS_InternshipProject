package com.cg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.User;
import com.cg.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;

	@PostMapping("/add")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
		User addedUser = userService.addUser(user);
		return new ResponseEntity<>(addedUser, HttpStatus.CREATED);
	}

	@GetMapping("/allUsers")
	public List<User> getAllUsers() {
		return userService.showAllUsers();
	}

	@GetMapping("/get/{userid}")
	public ResponseEntity<User> getUserById(@Valid @PathVariable("userid") int userId) {

		User returnedUser = userService.showUser(userId);

		return new ResponseEntity<>(returnedUser, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{userid}")
	public ResponseEntity<String> deleteUserById(@Valid @PathVariable("userid") int userId) {

		userService.removeUser(userId);
		return new ResponseEntity<>("User deleted", HttpStatus.OK);

	}

}