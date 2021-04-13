package com.project0.esprit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project0.esprit.datentity.Comment;
//import com.project0.esprit.datentity.Poll;
import com.project0.esprit.datentity.User;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

	//List<Comment> findAllByUser(User user);

    //public List<Comment> findAllByUserAndVisible(User user, boolean b);

}
