package com.g9.handbagstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.g9.handbagstore.entity.SaleOrderDetail;

public interface SaleOrderDetailRepository extends JpaRepository<SaleOrderDetail, Integer> {
	@Query("from SaleOrderDetail where sale_order_id = :saleOrderID")
	List<SaleOrderDetail> getSaleOrderDetailsBySaleOrderID(@Param("saleOrderID") int saleOrderID);
	@Query("from SaleOrderDetail where bag_id = :bagID")
	List<SaleOrderDetail> getSaleOrderDetailsByBagID(@Param("bagID") int bagID);
	@Query("from SaleOrderDetail where sale_order_id = :saleOrderID AND bag_id = :bagID")
	SaleOrderDetail getSaleOrderDetailBySaleOrderIdAndBagId(@Param("saleOrderID") int saleOrderID, @Param("bagID") int bagID);
}
