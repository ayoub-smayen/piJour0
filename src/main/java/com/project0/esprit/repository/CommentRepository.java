package com.project0.esprit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project0.esprit.datentity.Comment;
//import com.project0.esprit.datentity.Poll;
import com.project0.esprit.datentity.User;
import com.project0.esprit.entity.Product1;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

	//List<Comment> findAllByUser(User user);

    //public List<Comment> findAllByUserAndVisible(User user, boolean b);
	
	
	@Query("SELECT a    FROM   Comment a  join  a.product  c  WHERE  c.product_id = ?1  ")
    List<Comment> JComment(@Param("product_id") Long product_id);

}
