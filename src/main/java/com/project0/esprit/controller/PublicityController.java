package com.project0.esprit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project0.esprit.entity.Publicity;
import com.project0.esprit.repository.PublicityRepository;


import com.project0.esprit.entity.LikesCmt;


@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class PublicityController {

	
	
	
	
	@Autowired
	 private PublicityRepository categoryRepository;
	
	
	@PostMapping("/addpub")
	public void add2(@RequestBody   Publicity cat)
	{
		this.categoryRepository.save(cat);
		
	}
	
	@GetMapping("/pub")
	
	public List<Publicity> getAll2(){
		return this.categoryRepository.findAll();
	}
	
	@DeleteMapping("/delpub/{id}")
	@ResponseBody
	public ResponseEntity<Object>  delCategory(@PathVariable Long id) {
		 categoryRepository.findById(id);
		categoryRepository.deleteById(id);
		
		 return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/findpub/{categoryName}", method = RequestMethod.GET)
	@ResponseBody
	public List<Publicity> findpublicity(@PathVariable String publictyname) {
		List<Publicity> studentResponse = (List<Publicity>) categoryRepository.getPubliityBypublictyname(publictyname);
		return studentResponse;
	}
	
}
