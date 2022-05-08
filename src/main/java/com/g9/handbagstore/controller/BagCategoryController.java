package com.g9.handbagstore.controller;

import com.g9.handbagstore.entity.BagCategory;
import com.g9.handbagstore.service.BagCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bagCategory")
public class BagCategoryController {
    @Autowired
    private BagCategoryService bagCategoryService;

    @GetMapping("/bagCategoryDetail/{categoryId}")
    public String showProductDetail(@PathVariable int categoryId, Model model){
        BagCategory bagCategory = bagCategoryService.getBagCategoryByID(categoryId);

        System.out.println(bagCategory);

        model.addAttribute("bagCategory", bagCategory);
        model.addAttribute("pageTitle", bagCategory.getName());

        return "view_customer/product_detail";
    }
}
