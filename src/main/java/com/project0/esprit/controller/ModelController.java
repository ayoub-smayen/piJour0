package com.project0.esprit.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project0.esprit.service.ModelService;

@RestController
@RequestMapping(value = "/restfull-service")
public class ModelController extends HttpServlet 
{
	
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private ModelService modelservice;
	
	@RequestMapping(value = "/chart", method = RequestMethod.GET)
	public @ResponseBody String getDataPoints(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return modelservice.getModelData();
	}
	
}

