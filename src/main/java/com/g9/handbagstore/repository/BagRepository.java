package com.g9.handbagstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.g9.handbagstore.entity.Bag;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BagRepository extends JpaRepository<Bag, Integer>{
    @Query("from Bag where bagCategory.bagCategoryId = :bagCategoryId")
    List<Bag> findBagsListByBagCategoryId(@Param("bagCategoryId") int bagCategoryId);
}