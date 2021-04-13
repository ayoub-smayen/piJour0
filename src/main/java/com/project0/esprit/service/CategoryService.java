package com.project0.esprit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.project0.esprit.entity.Category1;
import com.project0.esprit.repository.CategoryRepository;

@Service
public class CategoryService {

	//@Autowired
	 private CategoryRepository categoryRepository;
	
	


	public Category1 createCategory (Category1 category){
		return categoryRepository.saveAndFlush(category);
		
	}

	public Iterable<Category1> getAll(){
		return this.categoryRepository.findAll();
	}
}
