package com.project0.esprit.service;

import java.util.List;

import com.project0.esprit.entity.Cart0;

public interface ICartService {

	List<Cart0> retriveAllCart();
	Cart0 addCart(Cart0 cart,String username);
	Cart0 updateCart(Cart0 cart);
	void deleteCart(Long Cart_Id);
}
