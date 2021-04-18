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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.persistence.Entity;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



class ChangePassword{
	
	String Passwordnew ;
	String OLdPassword ;
	public String getPasswordnew() {
		return Passwordnew;
	}
	public void setPasswordnew(String passwordnew) {
		Passwordnew = passwordnew;
	}
	public String getOLdPassword() {
		return OLdPassword;
	}
	public void setOLdPassword(String oLdPassword) {
		OLdPassword = oLdPassword;
	}
	public ChangePassword(String passwordnew, String oLdPassword) {
		super();
		Passwordnew = passwordnew;
		OLdPassword = oLdPassword;
	}
	@Override
	public String toString() {
		return "ChangePassword [Passwordnew=" + Passwordnew + ", OLdPassword=" + OLdPassword + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((OLdPassword == null) ? 0 : OLdPassword.hashCode());
		result = prime * result + ((Passwordnew == null) ? 0 : Passwordnew.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChangePassword other = (ChangePassword) obj;
		if (OLdPassword == null) {
			if (other.OLdPassword != null)
				return false;
		} else if (!OLdPassword.equals(other.OLdPassword))
			return false;
		if (Passwordnew == null) {
			if (other.Passwordnew != null)
				return false;
		} else if (!Passwordnew.equals(other.Passwordnew))
			return false;
		return true;
	} 
	
	
}
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
    
    
    @SuppressWarnings("unlikely-arg-type")
	@GetMapping("/testadmin")
    public List<User> getAlladmin() {
    	List<User> u = new ArrayList<>();
    	
    	for(User p :userrep.findAll() ) {
    		
    		System.out.println(p.getRoles());
    		
    		
    		
    		
    		if(p.getRoles().contains(RoleEnum.ROLE_ADMIN.name())) {
    			u.add(p);
    		}
    		
    	}
        return  u;
    }
    
    
    
    @GetMapping("/testuser")
    public List<User> getAllUsersbn(@RequestParam(defaultValue = "false") Boolean includeAdmins) {
        return userService.getAllAdmin(includeAdmins);
    }
    
    @GetMapping("/testuser2")
    public List<User> getAllUsersbnu(@RequestParam(defaultValue = "true") Boolean includeAdmins) {
        return userService.getAllUsers(includeAdmins);
    }
    
    
    @PostMapping("/uploadprofimg")
	public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
		this.imgprof = file.getBytes();
		System.out.println(this.imgprof);
	}
	
    
    @PutMapping("/editprof")
    public @ResponseBody  ResponseEntity<?>  editProfile(Principal p ,@RequestBody Lprofile l){
    	System.out.println(this.imgprof);
    	l.setEdited(true);
    	l.setPicprofile(this.imgprof);
   User t = 	userService.editProfile(p, l);
   this.imgprof=null;
   return ResponseEntity.status(HttpStatus.OK).body(t);
    	
    	
    	
    	
    }
    
    
    @RequestMapping(value = "principalchangepassword" , method = RequestMethod.GET)
    public @ResponseBody String principalchangepassword(Locale local, HttpServletRequest httpServletRequest){
    	//Authentication  principal = (Authentication)  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	String name = SecurityContextHolder.getContext().getAuthentication().getName();
       // Principal me = Principal.findPrincipal(principal.getName());Model uiModel
        User  u = userrep.findByUsernameAndFetchRoles(name);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        
       /* me.setPassword(httpServletRequest.getParameter("password1"));
        StandardStringDigester digester = new StandardStringDigester();
        digester.setAlgorithm("SHA-256");   // optionally set the algorithm
        digester.setStringOutputType("hexadecimal");
        digester.setSaltSizeBytes(0);
        digester.setIterations(1);
        String digest = digester.digest(me.getPassword());
        me.setPassword(digest.toLowerCase());
        me.merge();*/
        return "Password Updated successfully   "  +  u.getUsername() + " " +    u.getPassword()+  " " +   local.getLanguage();
    }
    
    
    @PutMapping("/changepassworduser")
    public @ResponseBody ResponseEntity<?>  changePassword(@RequestBody ChangePassword ch){
    	
    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    	
    	String name = SecurityContextHolder.getContext().getAuthentication().getName();
    	Map<String, String> m1 = new HashMap<>();
        // Principal me = Principal.findPrincipal(principal.getName());Model uiModel
         User  u = userrep.findByUsernameAndFetchRoles(name);
         
         
         if(passwordEncoder.matches(ch.getOLdPassword(), u.getPassword())) {
        	 m1.put("response", "your password  change succesfuly 😁😍😍😍");
        	 u.setId(u.getId());
        	 u.setPassword(passwordEncoder.encode( ch.getPasswordnew()));
        	 
        	 userrep.save(u);
        	 Locale.setDefault(Locale.ENGLISH);
        	  return ResponseEntity.status(HttpStatus.ACCEPTED).body(m1 );
         }
         
       
         
         else   return ResponseEntity.status(HttpStatus.ACCEPTED).body("no matches");
    	
    }
    
    
    @GetMapping("4")
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
