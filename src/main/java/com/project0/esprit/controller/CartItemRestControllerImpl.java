package com.project0.esprit.controller;


/*
 * 
 * 
 * aziz  crud and  fonctionalité   cartitem0
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project0.esprit.service.ICartItemService;

import com.project0.esprit.entity.CartItem0;

@RestController
@RequestMapping(path="/api")
public class CartItemRestControllerImpl {

	
	@Autowired
	ICartItemService cartItemServ;
	
	
	@GetMapping("/retreve_all_cartItems")
	@ResponseBody
	public List<CartItem0> getCartItems(){
		List<CartItem0> cartList = cartItemServ.retriveAll();
		return cartList;	
				}
	
	@PostMapping("/add_cartItem")
	@ResponseBody
	public CartItem0 addCertItem(@RequestBody CartItem0 c){
		CartItem0 cartitem = cartItemServ.addCartItem(c);
		return cartitem;
	}
	
	@DeleteMapping("/delete_CartItem/{id}")
	public void deleteCartItem(@PathVariable("id") Long id){
		cartItemServ.deleteCartItem(id);
	}
	
	@PutMapping("/update_cartItem")
	@ResponseBody
	public CartItem0 updateCertItem(@RequestBody CartItem0 c){
		CartItem0 cartitem = cartItemServ.updateCartItem(c);
		return cartitem;
	}
	
}
