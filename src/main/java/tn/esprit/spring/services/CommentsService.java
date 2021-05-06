package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Comments;

import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.CommentsRepository;

import tn.esprit.spring.repository.PublicationRepository;
import tn.esprit.spring.repository.UserRepository;

@Service
public class CommentsService implements ICommentsService {

	
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
	public List<Comments> RetrievePublication() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void UpdatePublicationById(Comments com, int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DeletePublication(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void AddLikes(int id) {
		// TODO Auto-generated method stub
		com_rep.findById(id).map(c -> {
			c.setLike_count(c.getLike_count()+1);
			com_rep.save(c);
			return c;
		});
		
	}

	@Override
	public void AddDislike(int id) {
		// TODO Auto-generated method stub
		com_rep.findById(id).map(c -> {
			c.setDislike_count(c.getDislike_count()+1);
			com_rep.save(c);
			return c;
		});
		
	}

	
		
	

	
		
	

	

}
