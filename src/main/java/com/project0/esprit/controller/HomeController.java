package com.project0.esprit.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project0.esprit.service.RequestService;



//@Controller

@RestController
@RequestMapping("api")
@CrossOrigin("*")

public class HomeController {
	
	@Autowired
	private RequestService requestService;
	
	
	
	
	 @GetMapping("/public")
	  public String publicService() {
	    return "This message is public";
	  }

	  @GetMapping("/secret")
	  public String secretService(@AuthenticationPrincipal UserDetails details) {
	    System.out.println(details.getUsername());
	    return "A secret message";
	  }
	
	
	
	
	@RequestMapping("/ipgetter")
	public ResponseEntity<?> index(HttpServletRequest request, HttpServletResponse res) {
		ModelAndView model = new ModelAndView("index");
		String clientIp = requestService.getClientIp(request);
		model.addObject("clientIp", clientIp);
		//return model;
		 Map<String , String> m  = new HashMap<String, String>();
		 
		 m.put("ip", clientIp);
		 
		return ResponseEntity.status(HttpStatus.OK).body(m);
	}

}