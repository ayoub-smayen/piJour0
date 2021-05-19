package com.project0.esprit.service;

import java.util.List;

import com.project0.esprit.datentity.Delivery_man0;
import com.project0.esprit.entity.Delivery_Man;



public interface DeliveryManService {

	public void AddLivreur(Delivery_man0 liv);
	public List<Delivery_man0> RetrieveDeliveryMan();
	public void DeleteDeliveryMan(Long id);
	void UpdateDeliveryMan(Delivery_man0 liv, Long id);
	
	public List <Delivery_man0> getDeliveryByDeliveryname(String lastName);
	public void DispWorkload (Long id); 
	
	
}
