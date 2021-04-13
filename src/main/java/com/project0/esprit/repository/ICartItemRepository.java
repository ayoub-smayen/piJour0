package com.project0.esprit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project0.esprit.entity.CartItem0;

@Repository
public interface ICartItemRepository extends CrudRepository<CartItem0, Long>
{
	
}
