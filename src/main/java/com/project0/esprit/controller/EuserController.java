package com.project0.esprit.controller;


import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project0.esprit.entity.Euser;
import com.project0.esprit.repository.EuserRepository;
import com.project0.esprit.service.EuserService;

@RequestMapping(path="api")
@RestController
@CrossOrigin("*")


public class EuserController {

	 private static final Logger logger = LoggerFactory.getLogger(EuserController.class);
	 private byte[] bytes;
		
	@Autowired
	private EuserService userservice;
	@Autowired
	private EuserRepository euserRepository;
	
	
	//http://localhost:8091/api/euser/get
	@GetMapping("/euser/get")
	public @ResponseBody ResponseEntity<List<Euser>> getUser ()
	
	{
		
		return new ResponseEntity<List<Euser>>(userservice.retrieveAllUsers(),HttpStatus.OK);
	}
	
	
	//http://localhost:8091/api/euser/get/{user_id}
	@GetMapping("/euser/get/{user_id}")
	@ResponseBody
	public Euser retrieveUser(@PathVariable("user_id") Long id) {
	return userservice.retrieveUser(id);
	}
	
	
	//http://localhost:8091/api/euser/uploadimage
		@PostMapping("/euser/uploadimage")
		public void uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
			
			logger.info("upload image for user");
			this.bytes = file.getBytes();
		}

		
	 //http://localhost:8091/api/euser/add
		  @PostMapping("/euser/add")
		  public Euser addUser(@RequestBody Euser e) throws IOException {
				e.setUserimg(this.bytes);
				euserRepository.save(e);
				this.bytes = null;
				return e;
			}
	
	//http://localhost:8091/api/euser/update/{user_id}
	@PutMapping("/euser/update/{user_id}")
	@ResponseBody
	public Euser modifyUser(@RequestBody Euser user) {
	return userservice.updateUser(user);
	}
    
	//http://localhost:8091/api/euser/delete/{user_id}
	@DeleteMapping("/euser/delete/{user_id}")
	@ResponseBody
	public void removeUser(@PathVariable("user_id") Long id) 
	{
	userservice.deleteUser(id);
		
	}
 
	//http://localhost:8091/api/euser/finduserbyid/{user_id}
	@GetMapping("/euser/finduserbyid/{user_id}")
	@ResponseBody
	public Euser finduUser(@PathVariable Long user_id) {
		Euser userResponse =  euserRepository.findByIdd(user_id);
		return userResponse;
	}

	
	
}
