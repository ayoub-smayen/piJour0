package com.project0.esprit.service;

import java.util.List;

import com.project0.esprit.entity.CartItem0;

public interface ICartItemService {
	
	List<CartItem0> retriveAll();
	CartItem0 addCartItem(CartItem0 cartitem);
	CartItem0 updateCartItem(CartItem0 cartitem);
	void deleteCartItem(Long Id);

}