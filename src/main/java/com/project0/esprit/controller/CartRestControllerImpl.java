package com.project0.esprit.controller;
/*
 * 
 * aziz  crud  cart  and fonctionalité
 */
import java.security.Principal;
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

import com.project0.esprit.service.ICartService;
import com.project0.esprit.entity.Cart0;


@RestController
@RequestMapping(path="/api")
public class CartRestControllerImpl {
	@Autowired
	ICartService cartServ;
	
	
	@GetMapping("/retreve_all_cart")
	@ResponseBody
	public List<Cart0> getCarts(){
		List<Cart0> cartList = cartServ.retriveAllCart();
		return cartList;	
				}
	
	@PostMapping("/add_cart")
	@ResponseBody
	public Cart0 addCart(@RequestBody Cart0 c,Principal p){
		Cart0 cart = cartServ.addCart(c,p.getName());
		return cart;
	}
	
	@DeleteMapping("/delete_Cart/{id}")
	public void deleteCartItem(@PathVariable("id") Long id){
		cartServ.deleteCart(id);
	}
	
	@PutMapping("/update_cart")
	@ResponseBody
	public Cart0 updateCart(@RequestBody Cart0 c){
		Cart0 cart = cartServ.updateCart(c);
		return cart;
	}
	
}

