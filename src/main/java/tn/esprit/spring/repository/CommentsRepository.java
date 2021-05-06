package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Comments;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Integer> {
	
	@Query(value="select * from comments where pub_id_id = :publicationId order by comments.like_count desc",nativeQuery=true)
	List<Comments> RelevantComments(@Param("publicationId") int id);
	@Query(value="select mots from dictionnaire", nativeQuery=true)
	List<String> Dictionnaire();

}
