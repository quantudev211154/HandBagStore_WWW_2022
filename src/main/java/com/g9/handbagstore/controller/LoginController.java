package com.g9.handbagstore.controller;

import com.g9.handbagstore.config.MyUserDetail;
import com.g9.handbagstore.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@Autowired
	private UserServiceImpl userService;
	
	@GetMapping("/welcome")
	public String welcomePage(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof MyUserDetail){
			String username = ((MyUserDetail) principal).getUsername();

			String avatar = userService.getUserByUserName(username).getAvatar();

			if (!avatar.isEmpty()){
				model.addAttribute("userAvatar", "data:image/png;base64," + avatar);
			}
		}

		model.addAttribute("pageTitle", "G9 Bag Store");

		return "view_customer/index";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "view_customer/login";
	}
}