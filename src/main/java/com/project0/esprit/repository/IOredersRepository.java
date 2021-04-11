package com.project0.esprit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project0.esprit.entity.Orders0;

@Repository
public interface IOredersRepository extends CrudRepository<Orders0, Long> {
    
}

