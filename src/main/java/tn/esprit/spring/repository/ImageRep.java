package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.ImageT;

@Repository
public interface ImageRep extends JpaRepository<ImageT,Long> {

}
