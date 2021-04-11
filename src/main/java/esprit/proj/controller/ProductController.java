package esprit.proj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import esprit.proj.entity.Product;
import esprit.proj.repository.RayRepository;
import esprit.proj.repository.productRepository;
import esprit.proj.service.BestOf;
import esprit.proj.service.RayServiceImpl;
import esprit.proj.service.productServiceImpl;


@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	productServiceImpl prod_service;
	@Autowired
	RayServiceImpl ray_service;
	@Autowired
	RayRepository rayRepository;
	@Autowired
	productRepository product_rep;
	@Autowired
	BestOf Best ;
	
	@GetMapping("/triBySold")
	public List<Product> SortBySold(){
		return Best.SortBySold();
	}
	@PutMapping("/getbestproductbyrayon")
	public List<Product> getbestproductbyrayon(){
		return ray_service.updateRayon();
	}
	@PutMapping("/Promotion")
	public String Promotion () {
		return prod_service.Promotion();
		
	}
	

}