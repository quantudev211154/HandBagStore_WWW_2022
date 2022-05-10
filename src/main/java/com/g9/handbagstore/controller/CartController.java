package com.g9.handbagstore.controller;

import com.g9.handbagstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public String showCartPage(Model model){

        model.addAttribute("pageTitle", "Giỏ hàng của bạn");
        return "view_customer/cart";
    }
}
