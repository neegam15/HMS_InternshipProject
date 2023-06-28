package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.User;
import com.cg.exception.ResourceNotFoundException;
import com.cg.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserRepository userRepository;

	@Override
	public User showUser(int userId) {
		Optional<User> optionalUser = userRepository.findById(userId);
		if (optionalUser.isEmpty()) {
			throw new ResourceNotFoundException("User Not found with id : " + userId);
		}
		return optionalUser.get();
	}

	@Override
	public List<User> showAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User removeUser(int userId) {
		User user = showUser(userId);
		if (user == null) {
			throw new ResourceNotFoundException("User Not found with id : " + userId);
		}
		userRepository.delete(user);
		return user;
	}

	@Override
	public User updateUser(User user) {
		return showUser(user.getUserId());
	}

	@Override
	public User addUser(User user) {
		return userRepository.save(user);

	}
}