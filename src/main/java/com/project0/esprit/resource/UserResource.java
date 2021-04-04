/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project0.esprit.resource;

import com.project0.esprit.datentity.*;
import com.project0.esprit.repository.UserRepository;
import com.project0.esprit.service.*;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
@RequestMapping("/api1/user")
@CrossOrigin("*")
public class UserResource {

	private byte[] imgprof;
    @Autowired
    private UserService userService;
    
    @Autowired
    private UserRepository  userrep;

    @GetMapping
   @Secured("ROLE_ADMIN")
    public List<User> getAllUsers(@RequestParam(defaultValue = "false") Boolean includeAdmins) {
        return userService.getAllUsers(includeAdmins);
    }
    @PostMapping("/uploadprofimg")
	public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
		this.imgprof = file.getBytes();
	}
	
    
    @PutMapping("/editprof")
    public @ResponseBody  ResponseEntity<?>  editProfile(Principal p ,@RequestBody Lprofile l){
    	l.setEdited(true);
    	l.setPicprofile(this.imgprof);
   User t = 	userService.editProfile(p, l);
   this.imgprof=null;
   return ResponseEntity.status(HttpStatus.OK).body(t);
    	
    	
    	
    	
    }
    
    @GetMapping("/cuurentdetail")
    public ResponseEntity<?> getCureentUserDetails(Principal p1){
    	return ResponseEntity.status(HttpStatus.FOUND).body(userService.CureentDetails(p1));
    }
    
    @GetMapping("/getprofile")

    
    
    public @ResponseBody  ResponseEntity<?>  getProfile(Principal p){
    	//l.setEdited(true);
    	//l.setPicprofile(this.imgprof);
    	
   
   User t = 	userrep.findByUsernameAndFetchRoles(p.getName());
    	
   
   return ResponseEntity.status(HttpStatus.OK).body(t);
    	
    	
    	
    	
    }
    @DeleteMapping("/{id}")
    @Secured("ROLE_ADMIN")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.status(204).build();
    }

}
