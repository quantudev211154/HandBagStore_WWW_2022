package com.g9.handbagstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.g9.handbagstore.service.impl.UserServiceImpl;

@Controller
public class LoginController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@GetMapping("/welcome")
	public String welcomePage(Model model) {
		return "view_customer/index";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "view_customer/login";
	}
}