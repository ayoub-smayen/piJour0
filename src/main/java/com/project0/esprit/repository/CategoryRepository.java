package com.project0.esprit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project0.esprit.entity.Category1;


@Repository
public interface CategoryRepository extends JpaRepository<Category1, Long> {

	
	/* @Query("select c from category c where c.categoryName = ?1")
	    List<Category> findByNameEndsWith(String categoryName);*/
	
	 @Query("select c from Category c where c.categoryName = ?1")
	    List<Category1> findByNameEndsWith(String categoryName);
	 
	 @Query("SELECT r FROM Category r ORDER BY createdAt ASC")
	 List<Category1> findAllByDate();
	
}
