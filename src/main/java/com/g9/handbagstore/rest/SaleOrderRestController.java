package com.g9.handbagstore.rest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g9.handbagstore.entity.SaleOrder;
import com.g9.handbagstore.service.SaleOrderService;

@RestController
@RequestMapping("/api")
public class SaleOrderRestController {
	@Autowired
	private SaleOrderService saleOrderService;
	@GetMapping("/saleOrders/today")
	public List<SaleOrder> getSaleOrdersToday() {
		Date date = new Date();
		return saleOrderService.getSaleOrderToday(date.getDate(), date.getMonth() + 1, date.getYear() + 1900);
	}
	@GetMapping("/saleOrders/week")
	public List<SaleOrder> getSaleOrdersThisWeek() {
		return saleOrderService.getAllSaleOrder();
	}
	@GetMapping("/saleOrders/month")
	public List<SaleOrder> getSaleOrdersThisMonth() {
		Date date = new Date();
		return saleOrderService.getSaleOrderThisMonth(date.getMonth() + 1, date.getYear() + 1900);
	}
}
