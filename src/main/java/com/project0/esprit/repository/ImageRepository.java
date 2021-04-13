package com.project0.esprit.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project0.esprit.entity.ImageT;

public interface ImageRepository extends JpaRepository<ImageT, Long> {
	Optional<ImageT> findByName(String name);
}
