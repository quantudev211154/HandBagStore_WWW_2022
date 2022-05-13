package com.g9.handbagstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.g9.handbagstore.entity.User;
import com.g9.handbagstore.service.UserService;
import com.g9.handbagstore.ultility.MyUltility;

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
        addUserGenderAmount(model, listUsers);
       
        return "/view_admin/customers_manager";
    }
    
    private void addUserGenderAmount(Model model, List<User> users) {
    	List<Integer> userGenderAmount = MyUltility.getUserGenderAmount(users);
    	model.addAttribute("userGenderTotal", userGenderAmount.get(0));
    	model.addAttribute("userGenderMale", userGenderAmount.get(1));
    	model.addAttribute("userGenderFemale", userGenderAmount.get(2));
    }
    @GetMapping("/male")
    public String showMaleCustomers(Model model){

        UserSession.getLoggedUserInfo(userService, model);
        
        List<User> listUsers = userService.getUsersByGender("USER", "Nam");
        model.addAttribute("listUsers", listUsers);
        addUserGenderAmount(model, listUsers);
        model.addAttribute("pageTitle", "G9 - Quản lí khách hàng");
        return "/view_admin/customers_manager";
    }
    @GetMapping("/female")
    public String showFemaleCustomers(Model model){

        UserSession.getLoggedUserInfo(userService, model);
        
        List<User> listUsers = userService.getUsersByGender("USER", "Nữ");
        model.addAttribute("listUsers", listUsers);
        addUserGenderAmount(model, listUsers);
        model.addAttribute("pageTitle", "G9 - Quản lí khách hàng");
        return "/view_admin/customers_manager";
    }
}
