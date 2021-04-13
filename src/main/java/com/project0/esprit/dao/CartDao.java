package com.project0.esprit.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.project0.esprit.model.*;

public interface CartDao {
	
	Cart findBy(Long idCart);
	Long save(Cart cart);
	void update(Cart cart);
	
}
