package com.g9.handbagstore.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g9.handbagstore.entity.BagImage;
import com.g9.handbagstore.repository.BagImageRepository;
import com.g9.handbagstore.service.BagImageService;

@Service
public class BagImageServiceImpl implements BagImageService {

	@Autowired
	private BagImageRepository bagImageRepo;
	
	@Override
	public List<BagImage> getAllBagImages() {
		return bagImageRepo.findAll();
	}

	@Override
	public List<BagImage> getBagImagesByBagID(int bagID) {
		return bagImageRepo.getBagImagesByBagID(bagID);
	}

	@Override
	public BagImage getBagImageByID(int bagImageID) {
		Optional<BagImage> result = bagImageRepo.findById(bagImageID);
		BagImage bagImage = null;
		if(result.isPresent()) {
			bagImage = result.get();
		} else {
			throw new RuntimeException("Did not find bag image id - " + bagImageID);
		}
		return bagImage;
	}

	@Override
	public void addOrUpdateBagImage(BagImage bagImage) {
		bagImageRepo.save(bagImage);
	}
}
