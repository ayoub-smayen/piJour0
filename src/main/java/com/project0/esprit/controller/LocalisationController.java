package com.project0.esprit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project0.esprit.entity.Localistation;
import com.project0.esprit.repository.LocalisationRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("api")
public class LocalisationController {
	
	@Autowired
	private LocalisationRepository localrepo ; 
	
	
	@PostMapping("/addloc")
	public ResponseEntity<?> addlocalistaion(@RequestBody Localistation loc) {
		
		return  ResponseEntity.status(HttpStatus.CREATED).body(localrepo.save(loc));
				
	}

	
	@GetMapping("/getlocal")
	public ResponseEntity<?> getAllLocqlisation(){
		return ResponseEntity.status(HttpStatus.FOUND).body(localrepo.findAll());
	}
}
