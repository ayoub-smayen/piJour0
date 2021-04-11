package com.project0.esprit.service;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.project0.esprit.entity.Product1;
public interface Iayproduct {
	
	
	List<Product1> getAllProducts();
	
	Product1 getOneProduct(Long id);
	
	Product1 Addproduct(Product1 p1 , byte[] imageprod, Long category_id , Long publicity_id);
	
	Product1 UpdateProduct(Product1 p1) ;
	
	boolean deleteProductByid(Long id);
	List<Product1> newProducts();
	
	
	
	Product1 findOne(String productId);

    // All selling products
   /* Page<Product1> findUpAll(Pageable pageable);
    // All products
    Page<Product1> findAll(Pageable pageable);
    // All products in a category
    Page<Product1> findAllInCategory(Integer categoryType, Pageable pageable);

    // increase stock
    void increaseStock(String productId, int amount);

    //decrease stock
    void decreaseStock(String productId, int amount);

    Product1 offSale(String productId);

    Product1 onSale(String productId);

    Product1 update(Product1 productInfo);
    Product1 save(Product1 productInfo);

    void delete(String productId);
	*/
	

}
