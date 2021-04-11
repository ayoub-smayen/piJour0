package com.project0.esprit.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.validation.Valid;

import org.hibernate.criterion.BetweenExpression;
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

import com.project0.esprit.entity.Delivery_Man;
import com.project0.esprit.repository.DeliveryManRepository;


@RestController
@CrossOrigin("*")
@RequestMapping("api")
public class DeliveryManController {
	
	
	 
	@Autowired
	DeliveryManRepository delivRepository;
	
	private byte[] pic ;
	@PostMapping("/upload")
	public @ResponseBody ResponseEntity<?>   uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException{
		 
		this.pic = file.getBytes();
		
		return ResponseEntity.status(HttpStatus.OK).body(this.pic);
		
		
	}
	
	@PostMapping("/adddeliveryman")
   public @ResponseBody ResponseEntity<?> addDeliveryMan(@RequestBody @Valid Delivery_Man deliv)
   {
		//Character[] num = {'1','2','3','4','5','6','7','8','9'};
		
		
		
		/**if (3<=(deliv.getDeliveryMan_Name().length())&&(deliv.getDeliveryMan_Name().length()<8) ) {
			
			for (int i = 0; i < num.length; i++) {
				if (deliv.getDeliveryMan_Name().contains(num[i].toString())) {
					
					return ResponseEntity.status(HttpStatus.OK).body("can not add ");
				}
			}
		} 
		
		
		else **/
deliv.setDelivery_phot(this.pic);
		
		this.pic=null;
		
		
		delivRepository.save(deliv);
			return  ResponseEntity.status(HttpStatus.OK).body("added successfully");
		 }
   
	@GetMapping("/showListDeliv")
   public List<Delivery_Man> getAll(){
	   return this.delivRepository.findAll();
   }
   
	@RequestMapping(value = "/findcat1/{deliveryMan_lastname}", method = RequestMethod.GET)
	@ResponseBody
	public List<Delivery_Man> findStudents123(@PathVariable String lastname) {
		
		List<Delivery_Man> studentResponse = (List<Delivery_Man>) delivRepository. getDeliveryByDeliveryname(lastname);
		return studentResponse;
	}

	@PutMapping("/update/{deliveryMan_id}")
	@ResponseBody
	public Delivery_Man updatedeliveryman(@PathVariable("deliveryMan_id") Long deliveryMan_id, @RequestBody Delivery_Man delivery_Man) {
		Delivery_Man d =delivRepository.getDeliveryById(deliveryMan_id);
		d.setDeliveryMan_lastName(delivery_Man.getDeliveryMan_lastName());
	    d.setDeliveryMan_Name(delivery_Man.getDeliveryMan_Name());
	    d.setEmail(delivery_Man.getEmail());
	    d.setTransport(delivery_Man.getTransport());
	    d.setWorkLoad(delivery_Man.getWorkLoad());
	
		
	delivRepository.save(d);
	return d;
	}
	
	@DeleteMapping("/delete/{delivery_id}")
	public String deleteman(@PathVariable("delivery_id") Long delivery_id) {
		Delivery_Man Deliveryman = delivRepository.findById(delivery_id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid deliveryman Id:" + delivery_id));
	    delivRepository.delete(Deliveryman);
	    return "redirect:/index"; }




}
