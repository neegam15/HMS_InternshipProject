package com.cg.service;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import com.cg.entity.User;

@Validated
public interface IUserService {
	User showUser(int userId);

	List<User> showAllUsers();

	User removeUser(int userId);

	User updateUser(User user);

	User addUser(User user);
}