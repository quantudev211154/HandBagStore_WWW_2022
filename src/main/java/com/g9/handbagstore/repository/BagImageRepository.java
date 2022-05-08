package com.g9.handbagstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.g9.handbagstore.entity.BagImage;

public interface BagImageRepository extends JpaRepository<BagImage, Integer> {
	@Query("from BagImage where bag_id = :bagID")
	List<BagImage> getBagImagesByBagID(@Param("bagID") int bagID);
}
