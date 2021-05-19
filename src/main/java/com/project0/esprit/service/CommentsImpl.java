package com.project0.esprit.service;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project0.esprit.datentity.Comments;
import com.project0.esprit.datentity.User;
import com.project0.esprit.repository.PcommentRepository;
import com.project0.esprit.repository.PublicationRepository;
import com.project0.esprit.repository.UserRepository;
@Service
public class CommentsImpl implements IComments   {

	
	@Autowired 
	UserRepository userRepository ;
	
	@Autowired
	PublicationRepository publicationRep;
@Autowired
	PcommentRepository com_rep;


	@Override
	public Comments AddComments(Principal p, Comments com, int pub_id) {
User user = userRepository.findOneByUsername(p.getName());
		
		return publicationRep.findById((long) pub_id).map(pub -> {
			com.setUser(user);
			com.setPublication(pub);
			return com_rep.save(com);
		}).get();
	}

	@Override
	public void DeleteComments(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void AddLikes(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void AddDislike(Long id) {
		// TODO Auto-generated method stub
		
	}

}
