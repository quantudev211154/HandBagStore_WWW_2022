package com.g9.handbagstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g9.handbagstore.entity.User;
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
		userRepo.save(newUser);
	}
}