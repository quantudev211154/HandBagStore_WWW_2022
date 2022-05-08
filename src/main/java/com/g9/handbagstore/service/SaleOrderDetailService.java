package com.g9.handbagstore.service;

import java.util.List;

import com.g9.handbagstore.entity.SaleOrderDetail;

public interface SaleOrderDetailService {
	List<SaleOrderDetail> getAllSaleOrderDetail();
	List<SaleOrderDetail> getSaleOrderDetailsBySaleOrderID(int saleOrderID);
	List<SaleOrderDetail> getSaleOrderDetailsByBagID(int bagID);
	SaleOrderDetail getSaleOrderDetailBySaleOrderIdAndBagId(int saleOrderID, int bagID);
	void addOrUpdateSaleOrderDetail(SaleOrderDetail saleOrderDetail);
}
