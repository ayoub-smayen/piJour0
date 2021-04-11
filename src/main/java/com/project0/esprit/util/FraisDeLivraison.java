package com.project0.esprit.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project0.esprit.entity.Delivery_Man;
import com.project0.esprit.entity.Product;
import com.project0.esprit.repository.DeliveryManRepository;
import com.project0.esprit.repository.Product1Repository;





@Service
@Transactional
public class FraisDeLivraison implements Frais {
	@Autowired 
	DeliveryManRepository del;
	@Autowired
	Product1Repository prodrepo;
	
	public int livraisonfrais(Long deliveryMan_id, Long Product_id,Long f , Long g) {
		
		double dl ,da; 
		
		 int frais=8;
		 Delivery_Man deli = (Delivery_Man) del.findById(deliveryMan_id).get() ; 
		 dl=deli.getShop1().getShopLongitude()-f;
		 da=deli.getShop1().getShopLatitude()-g;
		
		 Product p1  = prodrepo.findById(Product_id).get();
	
	if (p1.getWeight()>50) {
		 frais = frais+4 ;
	 }
	 if((p1.getDimension().getLenght()>150.00)||(p1.getDimension().getWidth()>150.00))
		 frais=frais+4;
	
	 if((dl>10)&&(da>10))
			frais=frais+4; 
	
	 
	 return frais; }
}