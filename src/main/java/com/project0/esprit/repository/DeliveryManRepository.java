package com.project0.esprit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.project0.esprit.entity.Delivery_Man;

public interface DeliveryManRepository extends JpaRepository<Delivery_Man, Long> {
	@Query("SELECT a FROM Delivery_Man a WHERE deliveryMan_lastname= ?1")
	public List<Delivery_Man> getDeliveryByDeliveryname(@Param("deliveryMan_lastname") String lastname);
	
	@Query("SELECT a FROM Delivery_Man a WHERE deliveryMan_id= ?1")
	public Delivery_Man  getDeliveryById(@Param("deliveryMan_id") Long delivery_id );

}