package com.project0.esprit.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project0.esprit.datentity.Delivery_man0;
import com.project0.esprit.repository.ClaimRepository;
import com.project0.esprit.repository.DeliveryManRepository;










@Service
public class AffectationClaimImp {
	
	@Autowired
	 ClaimRepository claimrepo ; 
	@Autowired
	DeliveryManRepository delivrepo ;
	
	public String AffectClaim(){
		
		for (Delivery_man0 cl : delivrepo.findAll()) {
			
			if (claimrepo.deliverymanClaims(cl) > 4) {
				return ("the delivery man with the name: "+cl.getDeliveryMan_Name() +" has to many claims");
			}
			
			
		}			
			
			return "";
			
			
		/* (cl.getSubject_claim().equals("Deliveryman")) {
			
			
				for(Deliveryman dev1 : delivrepo.findAll()) {
			  dev1:delivrepo.findById(idc).get();
			dev1.setClaim_client(dev.getClaim_client()+1);
			
			delivrepo.save(dev1);}
			}
		*/
		
		
		
	}
	
	
	
}
