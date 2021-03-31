package com.project0.esprit.service;
import java.util.List;

import com.project0.esprit.entity.Product1;
public interface Iayproduct {
	
	
	List<Product1> getAllProducts();
	
	Product1 getOneProduct(Long id);
	
	Product1 Addproduct(Product1 p1 , byte[] imageprod, Long category_id , Long publicity_id);
	
	Product1 UpdateProduct(Product1 p1) ;
	
	boolean deleteProductByid(Long id);
	List<Product1> newProducts();
	
	
	
	

}
