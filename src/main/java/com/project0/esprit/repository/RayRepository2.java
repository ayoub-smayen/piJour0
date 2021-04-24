package com.project0.esprit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project0.esprit.entity.Ray2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository

public interface RayRepository2 extends JpaRepository<Ray2, Long> {

	@Query("select r from Ray2 r where r.RayName=:rayName")
	Ray2 findByName(@Param("rayName") String RayName);
	

	@Query("select r from Ray2 r where categories= :raycategories")
	List<Ray2> findByCategory(@Param("raycategories") String categories);
	List<Ray2> findAll() ;
	@Query(value="select sum(quantity) from products where category_id in (select category_id from category where ray_id =:id) ",nativeQuery=true)
	int UpdateSumCapacityRayon(@Param("id") Ray2 ray);
	 
}
