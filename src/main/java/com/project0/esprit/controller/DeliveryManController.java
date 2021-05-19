package com.project0.esprit.controller;

import java.io.IOException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project0.esprit.datentity.Delivery_man0;
import com.project0.esprit.repository.DeliveryManRepository;
import com.project0.esprit.service.DeliveryManServiceImpl;
import com.project0.esprit.util.AffectationImpl;
import com.project0.esprit.util.FraisDeLivraison;
import com.project0.esprit.util.Prime;

@RestController
@CrossOrigin("*")
@RequestMapping("apiyes")
public class DeliveryManController {

	@Autowired
	AffectationImpl affec;
	
	@Autowired 
	FraisDeLivraison fraisDeLivraison ;
	@Autowired
	DeliveryManServiceImpl delivService;
	@Autowired 
	Prime prime;
	@Autowired
	DeliveryManRepository delivRepository;
	
	
	private byte[] pic ;
	@PostMapping("/upload")
	public @ResponseBody ResponseEntity<?>   uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException{
		 
		this.pic = file.getBytes();
		
		return ResponseEntity.status(HttpStatus.OK).body(this.pic);
		
		
	}
	
	//affectation des livreurs
	@RequestMapping(value = "/findDelivery/{Product_id}", method = RequestMethod.GET)
	@ResponseBody
	public List<Delivery_man0> findDeliveryMan (@PathVariable Long Product_id){
		
		return affec.moyenDeTransport(Product_id);
	}
	
	@PostMapping("/adddeliveryman")
   public @ResponseBody ResponseEntity<?> addDeliveryMan(@RequestBody  Delivery_man0 deliv)
   {
		
deliv.setDelivery_phot(this.pic);

		
		
		
		delivRepository.save(deliv);
		this.pic=null;
			return  ResponseEntity.status(HttpStatus.OK).body("added successfully");
		 }
	@PostMapping("/adddeliv")
	   public @ResponseBody ResponseEntity<?> addDeliv(@RequestBody  Delivery_man0 deliv)
	   {
			
			delivRepository.save(deliv);
				return  ResponseEntity.status(HttpStatus.OK).body("added successfully");
			 }
   
	@GetMapping("/showListDeliv")
   public List<Delivery_man0> getAll(){
	   return this.delivRepository.findAll();
   }
   
   @GetMapping("/delivofmonth")
   public String deliverymanof(){
	   return delivService.DeliveryManOfMounth();
   }
  
   
	@RequestMapping(value = "/findcat1/{lastname}", method = RequestMethod.GET)
	@ResponseBody
	public List<Delivery_man0> findDeliveryMan(@PathVariable String lastname) {
		
		List<Delivery_man0> liv = (List<Delivery_man0>) delivRepository.getDeliveryByDeliveryname(lastname);
		return liv;
	}

	
	@RequestMapping(value = "/findbyid/{id}", method = RequestMethod.GET)
	@ResponseBody
	public List<Delivery_man0> findDeliveryManbyId(@PathVariable Long id) {
		
		List<Delivery_man0> liv = (List<Delivery_man0>) delivRepository. getDeliveryById(id);
		return liv;
	}
	
	
	@PutMapping("/update/{deliveryMan_id}")
	@ResponseBody
	public Delivery_man0 updatedeliveryman(@PathVariable("deliveryMan_id") Long deliveryMan_id, @RequestBody Delivery_man0 delivery_Man) {
		Delivery_man0 d =delivRepository.getDeliveryById(deliveryMan_id);
		d.setDeliveryMan_lastName(delivery_Man.getDeliveryMan_lastName());
	    d.setDeliveryMan_Name(delivery_Man.getDeliveryMan_Name());
	    d.setEmail(delivery_Man.getEmail());
	    d.setTransport(delivery_Man.getTransport());
	    d.setWorkLoad(delivery_Man.getWorkLoad());
	    
d.setDelivery_phot(this.pic);

		
		
		
		
		this.pic=null;
	
		
	delivRepository.save(d);
	return d;
	}
	
	/*@PutMapping("/updatedisponibility/{deliveryMan_id}")
	public void updatedisponibility(@PathVariable("deliveryMan_id") Long deliveryMan_id){
		Delivery_Man d =delivRepository.getDeliveryById(deliveryMan_id);
		d.setDispoDeliv(false);
		
		
	}*/
	
	
	
	
	@PutMapping("/updatedispWorkload/{deliveryMan_id}")
	public void updatedispWorkload(@PathVariable("deliveryMan_id") Long deliveryMan_id){
		delivService.DispWorkload(deliveryMan_id);
		
		
	}
	
	
	
	@DeleteMapping("/delete/{delivery_id}")
	public List<Delivery_man0> deleteman(@PathVariable("delivery_id") Long delivery_id) {
		Delivery_man0 Deliveryman = delivRepository.findById(delivery_id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid deliveryman Id:" + delivery_id));
	    delivRepository.delete(Deliveryman);
	    return this.delivRepository.findAll();


	}
	
	
}
