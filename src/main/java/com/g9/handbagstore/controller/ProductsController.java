package com.g9.handbagstore.controller;

import com.g9.handbagstore.config.MyUserDetail;
import com.g9.handbagstore.entity.BagCategory;
import com.g9.handbagstore.entity.User;
import com.g9.handbagstore.service.BagCategoryService;
import com.g9.handbagstore.service.UserService;
import com.g9.handbagstore.service.impl.BagCategoryServiceImpl;
import com.g9.handbagstore.service.impl.BagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    private UserService userService;

    @Autowired
    private BagCategoryService bagCategoryService;

    @GetMapping("/all")
    public String showAllProducts(Model model){
        UserSession.getLoggedUserInfo(userService, model);

        List<BagCategory> listBagCategory = bagCategoryService.getAllBagCategories();
        //Cần viết 1 hàm lấy giá tiền ứng với từng category của listBagCategory phía trên
        //public List<String> listPrice(List<BagCategory> listBagCategory) -- order by price desc

        model.addAttribute("resultSize", listBagCategory.size());
        model.addAttribute("pageTitle", "Tất cả sản phẩm");
        model.addAttribute("listProducts", listBagCategory);

        return "/view_customer/all_products";
    }

    @GetMapping("/newest")
    public String showNewestProducts(Model model){

        return "view_customer/all_products";
    }


    @GetMapping("/{categoryId}")
    public String showProductDetail(@PathVariable int categoryId, Model model){
        BagCategory bagCategory = bagCategoryService.getBagCategoryByID(categoryId);

        System.out.println(bagCategory);

        model.addAttribute("bagCategory", bagCategory);
        model.addAttribute("pageTitle", bagCategory.getName());

        return "view_customer/product_detail";
    }
}
