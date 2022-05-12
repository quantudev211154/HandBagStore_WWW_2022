package com.g9.handbagstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.g9.handbagstore.entity.SaleOrder;

public interface SaleOrderRepository extends JpaRepository<SaleOrder, Integer> {
	@Query("from SaleOrder where customer_id = :customerID")
	List<SaleOrder> getSaleOrdersByCustomerID(@Param("customerID") int customerID);
	
	@Query("from SaleOrder where sale_order_id = :saleOrderID")
	SaleOrder getSaleOrderBySaleOrderID(@Param("saleOrderID") int saleOrderID);
	
	@Query("from SaleOrder where status = :status_value")
	List<SaleOrder> getSaleOrderByStatus(@Param("status_value") short status);
	
	@Query("from SaleOrder where DAY(s.order_date) = :day AND MONTH(order_date) = :month AND YEAR(order_date) = :year")
	List<SaleOrder> getSaleOrderToday(@Param("day") int day, @Param("month") int month, @Param("year") int year);
	
	@Query("from SaleOrder where MONTH(order_date) = :month AND YEAR(order_date) = :year")
	List<SaleOrder> getSaleOrderThisMonth(@Param("month") int month, @Param("year") int year);
}