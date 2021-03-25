package com.project0.esprit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project0.esprit.entity.Colis;
import com.project0.esprit.entity.Product1;

@Repository
public interface ColisRepository  extends JpaRepository<Colis, Long>{

	
	@Query("SELECT A from Colis A WHERE  coli_id = ?1 ")
	Colis findColisById(@Param("coli_id") Long coli_id);
	
	
	@Query("SELECT r FROM Colis r ORDER BY createdAt ASC")
	 List<Colis> findAllByDate();
}
