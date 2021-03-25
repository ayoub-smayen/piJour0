package com.project0.esprit.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

//import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project0.esprit.entity.Euser;

@Repository
public interface EuserRepository extends CrudRepository<Euser, Long> {

	//List<User> findByFirstname(String membre_username);
	@Transactional
	@Modifying
	@Query("UPDATE Euser SET membre_username = ?1 WHERE user_id = ?2")
	public void updateUserByFirstName(@Param(value="membre_name") String membre_username , @Param(value="user_id" ) Long user_id);
	
	
	@Query("SELECT a FROM Euser a WHERE user_id = ?1")
	public Euser findByIdd(@Param(value="user_id" ) Long user_id);
	
}
