package com.project0.esprit.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project0.esprit.entity.Product1;
import com.project0.esprit.entity.User1;
import com.project0.esprit.repository.ProductRepository;
import com.project0.esprit.service.CategoryService;
import com.project0.esprit.service.Iayproduct;
import com.project0.esprit.service.impl.Aproductimpl;

@CrossOrigin("*")
@RestController

@RequestMapping("/api")
public class ProductController1 {

	//Logger l  =new Logger() ;
	
	
	 private static final Logger logger = LoggerFactory.getLogger(ProductController1.class);
 
	private byte[] bytes;
	
	@Autowired
	private Iayproduct iaprod;
	
	@Autowired
	 private ProductRepository c;
	
	
	@GetMapping("/newproducts")
	
	public List<Product1> getNewproduct(){
		logger.info("product list");
		return c.getIhgff();
	}
	
	@GetMapping("/newprod")
	public List<Product1> getAllNewProd(){
		
		logger.info("new product  created ");
		return iaprod.getAllProducts();
	}
@PostMapping("/upload")
public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
	
	logger.info("upload image for  products");
	this.bytes = file.getBytes();
}

@PostMapping("/addmyprod/{category_id}/c/{publicity_id}")
public ResponseEntity<?> saveprodh(@Valid @RequestBody Product1 p1,@PathVariable("category_id") String category_id, @PathVariable("publicity_id")  String publicity_id){
	
	
	  logger.info("affectation de produit dans un category");
	
	 Product1 p2 = iaprod.Addproduct(p1, this.bytes, Long.parseLong( category_id),Long.parseLong( publicity_id));
	
	this.bytes = null;
	return ResponseEntity.status(HttpStatus.CREATED).body(p2);
	
	
}
//@RequestParam("imageFile") MultipartFile file

  @PostMapping("/addprowithImag")
  public void createBook(@Valid  @RequestBody Product1 p) throws IOException {
		p.setProductImg(this.bytes);
		c.save(p);
		this.bytes = null;
	}
	
	@PostMapping("/addproducts")
	public void add(@RequestBody   Product1 cat)
	{
		this.c.save(cat);
		
	}
	@GetMapping("/products1")
	
	public Iterable<Product1> getAll(){
		
		logger.info("all products ");
		return this.c.findAll();
	}
@GetMapping("/productAsc")
	
	public Iterable<Product1> getAllbyDate(){
		return this.c.findAllByDate();
	}

@GetMapping("/products1/{id}")

public Product1 getProductById(@PathVariable("id") Long id){
	return c.findById2(id) == null ? null :c.findById2(id) ;
}
@RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
public boolean deleteProduct(@PathVariable("id") Long id) {
	 Product1 p = c.findById2(id);
	c.deleteById(id);
	
	return true;
   //c.deleteById(id);
   //return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
}
	
	@RequestMapping(value = "/findproduct/{productname}", method = RequestMethod.GET)
	@ResponseBody
	public List<Product1> findStudents(@PathVariable String productname) {
		List<Product1> studentResponse = (List<Product1>) c.findByFirstNameAndLastName(productname);
		return studentResponse;
	}

	@RequestMapping(value = "/findproduct1/{productname}/{price}", method = RequestMethod.GET)
	@ResponseBody
	public List<Product1> findStudents2(@PathVariable String productname,@PathVariable Double price) {
		List<Product1> studentResponse =  c.findByFirstNameAndPrice(productname, price);
		return studentResponse;
		//(List<Product1>)
	}
 
	@GetMapping("/tunisiaProd")
	@ResponseBody
	public List<Product1>  getTunsiaProd(){
		
		return c.findByFirstNameAndLastName2();
	}
	
	@GetMapping("/ser")
	public ResponseEntity<?> getserachingprod(@RequestParam("productname") String productname){
		List<Product1> ps1 =c.getProductSearching(productname);
		return ResponseEntity.status(HttpStatus.OK).body(ps1);
	}
	
	@RequestMapping(value = "/findbyinterval/{price1}/{price2}", method = RequestMethod.GET)
	@ResponseBody
	public List<Product1> findStudents4(@PathVariable Double price1,@PathVariable Double price2) {
		if(price1 < price2) {
		List<Product1> studentResponse = (List<Product1>) c.findByIntervalAndPrice(price1, price2);
		return studentResponse;
		}
		
		else {
			Double m = price1;
			price1 = price2;
			m=price2;
			
			List<Product1> studentResponse = (List<Product1>) c.findByIntervalAndPrice(price1, price2);
			return studentResponse;
		}
	}

	@RequestMapping(value = "/findproductcat/{cat_id}", method = RequestMethod.GET)
	@ResponseBody
	public List<Product1> findStudents3(@PathVariable Long cat_id) {
		List<Product1> studentResponse = (List<Product1>) c.findByCategory(cat_id);
		return studentResponse;
	}
	
	/*eya*/
	
	/*@GetMapping("/dashboard/produitbest")
	//@Secured("ROLE_ADMIN")
	private List<Product1>  getBestprod(){
		List<Product1>  bestproduct =new ArrayList<>();
		List<Product1> p1 = c.findAll();
		
		for (Product1  x: p1 ) {
			
			if(x.getQuantity() <20) {
				bestproduct.add(x);
			}
			
		}
		
		 return bestproduct;*/
		
	//	List<Product1> lp1 = c.getBesProducts();
		 //return  lp1;
				 //ResponseEntity.status(201).body(lp1);
	//}


}
