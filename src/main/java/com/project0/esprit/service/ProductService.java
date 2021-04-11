package com.project0.esprit.service;

import java.util.List;

import com.project0.esprit.exception.*;
import com.project0.esprit.model.*;

public interface ProductService {

	Product findBy(Long idProduct) throws ProductNotFoundException;
	Product findBy(String description) throws ProductNotFoundException;
	List<Product> findByCategory(String category) throws ProductNotFoundException;
	List<Product> findAll() throws ProductNotFoundException;
	
}
