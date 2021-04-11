/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project0.esprit.resource;

import com.project0.esprit.datentity.*;
import com.project0.esprit.entity.UserSendMail;
import com.project0.esprit.repository.ProductRepository;
import com.project0.esprit.repository.PublicityRepository;
import com.project0.esprit.repository.UserRepository;
import com.project0.esprit.service.*;
import com.project0.esprit.utils.*;

import java.security.Principal;
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
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
  private UserRepository userrepo;
    @Autowired
    private UserDetailsService userDetailsService;

    
    @Autowired
   private  PublicityRepository prodrep;
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
            response.setHeader("Access-Control-Max-Age", "360");//0.1
            response.setHeader("Access-Control-Allow-Headers", "x-requested-with");//injection sql heaer s fro where 1=1
            

        
        } catch (DisabledException e) {
            throw new DisabledException("User is disabled!", e);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Bad credentials!", e);
        }

        //generate and return jwt token
        // Reload password post-security so we can generate the token
        
        
        final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
        
        //final User usert = userrepo.findByUsername(user.getUsername());
        
        final String token = jwtTokenUtil.generateToken(userDetails);
        Principal p1;
        Map<String, Object> response2 = new HashMap<>();
        //response.put("login", login);
        //response.put("token", token);
        response2.put("username", userDetails.getUsername());
        response2.put("email","example@gmail.com");
        
        response2.put("roles1", userDetails.getAuthorities().toString());
        response2.put("token", token);
   
        
         response2.put("coins", user.getCoins());
        
        Cookie cookie = new Cookie("user1",userDetails.getUsername().replace(" ", "")  );
        // add cookie in server response
        response.addCookie(cookie);
       // response2.put("email", user.getEmail());
        response2.put("cookieuser",cookie.getValue());
       /*if(usert.getLprofile().getPicprofile().equals(null)) {
        	response2.put("profile_pic", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQHnQJQD2AuE2FCjn3jWK1YdTe484t20VXXPA&usqp=CAU");
        	
        }
        else
        response2.put("profile_pic", usert.getLprofile().getPicprofile());
*/
        // Return the token
        //return ResponseEntity.ok(Collections.singletonMap("token", token));
        response2.put("doonner",prodrep.findAll() );
        return ResponseEntity.ok(response2);
    }
    
    @GetMapping("/get")
    public String getCookie(@CookieValue(value = "user1",
            defaultValue = "No color found in cookie") String user) {

        return "user is: " + user;
    }
    
    
    @GetMapping("/expiry")
    public String setCookieExpiry(HttpServletResponse response) {

        int cookieAgeInSeconds = 86400;

        Cookie cookie = new Cookie("website", "http://localhost:8091");
        cookie.setMaxAge(cookieAgeInSeconds); // expire in 1 day
        response.addCookie(cookie);

        return "Cookie will expire in " + cookieAgeInSeconds/1000 + "seconds.";
    }
    
    @GetMapping("/delete")
    public String deleteCookie(HttpServletResponse response) {

        Cookie cookie = new Cookie("user1", null);
        cookie.setMaxAge(0); // delete cookie
        response.addCookie(cookie);

        return "Cookie deleted";
    }
}
