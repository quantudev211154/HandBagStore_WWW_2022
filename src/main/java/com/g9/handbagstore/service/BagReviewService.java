package com.g9.handbagstore.service;

import java.util.List;

import com.g9.handbagstore.entity.BagReview;

public interface BagReviewService {
	List<BagReview> getAllBagReview();
	List<BagReview> getBagReviewsByBagID(int bagID);
	BagReview getBagReviewByID(int bagReviewID);
	void addOrUpdateBagReview(BagReview bagReview);
}
