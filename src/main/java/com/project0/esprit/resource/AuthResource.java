/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project0.esprit.resource;

import com.project0.esprit.datentity.*;
import com.project0.esprit.entity.UserSendMail;
import com.project0.esprit.service.*;
import com.project0.esprit.utils.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api1/auth")
@CrossOrigin("*")
public class AuthResource {

    @Autowired
    JwtTokenUtils jwtTokenUtil;
    /*@Autowired
    private  UserSendMail ur;*/
    /*@Autowired
	private MailService notificationService;
    */
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {

    	
    	/*ur.setEmailAddress(user.getEmail());
    	ur.setFirstName(user.getUsername());
    	ur.setLastName(user.getUsername());
    	try {
			notificationService.sendEmail(ur);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}*/
        User savedUser = userService.saveUser(user);
        return ResponseEntity.status(201).body(savedUser);
    }

    @PostMapping("/login")
    public ResponseEntity<?>  login(@RequestBody User user,HttpServletResponse response) {

    	
    	
        Objects.requireNonNull(user.getUsername());
        //Objects.requireNonNull(user.getEmail());
        Objects.requireNonNull(user.getPassword());
        
        /*ur.setEmailAddress(user.getEmail());
    	ur.setFirstName(user.getUsername());
    	ur.setLastName(user.getUsername());
    	try {
			notificationService.sendEmail(ur);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}*/
        try {
        	
        	
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
            Cookie cookie = new Cookie("user0",user.getUsername());
           // notificationService.sendEmail2(user);
            // expires in 7 days
            cookie.setMaxAge(7 * 24 * 60 * 60);

            // optional properties
            cookie.setSecure(true);
            cookie.setHttpOnly(true);
            cookie.setPath("/");

            // add cookie to response
            response.addCookie(cookie);
            
            
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "GET,POST");
            response.setHeader("Access-Control-Max-Age", "360");
            response.setHeader("Access-Control-Allow-Headers", "x-requested-with");

        
        } catch (DisabledException e) {
            throw new DisabledException("User is disabled!", e);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Bad credentials!", e);
        }

        //generate and return jwt token
        // Reload password post-security so we can generate the token
        
        
        final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
        
        
        final String token = jwtTokenUtil.generateToken(userDetails);
        
        Map<String, String> response2 = new HashMap<>();
        //response.put("login", login);
        //response.put("token", token);
        response2.put("login", userDetails.getUsername());
       
        response2.put("token", token);


        // Return the token
        return ResponseEntity.ok(Collections.singletonMap("token", token));
        //return ResponseEntity.ok(response2);
    }
}
