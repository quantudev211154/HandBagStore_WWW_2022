package com.g9.handbagstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.g9.handbagstore.entity.CartDetail;
import com.g9.handbagstore.entity.CartHeader;
import com.g9.handbagstore.entity.User;
import com.g9.handbagstore.service.CartDetailService;
import com.g9.handbagstore.service.CartHeaderService;
import com.g9.handbagstore.service.UserService;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private UserService userService;

    @Autowired
    private CartHeaderService cartHeaderService;

    @Autowired
    private CartDetailService cartDetailService;

    @GetMapping("/all")
    public String showCartPage(Model model){
        UserSession.getLoggedUserInfo(userService, model);

        User currentUser = UserSession.getCurrentUser(userService);

        CartHeader cartHeader = cartHeaderService.getCartHeaderByID(currentUser.getCustomerId());

        List<CartDetail> cartDetailList = cartDetailService.getCartDetailsByCartHeaderID(cartHeader.getId());

        model.addAttribute("cartDetailNum", cartDetailList.size());
        model.addAttribute("cartDetailList", cartDetailList);

        model.addAttribute("cartHeader", cartHeader);

        model.addAttribute("pageTitle", "Giỏ hàng của bạn");
        return "view_customer/cart";
    }
}
