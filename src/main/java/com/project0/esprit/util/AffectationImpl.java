package com.project0.esprit.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project0.esprit.entity.Delivery_Man;
import com.project0.esprit.entity.Product;
import com.project0.esprit.repository.DeliveryManRepository;
import com.project0.esprit.repository.Product1Repository;



@Service
public class AffectationImpl implements Affectation {
	
	
	@Autowired
	
Product1Repository prodrepo;

	@Autowired
	DeliveryManRepository deliv ;

	public List <Delivery_Man> moyenDeTransport(Long Product_id){
		
		
		List <Delivery_Man> listDeliv=new ArrayList<Delivery_Man>();
		Product p1  = prodrepo.findById(Product_id).get();
		
		if(p1.getDimension().getLenght()>150.00)
		{
			 for(Delivery_Man del :  deliv.findAll()){
				 if(del.getDispoDeliv()){
					 if(del.getTransport().equals("camion")){
						 listDeliv.add(del);
					 }
				 }
			 }
		}
		return listDeliv;
	
	}
	
    public AffectationImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//}
