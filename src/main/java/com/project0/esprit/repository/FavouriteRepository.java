package com.project0.esprit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project0.esprit.datentity.Favourite;
import com.project0.esprit.datentity.User;

public interface FavouriteRepository extends JpaRepository<Favourite, Long> {
	
	
	@Query("SELECT f from Favourite f where f.user = ?1")
Favourite  getUserFavourite(@Param("user") User user);
}
