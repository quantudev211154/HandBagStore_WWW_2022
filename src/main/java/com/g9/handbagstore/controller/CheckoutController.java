package com.g9.handbagstore.controller;

import com.g9.handbagstore.entity.CartDetail;
import com.g9.handbagstore.entity.CartHeader;
import com.g9.handbagstore.entity.User;
import com.g9.handbagstore.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {
    @Autowired
    private UserService userService;

    @Autowired
    private CartHeaderService cartHeaderService;

    @Autowired
    private CartDetailService cartDetailService;

    @Autowired
    private SaleOrderService saleOrderService;

    @Autowired
    private SaleOrderDetailService saleOrderDetailService;

    @GetMapping("/all")
    public String showCheckoutPage(Model model){
        User currentUser = UserSession.getCurrentUser(userService);

        UserSession.getLoggedUserInfo(userService, model);

        CartHeader cartHeader = cartHeaderService.getCartHeaderByID(currentUser.getCustomerId());

        List<CartDetail> cartDetailList = cartDetailService.getCartDetailsByCartHeaderID(cartHeader.getId());

        model.addAttribute("user", currentUser);
        model.addAttribute("cartDetailList", cartDetailList);
        model.addAttribute("cartHeader", cartHeader);
        model.addAttribute("pageTitle", "Thanh toán");

        return "view_customer/checkout";
    }
}
