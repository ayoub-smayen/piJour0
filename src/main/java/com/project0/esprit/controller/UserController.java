package com.project0.esprit.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project0.esprit.entity.User1;
import com.project0.esprit.repository.UserRepository1;


import  com.project0.esprit.service.UserService1;


@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class UserController {
	
	
	@Autowired

	UserRepository1  userservice;
	
	
	
	
	@PostMapping("/adduser")
	public void createUser(@RequestBody User1 user)  {
		 userservice.save(user);
		
	}
	
	@RequestMapping(value = "/findusers/{firstname}/{email}", method = RequestMethod.GET)
	@ResponseBody
	public List<User1> findStudents(@PathVariable String firstname, @PathVariable String email) {
		List<User1> studentResponse = (List<User1>) userservice.findByFirstNameAndLastName(firstname, email);
		return studentResponse;
	}

	
	
	 @GetMapping("/getusers")
	
	public List<User1> getAll(){
		return this.userservice.findAll();
	}
	
	
	

}
