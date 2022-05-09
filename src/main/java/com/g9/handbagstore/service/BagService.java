package com.g9.handbagstore.service;

import java.math.BigDecimal;
import java.util.List;

import com.g9.handbagstore.entity.Bag;
import com.g9.handbagstore.entity.BagCategory;

public interface BagService {
	List<Bag> getAllBags();
	Bag getBagByID(int bagID);
	void addOrUpdateBag(Bag bag);
	List<Bag> getBagListOfBagCategory(int bagCategoryId);
	BigDecimal getBagPriceByCateID(int cateID);
	List<String> listPrice(List<BagCategory> listBagCategory);
}