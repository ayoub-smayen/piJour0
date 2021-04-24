package com.project0.esprit.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.project0.esprit.entity.Product1;
import com.project0.esprit.entity.Ray2;

public interface RayService {

	List<Ray2> findByCategory(String categories) throws Exception ;
	
	List<Ray2> showAll()  throws Exception ;
	Ray2 addRay(Ray2 ray)  throws Exception ;
	void DeleteById(@PathVariable("id") Long id)  throws Exception  ;
	void updateRay(Ray2 ray)   throws Exception ;
	
	//List<Product1> findAllProductByrayon(Long id)   throws Exception ;
}
