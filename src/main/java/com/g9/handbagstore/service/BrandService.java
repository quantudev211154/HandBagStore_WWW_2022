package com.g9.handbagstore.service;

import java.util.List;

import com.g9.handbagstore.entity.Brand;

public interface BrandService {
	List<Brand> getAllBrand();
	Brand getBrandByBrandID(int brandID);
	void addOrUpdateBrand(Brand brand);
}
