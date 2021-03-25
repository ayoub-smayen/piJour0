package com.project0.esprit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project0.esprit.entity.Publicity;

public interface PublicityRepository   extends JpaRepository<Publicity, Long> {
	
	@Query("SELECT a FROM Publicity a WHERE publictyname = ?1")
	public List<Publicity> getPubliityBypublictyname(@Param("publictyname") String publictyname);
	

}
