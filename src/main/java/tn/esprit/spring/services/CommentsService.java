package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Comments;
import tn.esprit.spring.entity.InteractionComments;
import tn.esprit.spring.entity.LikeComments;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.CommentsRepository;
import tn.esprit.spring.repository.LikesCommentsRepository;
import tn.esprit.spring.repository.PublicationRepository;
import tn.esprit.spring.repository.UserRepository;

@Service
public class CommentsService implements ICommentsService {

	@Autowired
	LikesCommentsRepository lcomments_rep;
	@Autowired
	PublicationRepository publicationRep;
	
	@Autowired
	UserRepository userRep;
	@Autowired
	CommentsRepository com_rep;
	@Override
	public Comments AddComments(int user_id,Comments com,int pub_id) {
		// TODO Auto-generated method stub

		userRep.findById(user_id).map(user -> {
			com.setUser(user);
			return com_rep.save(com);
		}).get();
		return publicationRep.findById(pub_id).map(pub -> {
			com.setPub_id(pub);
			return com_rep.save(com);
		}).get();
	}

	@Override
	public List<Comments> RetrieveComments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void UpdateCommentsById(Comments com, int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DeleteComments(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void AddLikesComments(LikeComments like_com,int user_id, int com_id) {
		// TODO Auto-generated method stub
		Iterable<User> user = userRep.findAll();
		for (User user2 : user) {
			if (lcomments_rep.LikesComments(com_id, user_id)==0) {
				if (user2.getUser_id()==user_id) {
					
					com_rep.findById(com_id).map(c ->{
						like_com.setInteractionType(InteractionComments.Like);
						like_com.setUser(user2);
						like_com.setPub(c);
						like_com.setLiked(true);
						return c;
						
					});
					
					lcomments_rep.save(like_com);
				}
				
			}
			
		}
		
	}

	@Override
	public void AddloveComments(LikeComments like_com, int user_id, int com_id) {
		// TODO Auto-generated method stub
		Iterable<User> user = userRep.findAll();
		for (User user2 : user) {
			if (lcomments_rep.LoveComments(com_id, user_id)==0) {
				if (user2.getUser_id()==user_id) {
					
					com_rep.findById(com_id).map(c ->{
						like_com.setInteractionType(InteractionComments.love);
						like_com.setUser(user2);
						like_com.setPub(c);
						like_com.setLiked(true);
						return c;
						
					});
					
					lcomments_rep.save(like_com);
				}
				
			}
			
		}
		
	}

	@Override
	public void AddHahaComments(LikeComments like_com, int user_id, int com_id) {
		// TODO Auto-generated method stub
		Iterable<User> user = userRep.findAll();
		for (User user2 : user) {
			if (lcomments_rep.HahaComments(com_id, user_id)==0) {
				if (user2.getUser_id()==user_id) {
					
					com_rep.findById(com_id).map(c ->{
						like_com.setInteractionType(InteractionComments.haha);
						like_com.setUser(user2);
						like_com.setPub(c);
						like_com.setLiked(true);
						return c;
						
					});
					
					lcomments_rep.save(like_com);
				}
				
			}
			
		}
		
	}

	@Override
	public void AddSadComments(LikeComments like_com, int user_id, int com_id) {
		// TODO Auto-generated method stub
		Iterable<User> user = userRep.findAll();
		for (User user2 : user) {
			if (lcomments_rep.SadComments(com_id, user_id)==0) {
				if (user2.getUser_id()==user_id) {
					
					com_rep.findById(com_id).map(c ->{
						like_com.setInteractionType(InteractionComments.sad);
						like_com.setUser(user2);
						like_com.setPub(c);
						like_com.setLiked(true);
						return c;
						
					});
					
					lcomments_rep.save(like_com);
				}
				
			}
			
		}
		
	}

	@Override
	public void AddAngryComments(LikeComments like_com, int user_id, int com_id) {
		// TODO Auto-generated method stub
		Iterable<User> user = userRep.findAll();
		for (User user2 : user) {
			if (lcomments_rep.AngryComments(com_id, user_id)==0) {
				if (user2.getUser_id()==user_id) {
					
					com_rep.findById(com_id).map(c ->{
						like_com.setInteractionType(InteractionComments.angry);
						like_com.setUser(user2);
						like_com.setPub(c);
						like_com.setLiked(true);
						return c;
						
					});
					
					lcomments_rep.save(like_com);
				}
				
			}
			
		}
		
	}

}
