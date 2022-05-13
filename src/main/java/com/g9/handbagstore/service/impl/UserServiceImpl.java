package com.g9.handbagstore.service.impl;

import java.util.List;

import com.g9.handbagstore.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.g9.handbagstore.repository.UserRepository;
import com.g9.handbagstore.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User getUserByUserName(String username) {
		return userRepo.getUserByUserName(username);
	}

	@Override
	public void addOrUpdateUser(User newUser) {
		newUser.setPassword(new BCryptPasswordEncoder().encode(newUser.getPassword()));
		userRepo.save(newUser);
	}

	@Override
	public User getUserByUserID(int userID) {
		return userRepo.findById(userID).get();
	}

	@Override
	public void updateOldUser(User user) {
		userRepo.save(user);
	}

	@Override
	public List<User> getUsersByRole(String role) {
		return userRepo.getUsersByRole(role);
	}
}