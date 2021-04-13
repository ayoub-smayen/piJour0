package com.project0.esprit.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.project0.esprit.entity.User1;
import com.project0.esprit.repository.UserRepository1;
@Service
public class UserService1 {

	@Autowired
	 private UserRepository1 userRepository;
	
	

	
	public User1 createUser( User1 user)  {
		return userRepository.saveAndFlush(user);
		
	}

	
	public Iterable<User1> getAll(){
		return this.userRepository.findAll();
	}
}
