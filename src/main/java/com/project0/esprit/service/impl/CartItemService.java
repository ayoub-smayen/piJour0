package com.project0.esprit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project0.esprit.repository.ICartItemRepository;
import com.project0.esprit.service.ICartItemService;
import com.project0.esprit.entity.CartItem0;

@Service
public class CartItemService implements ICartItemService{
	
	@Autowired
	ICartItemRepository cartItemRep;

	@Override
	public CartItem0 addCartItem(CartItem0 cartitem) {
		cartItemRep.save(cartitem);
		return cartitem;
	}

	@Override
	public CartItem0 updateCartItem(CartItem0 cartitem) {
		cartItemRep.save(cartitem);
		return cartitem;
	}

	@Override
	public void deleteCartItem(Long Id) {
		
		cartItemRep.deleteById(Id);
	}
	
	@Override
	public List<CartItem0> retriveAll() {
		 List<CartItem0> cartitem_list = (List<CartItem0>) cartItemRep.findAll();
				 return cartitem_list;
}

}