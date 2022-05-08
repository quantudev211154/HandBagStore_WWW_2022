package com.g9.handbagstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/welcome")
	public String welcomePage(Model model) {
		return "view_customer/index";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "view_customer/login";
	}
}