package com.g9.handbagstore.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g9.handbagstore.entity.BagReview;
import com.g9.handbagstore.repository.BagReviewRepository;
import com.g9.handbagstore.service.BagReviewService;

@Service
public class BagReviewServiceImpl implements BagReviewService {

	@Autowired
	private BagReviewRepository bagReviewRepo;
	
	@Override
	public List<BagReview> getAllBagReview() {
		return bagReviewRepo.findAll();
	}

	@Override
	public List<BagReview> getBagReviewsByBagID(int bagID) {
		return bagReviewRepo.getBagReviewsByBagID(bagID);
	}

	@Override
	public BagReview getBagReviewByID(int bagReviewID) {
		Optional<BagReview> result = bagReviewRepo.findById(bagReviewID);
		BagReview bagReview = null;
		if(result.isPresent()) {
			bagReview = result.get();
		} else {
			throw new RuntimeException("Did not find bag review id - " + bagReviewID);
		}
		return bagReview;
	}

	@Override
	public void addOrUpdateBagReview(BagReview bagReview) {
		bagReviewRepo.save(bagReview);
	}

}
