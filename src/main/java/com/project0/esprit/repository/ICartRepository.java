package com.project0.esprit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project0.esprit.entity.Cart0;

@Repository
public interface ICartRepository extends CrudRepository<Cart0, Long> {

}
