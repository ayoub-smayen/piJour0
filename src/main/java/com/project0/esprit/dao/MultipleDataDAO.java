package com.project0.esprit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project0.esprit.entity.MultipleData;

@Repository
public interface MultipleDataDAO extends JpaRepository<MultipleData, Integer> {

}
