package com.project0.esprit.service;

import com.project0.esprit.model.*;;

public interface CartService {

	Long save(Cart cart);
	void add(Long idCart, Long idProduct, Integer quantity);
	Long ordered(Long idCart);

}
