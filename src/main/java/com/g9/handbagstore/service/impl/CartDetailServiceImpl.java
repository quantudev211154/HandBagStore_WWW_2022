package com.g9.handbagstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g9.handbagstore.entity.CartDetail;
import com.g9.handbagstore.repository.CartDetailRepository;
import com.g9.handbagstore.service.CartDetailService;

@Service
public class CartDetailServiceImpl implements CartDetailService {
	
	@Autowired
	private CartDetailRepository cartDetailRepository;

	@Override
	public List<CartDetail> getAllCartDetail() {
		return cartDetailRepository.findAll();
	}

	@Override
	public List<CartDetail> getCartDetailsByCartHeaderID(int cartID) {
		return cartDetailRepository.getCartDetailsByCartHeaderID(cartID);
	}

	@Override
	public List<CartDetail> getCartDetailsByBagID(int bagID) {
		return cartDetailRepository.getCartDetailsByBagID(bagID);
	}

	@Override
	public CartDetail getCartDetailByCartHeaderIdAndBagId(int cartID, int bagID) {
		return cartDetailRepository.getCartDetailByCartHeaderIdAndBagId(cartID, bagID);
	}

	@Override
	public void addOrUpdateCartDetail(CartDetail cartDetail) {
		cartDetailRepository.save(cartDetail);
	}

	@Override
	public void deleteCartDetailByCartHeaderId(int cartID) {
		cartDetailRepository.deleteCartDetailByCartHeaderId(cartID);
	}

	@Override
	public void deleteCartDetailByCartHeaderIdAndBagId(int cartID, int bagID) {
		cartDetailRepository.deleteCartDetailByCartHeaderIdAndBagId(cartID, bagID);
	}
	
}
