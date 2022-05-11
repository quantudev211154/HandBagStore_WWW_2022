package com.g9.handbagstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminLoginController {

    @GetMapping("/login")
    public String loginWithAdminAccount(){
        return "view_admin/login";
    }

    @GetMapping("/welcome")
    public String loginSuccessfully(){
        return "/view_admin/index";
    }
}
