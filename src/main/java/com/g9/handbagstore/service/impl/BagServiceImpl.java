package com.g9.handbagstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g9.handbagstore.entity.Bag;
import com.g9.handbagstore.repository.BagRepository;
import com.g9.handbagstore.service.BagService;

@Service
public class BagServiceImpl implements BagService {

	@Autowired
	private BagRepository bagRepo;
	
	@Override
	public List<Bag> getAllBags() {
		return bagRepo.findAll();
	}

	@Override
	public Bag getBagByID(int bagID) {
		return bagRepo.findById(bagID).get();
	}

	@Override
	public void addOrUpdateBag(Bag bag) {
		bagRepo.save(bag);
	}
}