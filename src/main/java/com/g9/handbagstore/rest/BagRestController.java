package com.g9.handbagstore.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g9.handbagstore.entity.Bag;
import com.g9.handbagstore.entity.BagCategory;
import com.g9.handbagstore.service.impl.BagCategoryServiceImpl;
import com.g9.handbagstore.service.impl.BagServiceImpl;

@RestController
@RequestMapping("/api")
public class BagRestController {
	@Autowired
	private BagServiceImpl bagServiceImpl;
	
	@Autowired
	private BagCategoryServiceImpl bagCategoryServiceImpl;
	
	@GetMapping("/bags")
	public List<Bag> getBags() {
		return bagServiceImpl.getAllBags();
	}
	
	@GetMapping("/bags/{cate_name}")
	public List<BagCategory> getBagsByCateName(@PathVariable String cate_name) {
		return bagCategoryServiceImpl.getBagCategoriesByName(cate_name);
	}
	
	@GetMapping("/bags/search/{name}")
	public List<BagCategory> getBagsLikeCateName(@PathVariable String name) {
		return bagCategoryServiceImpl.getBagCategoriesLikeName(name);
	}
}