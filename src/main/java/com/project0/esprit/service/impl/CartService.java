package com.project0.esprit.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project0.esprit.repository.ICartRepository;
import com.project0.esprit.repository.UserRepository;
import com.project0.esprit.service.ICartService;
import com.project0.esprit.datentity.User;
import com.project0.esprit.entity.Cart0;

@Service
public class CartService implements ICartService{
    @Autowired
    ICartRepository  cartRep;
    @Autowired
    UserRepository user;
    
	@Override
	public List<Cart0> retriveAllCart() {
		List<Cart0> cart_list = (List<Cart0>) cartRep.findAll();
		return cart_list;
	}

	 @Transactional
	@Override
	public Cart0 addCart(Cart0 cart,String usern) {
		
		User user0 =user.findByUsernameAndFetchRoles(usern);
		cart.setUser(user0);
		cartRep.save(cart);
		return cart;
	}

	@Override
	public Cart0 updateCart(Cart0 cart) {
		cartRep.save(cart);
		return cart;
	}

	@Override
	public void deleteCart(Long Cart_Id) {
		cartRep.deleteById(Cart_Id);
		
	}

}

