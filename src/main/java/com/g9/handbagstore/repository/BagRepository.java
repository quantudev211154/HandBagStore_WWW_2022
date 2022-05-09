package com.g9.handbagstore.repository;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.g9.handbagstore.entity.Bag;

public interface BagRepository extends JpaRepository<Bag, Integer>{
    @Query("from Bag where bagCategory.bagCategoryId = :bagCategoryId")
    List<Bag> findBagsListByBagCategoryId(@Param("bagCategoryId") int bagCategoryId);
  
	@Query(value = "select top 1 price from bags where bag_category_id = :cateID "
			+ "order by price desc", nativeQuery = true)
	BigDecimal getBagPriceByCateID(@Param("cateID") int cateID);
	
	@Query(value = "select bag_category_id from bags order by price asc", nativeQuery = true)
	LinkedHashSet<Integer> getBagCategoryIdOrderByPriceAsc();
	
	@Query(value = "select bag_category_id from bags order by price desc", nativeQuery = true)
	LinkedHashSet<Integer> getBagCategoryIdOrderByPriceDesc();
}