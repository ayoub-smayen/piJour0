package com.project0.esprit.service;

import java.util.List;

import com.project0.esprit.entity.Delivery_Man;



public interface DeliveryManService {

	public void AddLivreur(Delivery_Man liv);
	public List<Delivery_Man> RetrieveDeliveryMan();
	public void DeleteDeliveryMan(Long id);
	void UpdateDeliveryMan(Delivery_Man liv, Long id);
	
	
}
