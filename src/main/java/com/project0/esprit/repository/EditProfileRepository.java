package com.project0.esprit.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project0.esprit.datentity.Myprofile;

@Repository
public interface EditProfileRepository extends JpaRepository<Myprofile, Long> {

	
	
	
	@Modifying
	@Query(value = "insert into myprfile (id,firstname,lastname,photoprofile,user_id) VALUES (:id,:firstname,:lastname,:profilepic,:user_id)", nativeQuery = true)
	
	@Transactional
    void addProfile1(@Param("id") Long id,@Param("firstname") String firstname,@Param("lastname") String lasttname,@Param("profilepic") byte[] profilepic, @Param("user_id") Long user_id);
}
