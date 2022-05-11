package com.g9.handbagstore.service;

import com.g9.handbagstore.entity.User;

import java.util.List;

public interface UserService {
	List<User> getAllUsers();
	User getUserByUserID(int userID);
	User getUserByUserName(String username);
	void addOrUpdateUser(User newUser);
}