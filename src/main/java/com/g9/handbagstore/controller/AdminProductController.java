package com.g9.handbagstore.controller;

import com.g9.handbagstore.entity.Bag;
import com.g9.handbagstore.entity.BagCategory;
import com.g9.handbagstore.entity.SaleOrder;
import com.g9.handbagstore.service.UserService;
import com.g9.handbagstore.service.impl.BagCategoryServiceImpl;
import com.g9.handbagstore.ultility.MyUltility;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/products")
public class AdminProductController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private BagCategoryServiceImpl bagCategoryServiceImpl;

    @GetMapping("/all")
    public String showProductsManagersPage(Model model){

        UserSession.getLoggedUserInfo(userService, model);

        model.addAttribute("pageTitle", "G9 - Quản lí sản phẩm");
        
        List<BagCategory> bagCategories = bagCategoryServiceImpl.getAllBagCategories();
        addBagCateAmount(model, bagCategories);
        model.addAttribute("bagCates", bagCategories);
        
        return "/view_admin/products_manager";
    }
    
    private void addBagCateAmount(Model model, List<BagCategory> bagCategories) {
    	 
		List<Integer> bagCateAmount = MyUltility.getBagCateAmount(bagCategories);

		model.addAttribute("bagCateTotalCate", bagCateAmount.get(0));
		model.addAttribute("bagCateTotal", bagCateAmount.get(1));
		model.addAttribute("bagCateInStock", bagCateAmount.get(2));
		model.addAttribute("bagCateOutOfStock", bagCateAmount.get(3)); 
	}
}
