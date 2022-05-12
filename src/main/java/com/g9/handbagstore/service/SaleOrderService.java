package com.g9.handbagstore.service;

import java.util.List;

import com.g9.handbagstore.entity.SaleOrder;

public interface SaleOrderService {
	List<SaleOrder> getAllSaleOrder();
	List<SaleOrder> getSaleOrdersByCustomerID(int customerID);
	SaleOrder getSaleOrderBySaleOrderID(int saleOrderID);
	void addOrUpdateSaleOrder(SaleOrder saleOrder);
}