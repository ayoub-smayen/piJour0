package com.project0.esprit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project0.esprit.datentity.Delivery_man0;
import com.project0.esprit.entity.Delivery_Man;
import com.project0.esprit.repository.DeliveryManRepository;
@Service
public class DeliveryManServiceImpl implements DeliveryManService {

	@Autowired
	DeliveryManRepository delivRepository;
	
	@Override
	public void AddLivreur(Delivery_man0 liv) {
		delivRepository.save(liv);
		
	}

	@Override
	public List<Delivery_man0> RetrieveDeliveryMan() {
		List<Delivery_man0> liv = (List<Delivery_man0>) delivRepository.findAll();
		return liv;
	}

	@Override
	public void DeleteDeliveryMan(Long id) {
		this.delivRepository.deleteById((long) id);
		
	}

	@Override
	public void UpdateDeliveryMan(Delivery_man0 liv, Long id) {
		this.delivRepository.save(liv);
		
	}
	
public String DeliveryManOfMounth(){
		
	Delivery_man0 deliv= delivRepository.getDeliveryManOfMounth(delivRepository.getMaxWorkload());
		return (deliv.getDeliveryMan_Name()+"  "+ deliv.getDeliveryMan_lastName());
		
		
	}

	@Override
	public List<Delivery_man0> getDeliveryByDeliveryname(String lastName) {
	
		List<Delivery_man0> liv = (List<Delivery_man0>) delivRepository.findAll();
		return liv;
	}

	@Override
	public void DispWorkload(Long id) {
		Delivery_man0 deliv= delivRepository.getDeliveryById(id);
		
		if (deliv.getDispoDeliv()==true){
			
			deliv.setDispoDeliv(false);
			delivRepository.save(deliv);
	
			
		
	}

}
	
}
