package com.project0.esprit.service;
import javax.servlet.http.HttpServletRequest;

public interface RequestService {
	
	String getClientIp(HttpServletRequest request);
	
}