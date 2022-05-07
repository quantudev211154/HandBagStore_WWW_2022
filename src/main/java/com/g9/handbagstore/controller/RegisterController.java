package com.g9.handbagstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.g9.handbagstore.entity.User;
import com.g9.handbagstore.service.impl.UserServiceImpl;

@Controller
public class RegisterController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@PostMapping("/register")
	public String register(@ModelAttribute User user) {
		
		user.setCustomerId(0);
		userServiceImpl.addOrUpdateUser(user);
		
		return "redirect:/login";
	}
}