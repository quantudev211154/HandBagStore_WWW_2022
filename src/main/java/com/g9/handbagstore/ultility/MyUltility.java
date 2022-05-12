package com.g9.handbagstore.ultility;

import java.util.ArrayList;
import java.util.List;

import com.g9.handbagstore.entity.SaleOrder;

public class MyUltility {
	public static List<Integer> getOrderStatus(List<SaleOrder> saleOrders) {
		
		List<Integer> orderStatus = new ArrayList<>();
		
		orderStatus.add(0);
		orderStatus.add(0);
		orderStatus.add(0);
		orderStatus.add(0);

		saleOrders.forEach(saleOrder -> {
			int index = saleOrder.getStatus() - 1;
			orderStatus.set(index, orderStatus.get(index) + 1);
		});
		
		return orderStatus;
	}
}