package com.project0.esprit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project0.esprit.datentity.Publication;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long> {

}
