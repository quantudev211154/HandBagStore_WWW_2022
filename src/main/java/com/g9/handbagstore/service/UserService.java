package com.g9.handbagstore.service;

import java.util.List;

import com.g9.handbagstore.entity.User;

public interface UserService {
	List<User> getAllUsers();
	User getUserByUserName(String username);
	void addOrUpdateUser(User newUser);
}