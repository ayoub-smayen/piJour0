package com.project0.esprit.service;

import java.security.NoSuchAlgorithmException;

import com.project0.esprit.exception.*;
import com.project0.esprit.model.*;

public interface CustomerService {

	Customer authentication(String username, String password) 
			throws NoSuchAlgorithmException, AuthenticationFailedException;
	Long addCustomer(Customer customer) throws NoSuchAlgorithmException;
}
