package com.project0.esprit.controller;

import java.util.Arrays;
import java.util.stream.Collectors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

class CokkieUser {
	
	
	CokkieUser(){
		
	}
	
	 String username;
	  String email;
	   
}

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class CookiesController {

	
	@GetMapping("/mycookie")
	public String readCookie(@CookieValue(value = "user0", defaultValue = "Guster") String username) {
	    return "Hey! My username is " + username;
	}
	
	@RequestMapping(value = "/home/cookie", method = RequestMethod.GET)
	public String readCookie(HttpServletRequest request) {
	  
		 
		
		 
	    Cookie[] cookies = request.getCookies();
	    Cookie coki = null;
	    for (Cookie cookie : cookies) {
	       
	        if (cookie.getName().equals("user0")) {
	        	coki=cookie;
	            System.out.println(cookie.getValue());
	        }
	    }
	    return "home"  ;
	}
	@PostMapping("/change-username")
	public String setCookie(HttpServletResponse response,@RequestBody CokkieUser username) {
	    // create a cookie
		/*if(username.equals(null)){
			 Cookie cookie = new Cookie("username", "guest");
		}*/
		
		
	    Cookie cookie = new Cookie("user0", username.username);

	    //add cookie to response
	    response.addCookie(cookie);

	    return "Username is changed!";
	}
	@GetMapping("/noexpires")
	public Cookie[] getCookiesnoexpires(HttpServletRequest req, HttpServletResponse res) {
		return req.getCookies();
	}
	
	@GetMapping("/all-cookies")
	public String readAllCookies(HttpServletRequest request) {

	    Cookie[] cookies = request.getCookies();
	    if (cookies != null) {
	        return Arrays.stream(cookies)
	                .map(c -> c.getName() + "=" + c.getValue()).collect(Collectors.joining(", "));
	    }

	    return "No cookies";
	}
}
