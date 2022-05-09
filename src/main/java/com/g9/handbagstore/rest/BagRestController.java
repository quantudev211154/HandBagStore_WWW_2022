package com.g9.handbagstore.rest;

import java.util.List;

import com.g9.handbagstore.service.BagCategoryService;
import com.g9.handbagstore.service.BagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g9.handbagstore.entity.Bag;
import com.g9.handbagstore.entity.BagCategory;

@RestController
@RequestMapping("/api")
public class BagRestController {
	@Autowired
	private BagService bagService;
	
	@Autowired
	private BagCategoryService bagCategoryService;
	
	@GetMapping("/bags")
	public List<Bag> getBags() {
		return bagService.getAllBags();
	}
	
	@GetMapping("/bags/{cate_name}")
	public List<BagCategory> getBagsByCateName(@PathVariable String cate_name) {
		return bagCategoryService.getBagCategoriesByName(cate_name);
	}
	
	@GetMapping("/bags/search/{name}")
	public List<BagCategory> getBagsLikeCateName(@PathVariable String name) {
		return bagCategoryService.getBagCategoriesLikeName(name);
	}

	@GetMapping("/bags/bagCategory={bagCategoryId}")
	public List<Bag> findBagsListByBagCategoryId(@PathVariable int bagCategoryId){
		return bagService.getBagListOfBagCategory(bagCategoryId);
	}
}