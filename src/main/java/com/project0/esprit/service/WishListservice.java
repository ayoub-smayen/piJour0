package com.project0.esprit.service;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project0.esprit.datentity.User;
import com.project0.esprit.datentity.WishList;
import com.project0.esprit.entity.Product1;
import com.project0.esprit.repository.ProductRepository;
import com.project0.esprit.repository.UserRepository;
import com.project0.esprit.repository.WishListRepository;

@Service
public class WishListservice {
	
	@Autowired
	private WishListRepository wishlistrepo;
	
	@Autowired
	private UserRepository userrepo ;
	
	
	@Autowired
	private  WishListRepository wishrepo ;
	
	
	@Autowired
	private ProductRepository preodrep;
	
	
	public WishList addWishlist(Principal p1) {
		
		Map<String, Product1> m1 =new HashMap<String, Product1>();
		
		 User u  = userrepo.findOneByUsername(p1.getName());
		 
		
		 WishList wish = new WishList();
		 
		 wish.setUser(u);
		 wish.setWishlist_body(u.getUsername() + "wish");
		 wish.setWishlist_title("title" + u.getUsername());
		 
		return  wishrepo.save(wish);
		 
		 
		 
	}
	
	public List<WishList> findAllWishlist(){
		
		return  wishrepo.findAll();
	}
	
	public Product1 updateWishList(Principal p1 ,Long wishlist_id, Long product_id) {
		   
		   Product1 p2 = preodrep.findById(product_id).get();
		   WishList w = wishrepo.findById(wishlist_id).get();
		   
		   User u  = userrepo.findOneByUsername(p1.getName());
		   
		   w.setId(w.getId());
		   
		  p2.setWishlist(w);
		  return preodrep.save(p2);
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		
		
		 
	}
	
	
	
	

}
