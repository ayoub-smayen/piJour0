package com.project0.esprit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project0.esprit.datentity.Comments;

@Repository
public interface PcommentRepository extends JpaRepository<Comments, Long> {

}