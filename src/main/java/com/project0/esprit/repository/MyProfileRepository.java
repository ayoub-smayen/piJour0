package com.project0.esprit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project0.esprit.datentity.Myprofile;

@Repository
public interface MyProfileRepository extends JpaRepository<Myprofile, Long> {

}
