package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entity.Comments;
import tn.esprit.spring.entity.LikeComments;


public interface ICommentsService {
	
	public Comments AddComments(int user_id,Comments com,int pub_id);
	public List<Comments> RetrievePublication();
	public void UpdatePublicationById(Comments com, int id);
	public void DeletePublication(int id);
	public void AddLikesComments(LikeComments like_com,int user_id,int com_id);
	public void AddloveComments(LikeComments like_com,int user_id,int com_id);
	public void AddHahaComments(LikeComments like_com,int user_id,int com_id);
	public void AddSadComments(LikeComments like_com,int user_id,int com_id);
	public void AddAngryComments(LikeComments like_com,int user_id,int com_id);

}
