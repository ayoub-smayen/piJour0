package com.project0.esprit.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project0.esprit.datentity.Favourite;
import com.project0.esprit.datentity.User;
import com.project0.esprit.entity.Product1;
import com.project0.esprit.repository.FavouriteRepository;
import com.project0.esprit.repository.ProductRepository;
import com.project0.esprit.repository.UserRepository;

@CrossOrigin("*")
@RequestMapping("api")
@RestController

public class FavouriteController {
 
	
	@Autowired
	private FavouriteRepository favrepo ;
	
	@Autowired
	private ProductRepository prodrep;
	
	
	 @Autowired
	 UserRepository userRepository;
	
	@GetMapping("/favourite")
	public ResponseEntity<?> getfavourit(Principal p ) {
		
		try {
		User u = userRepository.findByUsernameAndFetchRoles(p.getName());
		System.out.println(u.getId());
	
		
		//if(!u.getFavourite().getProducts().equals(null))
			return ResponseEntity.status(HttpStatus.FOUND).body(u.getFavourite());
		
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.FOUND).body("no favourite" + ex.getMessage());	
		}
		
		
	}
	
	
	
	
	@PutMapping("/like/{product_id}")
	public ResponseEntity<?> addLike(Principal p, @PathVariable("product_id") Long product_id) {
		User u = userRepository.findByUsernameAndFetchRoles(p.getName());
		
	 	 
	 Product1  p2 = prodrep.findById2(product_id);
		Map<String , String> mes = new HashMap<>();
		mes.put("msg", "you have already  have a favourite");

			p2.increment();
			
			//p2.setIslik(Boolean.FALSE);
			p2.setProduct_id(p2.getProduct_id());
			u.setId(u.getId());
		
		
			return  ResponseEntity.status(HttpStatus.CREATED).body(	prodrep.save(p2) );
	 
	
	 
	/* else {
		 p2.increment();
			
			p2.setIslik(Boolean.TRUE);
			p2.setProduct_id(p2.getProduct_id());
			u.setId(u.getId());
	
		
			return  ResponseEntity.status(HttpStatus.CREATED).body( prodrep.save(p2));
		 
	 }*/
	}

	
	@PutMapping("/dislike/{product_id}")
	public ResponseEntity<?> adddisLike(Principal p, @PathVariable("product_id") Long product_id) {
		User u = userRepository.findByUsernameAndFetchRoles(p.getName());
		
	 	 
	 Product1  p2 = prodrep.findById2(product_id);
		Map<String , String> mes = new HashMap<>();
		mes.put("msg", "you have already  have a favourite");

			p2.adddesLike();
			
			//p2.setIslik(Boolean.FALSE);
			p2.setProduct_id(p2.getProduct_id());
			u.setId(u.getId());
		
		
			return  ResponseEntity.status(HttpStatus.CREATED).body(	prodrep.save(p2) );
	 
	
	 
	/* else {
		 p2.increment();
			
			p2.setIslik(Boolean.TRUE);
			p2.setProduct_id(p2.getProduct_id());
			u.setId(u.getId());
	
		
			return  ResponseEntity.status(HttpStatus.CREATED).body( prodrep.save(p2));
		 
	 }*/
	}

	@PostMapping("/addfav")
	public ResponseEntity<?> addFav(Principal p) {
		User u = userRepository.findByUsernameAndFetchRoles(p.getName());
		
	 Favourite f=new Favourite();
		Map<String , String> mes = new HashMap<>();
		mes.put("msg", "you have already  have a favourite");
	 //if(u.getFav().equals(0))
		 
	//{
		 
		 u.setFav(Boolean.TRUE);
			f.setUser(u);
			f.setFavourite_id(f.getFavourite_id());
			f.setFavourite_title("product" + u.getId());
		
			return  ResponseEntity.status(HttpStatus.CREATED).body( favrepo.save(f));
	// }
	
	 
	 //else return  ResponseEntity.status(HttpStatus.CREATED).body( mes);
	}
	
	@PutMapping("/affectprodfav/{favourite_id}/{product_id}")
	 public  ResponseEntity<?> affectprodtofav(Principal p1, @PathVariable("favourite_id") Long favourite_id,@PathVariable("product_id") Long product_id) {
		User u = userRepository.findByUsernameAndFetchRoles(p1.getName());
		
		 Favourite f=favrepo.findById(favourite_id).get();
		f.setFavourite_id(f.getFavourite_id());
		Product1 prod1= prodrep.findById2(product_id);
		
		
		prod1.setFavourite(f);
		
		
         
		
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(prodrep.save(prod1));
		
		
		
		
		 
		
		
		
		 
		
		
		
		
		
	}
	
}
