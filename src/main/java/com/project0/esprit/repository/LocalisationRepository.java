package com.project0.esprit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project0.esprit.entity.Localistation;
@Repository
public interface LocalisationRepository extends JpaRepository<Localistation, Long> {

}
