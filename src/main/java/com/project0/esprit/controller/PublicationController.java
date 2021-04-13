package com.project0.esprit.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project0.esprit.datentity.Publication;
import com.project0.esprit.datentity.User;
import com.project0.esprit.repository.UserRepository;
import com.project0.esprit.service.IPublicationInterface;

@RestController
@RequestMapping("/pub")
@CrossOrigin("*")
public class PublicationController {
	
	@Autowired
	IPublicationInterface pub_service;

	
	@Autowired 
	UserRepository userf;
	
	
	@PostMapping("/AddPublication")
	@Secured("ROLE_USER")
	public ResponseEntity<?> AddPub(@RequestBody Publication pub, Principal p ){
		
		
				
	   Publication p1 = pub_service.AddPublication(pub, p);
		return ResponseEntity.status(201).body(p1);
		
	}

	@GetMapping("/RetrievePublication")
	@Secured("ROLE_USER")
	public  ResponseEntity<?> retrieveAllPublications(){
		List<Publication> pub = pub_service.RetrievePublication();
		
		/*Map<List<Publication>, List<User>> m =new HashMap();
		
		  List<User> uss=null;
		  for (Publication p : pub) {
			  uss.add(p.getUser2());
			  
		  }
		  m.put(pub, uss);
		  */
		   
		
		
		
		 return ResponseEntity.status(201).body(pub);
	}
}
