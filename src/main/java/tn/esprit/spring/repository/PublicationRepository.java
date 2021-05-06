package tn.esprit.spring.repository;




import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Publication;
import tn.esprit.spring.entity.User;


@Repository
public interface PublicationRepository extends JpaRepository<Publication, Integer> {
	
	
	/*@Query(value = "select publication_txt from publication p join user on user.user_id = p.user_id where user.user_id = ?1 )",nativeQuery =true)
	List<Publication> findByuser_id(int id);*/
	
	
	
	@Query(value ="SELECT * FROM `publication` JOIN comments on comments.pub_id_id=publication.id WHERE publication.id = 1",nativeQuery=true)
	List<Publication> findAllpub();
	
	@Query(value="select publication_txt from publication",nativeQuery=true)
	List<String> findpubtxt();
	

	
	@Modifying
	@Transactional
	@Query(value="delete from publication p where p.publication_txt = :pub_txt",nativeQuery=true)
	void deleteSujetRedondant(@Param("pub_txt") String pub_txt);
	
	@Query(value="select count(*) from comments where pub_id_id =:pub_id",nativeQuery=true)
	int NbreCommentsBypub(@Param("pub_id") Publication pub);
	
	@Query(value="select likecount from publication where pub_id =:pub",nativeQuery=true)	
	int NbreInteractionBypub(@Param("pub") Publication pub);
	
	@Transactional
	@Modifying
	@Query(value="delete from comments where pub_id_id=:pub",nativeQuery=true)
	void DeleteCommentsByPub(@Param("pub") Publication pub);
	
	@Query(value="select count(*) from comments where comments.pub_id_id= :pub_id ",nativeQuery=true)
	int nbreComments(@Param("pub_id") int pub_id);
	@Query(value="select likecount,dislikecount,title from publication",nativeQuery=true)
	Publication getpub();
	
	@Query(value="select count(*) from publication",nativeQuery=true)
	int NbrePub();
	
	
	
	

}
