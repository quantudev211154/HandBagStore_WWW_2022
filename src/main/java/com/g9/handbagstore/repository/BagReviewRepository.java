package com.g9.handbagstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.g9.handbagstore.entity.BagReview;

public interface BagReviewRepository extends JpaRepository<BagReview, Integer> {
	@Query("from BagReview where bag_id = :bagID")
	List<BagReview> getBagReviewsByBagID(@Param("bagID") int bagID);
}
