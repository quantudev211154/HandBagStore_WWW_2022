package com.g9.handbagstore.service;

import java.time.LocalDate;
import java.util.List;

import com.g9.handbagstore.entity.BagCategory;

public interface BagCategoryService {
	List<BagCategory> getAllBagCategories();
	BagCategory getBagCategoryByID(int bagCategoryID);
	List<BagCategory> getBagCategoriesByName(String name);
	List<BagCategory> getBagCategoriesLikeName(String name);
	List<BagCategory> getBagCategoriesByImportDate(LocalDate importDate);
}