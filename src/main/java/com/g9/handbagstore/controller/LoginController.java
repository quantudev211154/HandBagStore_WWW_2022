package com.g9.handbagstore.controller;

import com.g9.handbagstore.config.MyUserDetail;
import com.g9.handbagstore.entity.User;
import com.g9.handbagstore.service.UserService;
import com.g9.handbagstore.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String welcomePage(Model model) {
		UserSession.getLoggedUserInfo(userService, model);

		model.addAttribute("pageTitle", "G9 Bag Store");

		return "view_customer/index";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "view_customer/login";
	}
}