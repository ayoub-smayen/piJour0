package com.project0.esprit.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project0.esprit.datentity.Delivery_man0;
import com.project0.esprit.entity.Product1;
import com.project0.esprit.repository.DeliveryManRepository;
import com.project0.esprit.repository.IOredersRepository;
import com.project0.esprit.repository.ProductRepository;



@Service
public class AffectationImpl implements Affectation {
	
	
	@Autowired
	
ProductRepository prodrepo;

	@Autowired
	DeliveryManRepository deliv ;
	
	@Autowired
	IOredersRepository ord ;

	public List <Delivery_man0> moyenDeTransport(Long Product_id){
		
		
		List <Delivery_man0> listDeliv=new ArrayList<Delivery_man0>();
		Product1 p1  = prodrepo.findById(Product_id).get();
		
			 for(Delivery_man0 del :  deliv.findAll()){
					if((p1.getProductHeight()>150.00)||( p1.getProductWidth() >150) ||(p1.getProductWieght()>40)  )		{
				 if(del.getDispoDeliv()){
					 
					 if(del.getTransport().equals("camion")){
	
						 listDeliv.add(del);   }  } 
				 }
			 
			 else if (del.getDispoDeliv()) {
				
				 listDeliv.add(del);} 
				
						
					 
				 
			
					 //return listDeliv;				
		}
			 
			 
			 return listDeliv; 
		
			 
		 
			 
		 

		
		}
		
		
	
	
    public AffectationImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    
    
    
    
    
    
    }


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
