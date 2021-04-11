package com.project0.esprit.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project0.esprit.entity.User1;

@Repository
public interface  UserRepository1 extends  JpaRepository<User1, Long> {
	@Query("SELECT a FROM User1 a WHERE firstname = ?1 AND email = ?2")
    List<User1> findByFirstNameAndLastName(@Param("firstName") String firstName,@Param("email") String email);
 
}

	
