package com.g9.handbagstore.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.g9.handbagstore.entity.CartHeader;
import com.g9.handbagstore.repository.CartHeaderRepository;
import com.g9.handbagstore.service.CartHeaderService;

public class CartHeaderServiceImpl implements CartHeaderService {

	@Autowired
	private CartHeaderRepository cartHeaderRepo;
	
	@Override
	public List<CartHeader> getAllCartHeader() {
		return cartHeaderRepo.findAll();
	}

	@Override
	public CartHeader getCartHeaderByID(int cartHeaderID) {
		Optional<CartHeader> result = cartHeaderRepo.findById(cartHeaderID);
		CartHeader cartHeader = null;
		if(result.isPresent()) {
			cartHeader = result.get();
		} else {
			throw new RuntimeException("Did not find cart header id - " + cartHeaderID);
		}
		return cartHeader;
	}

	@Override
	public void addOrUpdateCartHeader(CartHeader cartHeader) {
		cartHeaderRepo.save(cartHeader);
	}

}
