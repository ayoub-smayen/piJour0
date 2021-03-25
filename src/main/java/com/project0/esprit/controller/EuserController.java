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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.project0.esprit.entity.Euser;
import com.project0.esprit.service.EuserService;

@RequestMapping(path="api")
@RestController
@CrossOrigin("*")


public class EuserController {

	@Autowired
	private EuserService userservice;
	
	@GetMapping("/euser/get")
	public @ResponseBody ResponseEntity<List<Euser>> getUser ()
	
	{
		
		return new ResponseEntity<List<Euser>>(userservice.retrieveAllUsers(),HttpStatus.OK);
	}
	/*	@GetMapping("/retrieve_all_users")
	@ResponseBody
	public List<User> getUsers() {
	List<User> list = userservice.retrieveAllUsers();
	return list;

    }*/
	@GetMapping("/euser/get/{user_id}")
	@ResponseBody
	public Euser retrieveUser(@PathVariable("user_id") Long id) {
	return userservice.retrieveUser(id);
	}
	
	@PostMapping("/euser/add")
    public @ResponseBody ResponseEntity<Euser> addUser(@RequestBody Euser u)
	
	{
		
		return new ResponseEntity<Euser>(userservice.addUser(u),HttpStatus.CREATED);
	}
	/*@PostMapping("/add")
	@ResponseBody
	public User addUser(@RequestBody User u) {
	User user = userservice.addUser(u);
	return user;*/

	@PutMapping("/euser/update/{user_id}")
	@ResponseBody
    public void updateUser(@RequestBody Euser u, @PathVariable("user_id") Long id)

    {
	
	userservice.updateUserByFirstName(u.getMembre_username(),id);
    }
	
	/*@PutMapping("/update")
	@ResponseBody
	public User modifyUser(@RequestBody User user) {
	return userservice.updateUser(user);
	}*/
    
	@DeleteMapping("/euser/delete/{user_id}")
	@ResponseBody
	public void removeUser(@PathVariable("user_id") Long id) 
	{
	userservice.deleteUser(id);
		
	}
  
	
}
