package com.project0.esprit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project0.esprit.datentity.Comment;
import com.project0.esprit.datentity.Poll;
import com.project0.esprit.datentity.User;
import com.project0.esprit.repository.CommentRepository;
import com.project0.esprit.repository.UserRepository;
/*
@Service
public class CommentService {
	
	private final UserRepository userRepository;
	
	private final CommentRepository commentRepository;
	@Autowired
	CommentService(UserRepository userRepository,CommentRepository commentRepository){
		
	    this.commentRepository=commentRepository;
	    this.userRepository=userRepository;
	    
	}
	
	public List<Comment> getAllForUser(String username) {
        User user = userRepository.findOneByUsername(username);
        return commentRepository.findAllByUser(user);
    }

    public List<Comment> getAllVisibleForUser(String username) {
        User user = userRepository.findOneByUsername(username);
return commentRepository.findAllByUser(user);
       // return commentRepository.findAllByUserAndVisible(user, true);
    }

}
*/