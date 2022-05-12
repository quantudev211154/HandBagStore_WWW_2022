package com.g9.handbagstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.g9.handbagstore.entity.User;
import com.g9.handbagstore.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;

	@GetMapping("/all")
	public String showRegisterPage(Model model){
		model.addAttribute("pageTitle", "Đăng kí tài khoản");
		return "view_customer/register";
	}
	
	@PostMapping("/regis")
	public String register(@ModelAttribute User user) {
		
		user.setEmail("");
		user.setGender("Nam");
		user.setAddress("");
		user.setPhone("");
		user.setAvatar("");
		user.setRole("USER");
		
		userServiceImpl.addOrUpdateUser(user);
		
		return "redirect:/login";
	}
}