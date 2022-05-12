package com.g9.handbagstore.service;

import java.util.List;

import com.g9.handbagstore.entity.CartDetail;
import com.g9.handbagstore.entity.CartHeader;

public interface CartHeaderService {
	List<CartHeader> getAllCartHeader();
	CartHeader getCartHeaderByID(int cartHeaderID);
	void addOrUpdateCartHeader(CartHeader cartHeader);
	void updateCartTotalPriceAndQuantity(int userID, List<CartDetail> cartDetails);
}