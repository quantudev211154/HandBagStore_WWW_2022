package com.g9.handbagstore.controller;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.g9.handbagstore.entity.User;
import com.g9.handbagstore.service.impl.UserServiceImpl;

@Controller
public class LoginController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@GetMapping("/")
	public String welcomePage(Model model) {
		
		User user = userServiceImpl.getUserByUserName("U01");
		
		if(user != null) {
            String base64Encoded = Base64.getEncoder().encodeToString(user.getAvatar());	
			model.addAttribute("userImg", "data:image/png;base64," + base64Encoded);
		}	
		
		return "view_customer/welcome";
	}
	
//	This one is for login and authen user later on
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
}