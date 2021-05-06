package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entity.Comments;



public interface ICommentsService {
	
	public Comments AddComments(int user_id,Comments com,int pub_id);
	public List<Comments> RetrievePublication();
	public void UpdatePublicationById(Comments com, int id);
	public void DeletePublication(int id);
	public void AddLikes(int id);
	public void AddDislike(int id);
}
