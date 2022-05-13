package com.g9.handbagstore.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Base64;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.g9.handbagstore.entity.Bag;
import com.g9.handbagstore.entity.BagCategory;
import com.g9.handbagstore.entity.BagImage;
import com.g9.handbagstore.entity.Brand;
import com.g9.handbagstore.service.BagCategoryService;
import com.g9.handbagstore.service.BagImageService;
import com.g9.handbagstore.service.BagService;
import com.g9.handbagstore.service.BrandService;
import com.g9.handbagstore.service.UserService;

@Controller
@RequestMapping("/admin/products")
public class AdminProductController {

    @Autowired
    private UserService userService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private BagCategoryService bagCategoryService;
    @Autowired
    private BagService bagService;
    @Autowired
    private BagImageService bagImageService;
    
    @Autowired
    private BagCategoryServiceImpl bagCategoryServiceImpl;

    @GetMapping("/all")
    public String showProductsManagersPage(Model model){

        UserSession.getLoggedUserInfo(userService, model);
        List<BagCategory> bagCategorieList = bagCategoryService.getAllBagCategories();
        model.addAttribute("listProducts", bagCategorieList);
        model.addAttribute("pageTitle", "G9 - Quản lí sản phẩm");
        return "/view_admin/products_manager";
    }
    @PostMapping("/save")
    public String addProduct(Model model,
    		@RequestParam("categoryName") String categoryName,
    		@RequestParam("brandName") String brandName,
    		@RequestParam("size") String size,
    		@RequestParam("weight") String weight,
    		@RequestParam("coverPhoto") MultipartFile coverPhoto,
    		@RequestParam("shortDescription") String shortDescription,
    		@RequestParam("longDescription") String longDescription,
    		@RequestParam(required = false, name = "color") String color,
    		@RequestParam(required = false, name = "quantity") String quantity,
    		@RequestParam(required = false, name = "price") String price,
    		@RequestParam(required = false, name = "listImage") ArrayList<MultipartFile> listImage
    		) throws IOException{
    	Brand brand = new Brand(brandName);
    	brandService.addOrUpdateBrand(brand);
    	String imageDataString = Base64.getEncoder().encodeToString(coverPhoto.getBytes());
    	BagCategory bagCategory = new BagCategory(brand, categoryName, size, Integer.parseInt(weight), 
    			imageDataString, shortDescription, longDescription, LocalDate.now());
    	bagCategoryService.addOrUpdateBagCategory(bagCategory);
    	Bag bag = new Bag(bagCategory, color, new BigDecimal(Double.parseDouble(price)), Integer.parseInt(quantity));
    	bagService.addOrUpdateBag(bag);
    	for (MultipartFile m : listImage) {
    		String imageString = Base64.getEncoder().encodeToString(m.getBytes());
			BagImage bagImage = new BagImage(bag, imageString);
			bagImageService.addOrUpdateBagImage(bagImage);
		}
    	
        UserSession.getLoggedUserInfo(userService, model);
        model.addAttribute("pageTitle", "G9 - Quản lí sản phẩm");
        List<BagCategory> bagCategorieList = bagCategoryService.getAllBagCategories();
        model.addAttribute("listProducts", bagCategorieList);
        
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
