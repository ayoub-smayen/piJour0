package com.project0.esprit.dao;

import java.util.List;

import com.project0.esprit.model.*;

public interface ProductDao {

	Product findBy(Long idProduct);
	Product findBy(String description);
	List<Product> findByCategory(String category);
	List<Product> findAll();
	
}
