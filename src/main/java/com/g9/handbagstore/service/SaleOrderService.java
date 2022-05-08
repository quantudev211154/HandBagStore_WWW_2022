package com.g9.handbagstore.service;

import com.g9.handbagstore.entity.SaleOrder;

import java.util.List;

public interface SaleOrderService {
	List<SaleOrder> getAllSaleOrder();
	List<SaleOrder> getSaleOrdersByCustomerID(int customerID);
	SaleOrder getSaleOrderBySaleOrderID(String saleOrderID);
	void addOrUpdateSaleOrder(SaleOrder saleOrder);
}