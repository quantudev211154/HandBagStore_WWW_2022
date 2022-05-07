package com.g9.handbagstore.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.g9.handbagstore.entity.BagCategory;

public interface BagCategoryRepository extends JpaRepository<BagCategory, Integer>{
//	@Query("from BagCatogory where name = :name")
//	List<BagCategory> getBagCategoriesByName(@Param("name") String name);
//	
//	@Query("from BagCatogory where import_date = :importDate")
//	List<BagCategory> getBagCategoriesByImportDate(@Param("importDate") LocalDate importDate);
}