package com.project0.esprit.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
	
	
	private byte[] bytes;
	@PostMapping("/upload2")
	@Secured("ROLE_USER")
	public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
		this.bytes = file.getBytes();
	}
	
	
	
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
	
	@DeleteMapping("remove-publication/{id}")
	@Secured("ROLE_USER")
	public void DeletePub(@PathVariable("id") Long id){
		this.pub_service.DeletePublication(id);
	}
@GetMapping("RetrievePublication/{id}")
	@Secured("ROLE_USER")
	public Publication getPubByID(@PathVariable(value = "id")Long id){
		
		
		return pub_service.GetPubById(id);
		
	}

@DeleteMapping("DeletePubWithoutInteraction")
public void DeletePubWithoutInteraction(){
	pub_service.DeletePostsWithoutInteraction();
}

@GetMapping("GetPubAlaune")
@Secured("ROLE_USER")
public List<Publication> getPubAlaUne(){
	return pub_service.AffichageDesSujetsAlaUne();
}
@PutMapping("AddLikeposts/{id}")
@Secured("ROLE_USER")
public void AddLikeposts(@PathVariable("id") Long id){
	pub_service.AddLike(id);
}


@PutMapping("AdddisLikeposts/{id}")
@Secured("ROLE_USER")
public void AdddisLikeposts(@PathVariable("id") Long id){
	pub_service.AddDislike(id);
}




}
