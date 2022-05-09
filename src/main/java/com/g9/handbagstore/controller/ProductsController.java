package com.g9.handbagstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.g9.handbagstore.entity.BagCategory;
import com.g9.handbagstore.service.BagCategoryService;
import com.g9.handbagstore.service.UserService;
import com.g9.handbagstore.service.impl.BagServiceImpl;

@Controller
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    private UserService userService;

    @Autowired
    private BagServiceImpl bagServiceImpl;
    
    @Autowired
    private BagCategoryService bagCategoryService;
    

    @GetMapping("/all")
    public String showAllProducts(Model model){
        UserSession.getLoggedUserInfo(userService, model);

        List<BagCategory> listBagCategory = bagCategoryService.getAllBagCategories();

//      get lowest price of each bag category base on its id  
        List<String> bagCatePriceList = bagServiceImpl.listPrice(listBagCategory);
        
        model.addAttribute("resultSize", listBagCategory.size());
        model.addAttribute("pageTitle", "Tất cả sản phẩm");
        model.addAttribute("listProducts", listBagCategory);

        return "/view_customer/all_products";
    }

    @GetMapping("/newest")
    public String showNewestProducts(Model model){

        return "view_customer/all_products";
    }


    @GetMapping("/product/{categoryId}")
    public String showProductDetail(@PathVariable("categoryId") int categoryId, Model model){
        UserSession.getLoggedUserInfo(userService, model);

        BagCategory bagCategory = bagCategoryService.getBagCategoryByID(categoryId);

        model.addAttribute("bagCategory", bagCategory);
        model.addAttribute("pageTitle", bagCategory.getName());

        return "/view_customer/product_detail";
    }


}
