package com.g9.handbagstore.controller;

import com.g9.handbagstore.entity.User;
import com.g9.handbagstore.service.UserService;
import com.g9.handbagstore.ultility.MyUltility;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

        List<User> users = userService.getAllUsers();
        
        model.addAttribute("pageTitle", "G9 - Quản lí khách hàng");
        addUserGenderAmount(model, users);
        model.addAttribute("users", users);
        model.addAttribute("customerFilterOption", "Tất cả khách hàng");
       
        return "/view_admin/customers_manager";
    }
    
    @GetMapping("/all/gender/{gender}")
    public String showCustomersManagersPageByGender(Model model, @PathVariable String gender){
    	
    	UserSession.getLoggedUserInfo(userService, model);
    	
    	List<User> users = userService.getAllUsers();
    	
    	model.addAttribute("pageTitle", "G9 - Quản lí khách hàng");
    	addUserGenderAmount(model, users);
    	model.addAttribute("users", userService.getUsersByGender(gender));

        if (gender.toLowerCase().equalsIgnoreCase("nam")){
            model.addAttribute("customerFilterOption", "Khách hàng nam");
        }
        else{
            model.addAttribute("customerFilterOption", "Khách hàng nữ");
        }
    	
    	return "/view_admin/customers_manager";
    }
    
    private void addUserGenderAmount(Model model, List<User> users) {
    	List<Integer> userGenderAmount = MyUltility.getUserGenderAmount(users);
    	model.addAttribute("userGenderTotal", userGenderAmount.get(0));
    	model.addAttribute("userGenderMale", userGenderAmount.get(1));
    	model.addAttribute("userGenderFemale", userGenderAmount.get(2));
    }
}