package com.project0.esprit.dao;

import com.project0.esprit.model.*;;

public interface CustomerDao {

	Customer findBy(String username);
	Long save(Customer customer);
	
}
