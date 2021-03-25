package com.project0.esprit.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project0.esprit.datentity.Comments;
import com.project0.esprit.datentity.Publication;
import com.project0.esprit.datentity.User;
import com.project0.esprit.repository.PcommentRepository;
import com.project0.esprit.repository.PublicationRepository;
import com.project0.esprit.repository.UserRepository;
import com.project0.esprit.service.impl.PublicationService;

@RestController
@RequestMapping("pcom")
@CrossOrigin("*")
public class PommentController {

	
	 @Autowired
	 UserRepository userRepository;
	 
	 @Autowired
	 PublicationRepository pubserv;
	 
	 
	 @Autowired
	 PcommentRepository pcomrep;
	 
	 @PostMapping("/addcom/{pubId}")
	 public ResponseEntity<?> addCommentPub(@RequestBody Comments  com,@PathVariable("pubId") Long id , Principal  p){
		 
		 
		 User u = userRepository.findByUsernameAndFetchRoles(p.getName());
		 // 
				 pubserv.findById(id).map(pub->{
					 com.setPublication(pub);
					 return pcomrep.save(com);
					 
				 });
				 
				 
				 
		 com.setUser(u);
		 
		 Comments pub1 =	 pcomrep.save(com);
		 
		 return ResponseEntity.status(201).body(pub1);
		 
		 
		
		 
		 
		 
	 }
	 
	 @GetMapping("/allcOMMENTS")
	 private ResponseEntity<?> GetAllCommentaires(){
		 
		   List<Comments> com = pcomrep.findAll();
		 return ResponseEntity.status(201).body(com);
		 
	 }
	 
	 
}
