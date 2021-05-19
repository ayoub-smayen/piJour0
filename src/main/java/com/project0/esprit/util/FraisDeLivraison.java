package com.project0.esprit.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project0.esprit.datentity.Delivery_man0;
import com.project0.esprit.entity.Product1;
import com.project0.esprit.repository.DeliveryManRepository;
import com.project0.esprit.repository.ProductRepository;




@Service
@Transactional
public class FraisDeLivraison implements Frais {
	@Autowired 
	DeliveryManRepository del;
	@Autowired
	ProductRepository prodrepo;
	
	public int livraisonfrais(Long deliveryMan_id, Long Product_id,double f , double g) {
		
		double dl ,da; 
		
		 int frais=8;
		 Delivery_man0 deli = (Delivery_man0) del.findById(deliveryMan_id).get() ; 
		 dl=deli.getLngi()-f;
		 da=deli.getLati()-g;
		
		 Product1 p1  = prodrepo.findById(Product_id).get();
	
	if (p1.getProductWieght()>50) {
		 frais = frais+4 ;
	 }
	 if((p1.getProductHeight()>150.00)||(p1.getProductWidth()>150.00))
		 frais=frais+4;
	 System.out.println("here 0");
	
	 if((dl>1)&&(da>1))
			frais=frais+8; 
	
	 
	 return frais; }
}