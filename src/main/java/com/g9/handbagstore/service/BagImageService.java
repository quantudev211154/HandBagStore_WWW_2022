package com.g9.handbagstore.service;

import java.util.List;

import com.g9.handbagstore.entity.BagImage;

public interface BagImageService {
	List<BagImage> getAllBagImages();
	List<BagImage> getBagImagesByBagID(int bagID);
	BagImage getBagImageByID(int bagImageID);
	void addOrUpdateBagImage(BagImage bagImage);
}
