package com.project0.esprit.controller;

/*
 * 
 * category  crud  
 * 
 * generate new categroy  for  all  product added  
 */
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project0.esprit.entity.Category1;
import com.project0.esprit.entity.Product1;
import com.project0.esprit.entity.User1;
import com.project0.esprit.repository.CategoryRepository;
import com.project0.esprit.repository.UserRepository1;

import  com.project0.esprit.service.CategoryService;
@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class CategoryContoller {
 
	@Autowired
	 private CategoryRepository categoryRepository;
	
	

	CategoryService catservice =new CategoryService() ;
	
	@PostMapping("/add")
	public @ResponseBody ResponseEntity<?> add(@RequestBody   Category1 cat)
	{
		return  ResponseEntity.status(HttpStatus.CREATED).body(  categoryRepository.save(cat));
		
	}
	@GetMapping("/cat")
	
	public Iterable<Category1> getAll(){
		return this.categoryRepository.findAll();
	}
	@RequestMapping(value = "/findcat/{categoryName}", method = RequestMethod.GET)
	@ResponseBody
	public List<Category1> findStudents(@PathVariable String categoryName) {
		List<Category1> studentResponse = (List<Category1>) categoryRepository.findByNameEndsWith(categoryName);
		return studentResponse;
	}

	
	
	@PutMapping("/putcat")
	public @ResponseBody ResponseEntity<?> updateCategory(@RequestBody Category1 cat)
	{
		
		cat.setCategory_id(cat.getCategory_id());
		return    ResponseEntity.status(HttpStatus.CREATED).body(  categoryRepository.save(cat));
		
	}

	
}

/*
 * 
 *  {

       
        "role": 2,
        "membre_username": "eya",
        "password": "tfgyhuji",
        "confirm_password": "edxcftgyhu",
        "email": "a@gmail.com",
        "group": "fcgvbhjn",
        "city": "rftgyhuj",
        "address": "dxcfgvhuj",
        "phone_number": "25896321"
    }
 * */
