package com.project0.esprit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project0.esprit.datentity.Delivery_man0;



@Repository
public interface DeliveryManRepository extends JpaRepository<Delivery_man0, Long> {
	@Query("SELECT a FROM Delivery_Man a WHERE deliveryMan_lastname= ?1")
	public List<Delivery_man0> getDeliveryByDeliveryname(@Param("deliveryMan_lastname") String lastname);
	
	@Query("SELECT a FROM Delivery_man0 a WHERE deliveryMan_id= ?1")
	public Delivery_man0  getDeliveryById(@Param("deliveryMan_id") Long delivery_id );

	@Query(value="SELECT max(workload) FROM delivey_man0",nativeQuery=true)
	 public int   getMaxWorkload();
	
	@Query(value="SELECT * FROM Delivery_man0 WHERE workload=:max",nativeQuery=true)
	public Delivery_man0   getDeliveryManOfMounth(@Param("max") int max);
	
}