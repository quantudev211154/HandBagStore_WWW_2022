package com.g9.handbagstore.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g9.handbagstore.entity.BagCategory;
import com.g9.handbagstore.repository.BagCategoryRepository;
import com.g9.handbagstore.service.BagCategoryService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BagCategoryServiceImpl implements BagCategoryService {

	@Autowired
	private BagCategoryRepository bagCategoryRepo;

	@Override
	public List<BagCategory> getAllBagCategories() {
		return bagCategoryRepo.findAll();
	}

	@Override
	public BagCategory getBagCategoryByID(int bagCategoryID) {
		return bagCategoryRepo.findById(bagCategoryID).get();
	}

	@Override
	public List<BagCategory> getBagCategoriesByName(String name) {
		return bagCategoryRepo.getBagCategoriesByName(name);
	}

	@Override
	public List<BagCategory> getBagCategoriesByImportDate(LocalDate importDate) {
		return bagCategoryRepo.getBagCategoriesByImportDate(importDate);
	}

	@Override
	public List<BagCategory> getBagCategoriesLikeName(String name) {
		return bagCategoryRepo.getBagCategoriesLikeName("%" + name + "%");
	}
}