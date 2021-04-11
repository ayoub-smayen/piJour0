package com.project0.esprit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project0.esprit.repository.DeliveryManRepository;
import com.project0.esprit.util.FraisDeLivraison;





@RestController
@CrossOrigin("*")
public class FraisLiv {
	@Autowired 
	FraisDeLivraison fraisDeLivraison ;
	@Autowired 
	private DeliveryManRepository delivery ;

	@GetMapping ("/frais/{id_deliv}/{id_product}")
public int getfrais (@PathVariable("id_deliv") Long id_deliv, @PathVariable("id_product") Long id_product,@RequestParam("longitude") Long f ,@RequestParam("latitude") Long g ) {
	
	return fraisDeLivraison.livraisonfrais(id_deliv,id_product,f,g);
	
	
	
	/*@PostMapping("/adddelivery")
	public void add(@RequestBody Delivery   dv)
	{
		this.delivery.save(dv);
		
	}*/
	

}
}