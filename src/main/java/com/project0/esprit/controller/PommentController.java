package com.project0.esprit.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project0.esprit.datentity.Comments;
import com.project0.esprit.datentity.Publication;
import com.project0.esprit.datentity.User;
import com.project0.esprit.repository.PcommentRepository;
import com.project0.esprit.repository.PublicationRepository;
import com.project0.esprit.repository.UserRepository;
import com.project0.esprit.service.CommentsImpl;
import com.project0.esprit.service.impl.PublicationService;

@RestController
@RequestMapping("/pcom")
@CrossOrigin("*")
public class PommentController {

	
	 @Autowired
	 UserRepository userRepository;
	 
	 @Autowired
	 
	 PublicationRepository pubserv;
	 
	 
	 @Autowired
		CommentsImpl comService;
		@Autowired
		PcommentRepository com_rep;
	 @Autowired
	 PcommentRepository pcomrep;
	 
	 
	 @PostMapping("/AddComments/{pubId}")
		@Secured("ROLE_USER")
		public String Addcomments(Principal p,@RequestBody Comments com,@PathVariable(value = "pubId") int pubId){
			List<String> dic = com_rep.Dictionnaire();
			for (int i = 1; i <= dic.size(); i++) {
				if (com.getComment_field().contains(dic.get(i-1))) {
					break;
				}
				else{
					if (i == dic.size()) {
						comService.AddComments(p, com, pubId);
						return "comments added succesfully";
					}
				}
				
			}
			return "can not add comment wh";
	 }
	 @PutMapping("AddLikecomments/{id}")
		@Secured("ROLE_USER")
		public void Addlikecomment(@PathVariable("id") Long id){
			comService.AddLikes(id);
		}
	@PutMapping("Adddislikecomments/{id}")
		@Secured("ROLE_USER")
		public void Adddislikecomment(@PathVariable("id") Long id){
			comService.AddDislike(id);
	}
	//return "can not add comment which contains a forbidden word";}

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
