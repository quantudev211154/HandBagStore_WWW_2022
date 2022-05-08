package com.g9.handbagstore.repository;

import java.util.List;

import com.g9.handbagstore.entity.SaleOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SaleOrderRepository extends JpaRepository<SaleOrder, Integer> {
	@Query("from SaleOrder where customer_id = :customerID")
	List<SaleOrder> getSaleOrdersByCustomerID(@Param("customerID") int customerID);
	
	@Query("from SaleOrder where sale_order_id = :saleOrderID")
	SaleOrder getSaleOrderBySaleOrderID(@Param("saleOrderID") String saleOrderID);
}