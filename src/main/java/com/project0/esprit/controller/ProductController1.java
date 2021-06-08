package com.project0.esprit.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project0.esprit.datentity.RoleEnum;
import com.project0.esprit.datentity.User;
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
	
	
@GetMapping("/productcomment/{product_id}")
	
	public List<Product1> getproductcoment(@PathVariable("product_id") Long product_id){
		logger.info("product list");
		return c.JoinProductComment(product_id);
	}
	
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
//@RequestParam("imageFile") MultipartFile file @Valid

  @PostMapping("/addprowithImag")
  public @ResponseBody ResponseEntity<?>   createBook(  @RequestBody Product1 p) throws IOException {
		p.setProductImg(this.bytes);
		p.setLike(0);
		p.setDeslike(0);
		c.save(p);
		this.bytes = null;
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(p) ;
	}
	
	@PostMapping("/addproducts")
	public void add(@RequestBody   Product1 cat)
	{
		this.c.save(cat);
		
	}
	@GetMapping("/productstunsi1")
	
	public ResponseEntity<?> getAll(){
		//Iterable<Product1> 
		List<Product1> p2 = new ArrayList<>();
		List<Map<String , Object> > l2 = new ArrayList<>();
		
		
		logger.info("all products ");
		Locale l = new Locale("ar","TN");
		 NumberFormat cuurencyFormat = NumberFormat.getCurrencyInstance(l);
		List<Product1>  p1 = this.c.findAll();
		for(Product1 p3 : p1) {
			Map<String , Object> map1 = new HashMap<>();
			map1.put("id", p3.getProduct_id());
			map1.put("name", p3.getProductname());
			map1.put("brand", p3.getBrand());
			map1.put("comments", p3.getComments());
			
			map1.put("image", p3.getProductImg());
			map1.put("codebar","#" + p3.getCodebar());
			
			map1.put("price",cuurencyFormat.format(p3.getPrice()));
			map1.put("remise_price",cuurencyFormat.format(p3.getRemise_price()));
			
			map1.put("price_finale", cuurencyFormat.format(p3.getPrice()-p3.getRemise_price()));
			
			l2.add(map1);
			
		}
		return ResponseEntity.status(HttpStatus.OK).body(l2);
	}
	
@GetMapping("/products1")
	
	public ResponseEntity<?> getAll2(){
		//Iterable<Product1> 
		
		return ResponseEntity.status(HttpStatus.OK).body(c.findAll());
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
 
	
	
	
	@GetMapping("/pr")
	public @ResponseBody ResponseEntity<?> getProductfilter( @RequestParam ("product_name") String product_name){
		List<Product1> prt  = new ArrayList<>();
		Date d = new Date();
	    System.out.println(product_name);
		
	        if (product_name.equals("")) {
	            return  ResponseEntity.status(HttpStatus.FOUND).body( c.findAll());
	        } else {
	             
	        
	      prt  =   c.findAll().stream()
	                .filter(
	                    u -> c.getProductSearching(u.getProductname()).stream().anyMatch(p->
	                    	p.getProductname().contains(product_name)
	                    )
	                    
	                       
	                ).collect(Collectors.toList());
	        }
	        
	    	return ResponseEntity.status(HttpStatus.OK).body(prt);
	   
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
	@GetMapping("/serprodprice")
	public ResponseEntity<?> getserachingprodprice(@RequestParam("productname") String productname,@RequestParam("price") Double price){
		List<Product1> ps1 =c.findByFirstNameAndPrice(productname, price);
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
	
    
	
	  @PutMapping("/updateprod/{product_id}/{quantity}")
	  @ResponseBody 
	  public  ResponseEntity<?>   updateProduct(@PathVariable("product_id") Long product_id , @PathVariable("quantity") Integer quantity) {
		  
		   Product1  pl  = c.findById2(product_id) ; 
		 int month =   pl.getCreatedAt().getDate()+30;
		   
		   pl.setProduct_id(pl.getProduct_id());
		    pl.decrementquantity(quantity);
		    
		   // c.save(pl);
		    
		     return  ResponseEntity.status(HttpStatus.FOUND).body(c.save(pl));
		     
		   
		  
	  }
	  
	  
	
	
	
	


}
