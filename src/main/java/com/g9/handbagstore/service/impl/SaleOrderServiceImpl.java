package com.g9.handbagstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g9.handbagstore.entity.SaleOrder;
import com.g9.handbagstore.repository.SaleOrderRepository;
import com.g9.handbagstore.service.SaleOrderService;

@Service
public class SaleOrderServiceImpl implements SaleOrderService {

	@Autowired
	private SaleOrderRepository saleOrderRepo;
	
	@Override
	public List<SaleOrder> getAllSaleOrder() {
		return saleOrderRepo.findAll();
	}

	@Override
	public List<SaleOrder> getSaleOrdersByCustomerID(String customerID) {
		return saleOrderRepo.getSaleOrdersByCustomerID(customerID);
	}

	@Override
	public SaleOrder getSaleOrderBySaleOrderID(String saleOrderID) {
		return saleOrderRepo.getSaleOrderBySaleOrderID(saleOrderID);
	}

	@Override
	public void addOrUpdateSaleOrder(SaleOrder saleOrder) {
		saleOrderRepo.save(saleOrder);
	}
}