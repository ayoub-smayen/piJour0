package com.project0.esprit.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project0.esprit.datentity.Comments;

@Repository
public interface PcommentRepository extends JpaRepository<Comments, Long> {
	
	
	@Query(value="select * from pcomments where pub_id = :publicationId order by pcomments.like_count desc",nativeQuery=true)
	List<Comments> RelevantComments(@Param("publicationId") Long id);
	@Query(value="select mots from dictionnaire", nativeQuery=true)
	List<String> Dictionnaire();
@Transactional
	@Modifying
	@Query(value = "UPDATE pcomments SET comment_field =:com WHERE id =:id",nativeQuery=true)
	void updatecomment(@Param("com") String com,@Param("id") Long id);

}
