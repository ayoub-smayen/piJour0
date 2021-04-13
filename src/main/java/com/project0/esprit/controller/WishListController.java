package com.project0.esprit.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project0.esprit.service.WishListservice;

@RestController
@RequestMapping("api")
@CrossOrigin("*")
public class WishListController {

	
	@Autowired
	private WishListservice wishser;
	
	
	@GetMapping("/wishlist")
	public @ResponseBody ResponseEntity<?> getAllWishlist(){
		return   ResponseEntity.status(HttpStatus.FOUND).body (wishser.findAllWishlist());
	}
	
	 @PostMapping("/addwishlist")
	public ResponseEntity<?> addWishlist(Principal p2)
	
	{
		 return ResponseEntity.status(HttpStatus.OK).body(wishser.addWishlist(p2));
		 
		 
	}
	 
	 @PutMapping("/affectwishluist/{wishlist_id}/{product_id}")
	 public @ResponseBody ResponseEntity<?> updateWishlist(Principal p2 , @PathVariable("wishlist_id") Long wishlist_id , @PathVariable("product_id") Long product_id ){
		 
		 
		 return ResponseEntity.status(HttpStatus.ACCEPTED).body(wishser.updateWishList(p2, product_id, wishlist_id));
	 }
 }
