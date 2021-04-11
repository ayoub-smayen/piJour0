package com.project0.esprit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.project0.esprit.entity.Delivery_Man;
import com.project0.esprit.repository.DeliveryManRepository;
@Service
public class DeliveryManServiceImpl implements DeliveryManService {

	@Autowired
	DeliveryManRepository delivRepository;
	
	@Override
	public void AddLivreur(Delivery_Man liv) {
		delivRepository.save(liv);
		
	}

	@Override
	public List<Delivery_Man> RetrieveDeliveryMan() {
		List<Delivery_Man> liv = (List<Delivery_Man>) delivRepository.findAll();
		return liv;
	}

	@Override
	public void DeleteDeliveryMan(Long id) {
		this.delivRepository.deleteById((long) id);
		
	}

	@Override
	public void UpdateDeliveryMan(Delivery_Man liv, Long id) {
		this.delivRepository.save(liv);
		
	}

}
