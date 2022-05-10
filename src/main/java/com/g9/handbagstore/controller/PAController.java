package com.g9.handbagstore.controller;

import com.g9.handbagstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pa")
public class PAController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public String showPersonalAreaPage(Model model){
        UserSession.getLoggedUserInfo(userService, model);

        model.addAttribute("pageTitle", "Khu vực cá nhân");
        return "view_customer/pa";
    }
}
