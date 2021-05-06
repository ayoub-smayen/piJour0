package tn.esprit.spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Comments;

import tn.esprit.spring.repository.CommentsRepository;
import tn.esprit.spring.repository.PublicationRepository;
import tn.esprit.spring.services.CommentsService;
import tn.esprit.spring.services.PublicationService;


@RestController
@RequestMapping("/pi")
@CrossOrigin("*")
public class CommentsController{
	@Autowired
	PublicationControllerImp pub_controller;
	@Autowired
	PublicationRepository pub;
	@Autowired
	CommentsService comService;
	@Autowired
	CommentsRepository com_rep;
	
	
	@PostMapping("/AddComments/{userId}/{pubId}")
	public ResponseEntity<Comments> Addcomments(@RequestBody Comments com,@PathVariable(value = "userId") int userId,@PathVariable(value = "pubId") int pubId){
		List<String> dic = com_rep.Dictionnaire();
		for (int i = 1; i <= dic.size(); i++) {
			if (com.getComment_field().contains(dic.get(i-1))) {
				break;
			}
			else{
				if (i == dic.size()) {
					comService.AddComments(userId, com, pubId);
					pub.findById(pubId).map(p ->{
						p.setCommentsNumber(p.getCommentsNumber()+1);
						pub.save(p);
						return p;
					});
					return ResponseEntity.ok().body(com);
				}
			}
			
		}
		return ResponseEntity.badRequest().build();
		


	}
	@PutMapping("AddLikecomments/{id}")
	public void Addlikecomment(@PathVariable("id") int id){
		comService.AddLikes(id);
	}
	@PutMapping("Adddislikecomments/{id}")
	public void Adddislikecomment(@PathVariable("id") int id){
		comService.AddDislike(id);
	}
	@DeleteMapping("deleteComment/{id}")
	public void DeleteComment(@PathVariable("id") int id){
		com_rep.deleteById(id);
		pub_controller.NbreComments();
	}
	

}
