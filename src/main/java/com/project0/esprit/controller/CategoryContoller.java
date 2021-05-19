package com.project0.esprit.controller;

/*
 * 
 * category  crud  
 * 
 * generate new categroy  for  all  product added  
 */
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project0.esprit.entity.Category1;
import com.project0.esprit.entity.Product1;
import com.project0.esprit.entity.Ray;
import com.project0.esprit.entity.User1;
import com.project0.esprit.repository.CategoryRepository;
import com.project0.esprit.repository.ProductRepository;
import com.project0.esprit.repository.RayRepository;
import com.project0.esprit.repository.UserRepository1;

import  com.project0.esprit.service.CategoryService;


class Responsive {
	
	List<Product1> pr ;
	Category1  cv ;
	public Responsive(List<Product1> pr, Category1 cv) {
		super();
		this.pr = pr;
		this.cv = cv;
	}
	public List<Product1> getPr() {
		return pr;
	}
	public void setPr(List<Product1> pr) {
		this.pr = pr;
	}
	public Category1 getCv() {
		return cv;
	}
	public void setCv(Category1 cv) {
		this.cv = cv;
	}
	
}


class RayCat {
	
	   Ray r ;
	   List<Category1> cat ;
	public RayCat(Ray r, List<Category1> cat) {
		super();
		this.r = r;
		this.cat = cat;
	}
	public RayCat() {
		super();
	}
	public Ray getR() {
		return r;
	}
	public void setR(Ray r) {
		this.r = r;
	}
	public List<Category1> getCat() {
		return cat;
	}
	public void setCat(List<Category1> cat) {
		this.cat = cat;
	}
	   
	   
}
@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class CategoryContoller {
 
	@Autowired
	 private CategoryRepository categoryRepository;
	
	
	@Autowired 
	private ProductRepository prodrep;
	
	
	@Autowired
	private RayRepository ray; 
	
	
	
	
	

	CategoryService catservice =new CategoryService() ;
	
	
	
	
@GetMapping("/catray/{ray_id}")
	
	public ResponseEntity<?> gecaatray(@PathVariable("ray_id")Long ray_id ){
	
	Ray r= ray.findById(ray_id).get();
	
	RayCat rc = new RayCat() ; 
	
	rc.setR(r);
	
	List<Category1> lc = ray.findByCategory(ray_id);
	rc.setCat(lc);
	
	   
		return ResponseEntity.status(HttpStatus.OK).body(rc);
	}

	
	
	
	@PostMapping("/add")
	public @ResponseBody ResponseEntity<?> add(@RequestBody   Category1 cat)
	{
		return  ResponseEntity.status(HttpStatus.CREATED).body(  categoryRepository.save(cat));
		
	}
	@GetMapping("/cat")
	
	public Iterable<Category1> getAll(){
		return this.categoryRepository.findAll();
	}
	
	@DeleteMapping("/cat/{id}")
	
	public void suppbyid(@PathVariable("id") Long category_id)
	{
		categoryRepository.deleteById(category_id);
	}
	
@GetMapping("/cat/{id}")
	
	public @ResponseBody ResponseEntity<?> getAllProdBycategory(@PathVariable("id") Long id){
	
	
	 Map<String  ,  List<Product1>> mp   = new HashMap<>();
	   
	  Category1  c  = categoryRepository.findById(id).get();
	  
	  
	  List<Product1>  ml  = prodrep.findByCategory(c.getCategory_id());
	  
	  
	  mp.put(c.getCategoryName(), ml);
	  Responsive res = new Responsive(ml,c);
	  
	  
	   
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}
	@RequestMapping(value = "/findcat/{categoryName}", method = RequestMethod.GET)
	@ResponseBody
	public List<Category1> findStudents(@PathVariable String categoryName) {
		List<Category1> studentResponse = (List<Category1>) categoryRepository.findByNameEndsWith(categoryName);
		return studentResponse;
	}

	
	
	@PutMapping("/putcat/{category_id}")
	public @ResponseBody ResponseEntity<?> updateCategory(@PathVariable("category_id") Long category_id,@RequestBody Category1 cat)
	{
		
		cat.setCategory_id(category_id);
		return    ResponseEntity.status(HttpStatus.CREATED).body(  categoryRepository.save(cat));
		
	}

	
}

/*
 * 
 *  {

       
        "role": 2,
        "membre_username": "eya",
        "password": "tfgyhuji",
        "confirm_password": "edxcftgyhu",
        "email": "a@gmail.com",
        "group": "fcgvbhjn",
        "city": "rftgyhuj",
        "address": "dxcfgvhuj",
        "phone_number": "25896321"
    }
 * */
