package com.g9.handbagstore.service;

import java.util.List;

import com.g9.handbagstore.entity.Bag;

public interface BagService {
	List<Bag> getAllBags();
	Bag getBagByID(int bagID);
	void addOrUpdateBag(Bag bag);
	List<Bag> getBagListOfBagCategory(int bagCategoryId);
}