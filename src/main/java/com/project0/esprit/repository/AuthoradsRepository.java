package com.project0.esprit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project0.esprit.entity.Authorads;

@Repository
public interface AuthoradsRepository extends JpaRepository<Authorads, Integer> {

}
