package com.project0.esprit.service;

import java.security.Principal;

import com.project0.esprit.datentity.Comments;

public interface IComments {

	
	public Comments AddComments(Principal p,Comments com,int pub_id);
	public void DeleteComments(Long id);
	public void AddLikes(Long id);
	public void AddDislike(Long id);
}
