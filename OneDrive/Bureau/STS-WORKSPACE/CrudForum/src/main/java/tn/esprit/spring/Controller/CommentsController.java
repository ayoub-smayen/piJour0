package tn.esprit.spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Comments;
import tn.esprit.spring.entity.LikeComments;
import tn.esprit.spring.repository.CommentsRepository;
import tn.esprit.spring.services.CommentsService;


@RestController
@RequestMapping("/pi")
@CrossOrigin("*")
public class CommentsController implements ICommentsController {

	@Autowired
	ICommentsController commentInterf;
	@Autowired
	CommentsService comService;
	@Autowired
	CommentsRepository com_rep;
	@PostMapping("/AddComments/{userId}/{pubId}")
	public String AddPub(@RequestBody Comments com,@PathVariable(value = "userId") int userId,@PathVariable(value = "pubId") int pubId){
		List<String> dic = com_rep.Dictionnaire();
		for (int i = 1; i <= dic.size(); i++) {
			if (com.getComment_field().contains(dic.get(i-1))) {
				break;
			}
			else{
				if (i == dic.size()) {
					comService.AddComments(userId, com, pubId);
					return "comments added succesfully";
				}
			}
			
		}
		return "can not add comment which contains a forbidden word";
		


	}
	@PostMapping("AddLikesComments/{userId}/{comId}")
	public void AddLikeCom(@PathVariable("userId")int user_id,@PathVariable("comId")int comId,LikeComments like){
		comService.AddLikesComments(like, user_id, comId);
	}
	@PostMapping("AddloveComments/{userId}/{comId}")
	public void AddloveCom(@PathVariable("userId")int user_id,@PathVariable("comId")int comId,LikeComments like){
		comService.AddloveComments(like, user_id, comId);
	}
	@PostMapping("AddhahaComments/{userId}/{comId}")
	public void AddHahaCom(@PathVariable("userId")int user_id,@PathVariable("comId")int comId,LikeComments like){
		comService.AddHahaComments(like, user_id, comId);
	}
	@PostMapping("AddsadComments/{userId}/{comId}")
	public void AddsadCom(@PathVariable("userId")int user_id,@PathVariable("comId")int comId,LikeComments like){
		comService.AddSadComments(like, user_id, comId);
	}
	@PostMapping("AddangryComments/{userId}/{comId}")
	public void AddangryCom(@PathVariable("userId")int user_id,@PathVariable("comId")int comId,LikeComments like){
		comService.AddAngryComments(like, user_id, comId);
	}
	

}
