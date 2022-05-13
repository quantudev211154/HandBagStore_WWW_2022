package com.g9.handbagstore.service;

import java.time.LocalDate;
import java.util.List;

import com.g9.handbagstore.entity.BagCategory;

public interface BagCategoryService {
	List<BagCategory> getAllBagCategories();
	BagCategory getBagCategoryByID(int bagCategoryID);
	void addOrUpdateBagCategory(BagCategory bagCategory);
	List<BagCategory> getBagCategoriesByName(String name);
	List<BagCategory> getBagCategoriesLikeName(String name);
	List<BagCategory> getBagCategoriesByImportDate(LocalDate importDate);
	List<BagCategory> getBagCategoriesOrderByNameFromA2Z();
	List<BagCategory> getBagCategoriesOrderByNameFromZ2A();
	List<BagCategory> getBagCategoriesOrderByPriceAsc();
	List<BagCategory> getBagCategoriesOrderByPriceDesc();
	List<BagCategory> getBagCategoriesByNewestDate();
}