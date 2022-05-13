package com.g9.handbagstore.controller;

import com.g9.handbagstore.entity.User;
import com.g9.handbagstore.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/customers")
public class AdminCustomerController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public String showCustomersManagersPage(Model model){

        UserSession.getLoggedUserInfo(userService, model);
        
        List<User> listUsers = userService.getUsersByRole("USER");
        model.addAttribute("listUsers", listUsers);

        model.addAttribute("pageTitle", "G9 - Quản lí khách hàng");
        return "/view_admin/customers_manager";
    }
}
