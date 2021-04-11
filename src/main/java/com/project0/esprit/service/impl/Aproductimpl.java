package com.project0.esprit.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project0.esprit.entity.Category1;
import com.project0.esprit.entity.Product1;
import com.project0.esprit.entity.Publicity;
import com.project0.esprit.repository.CategoryRepository;
import com.project0.esprit.repository.ProductRepository;
import com.project0.esprit.repository.PublicityRepository;
import com.project0.esprit.service.Iayproduct;


@Service
public class Aproductimpl  implements  Iayproduct{
	
	
	byte[] image;
	public final ProductRepository productrepo;
	 public final CategoryRepository cat;
	 public final PublicityRepository pub1;
	@Autowired
	Aproductimpl(ProductRepository productrepo, CategoryRepository cat, PublicityRepository pub1){
		this.pub1 = pub1;
		this.cat = cat;
		this.productrepo = productrepo;
	}

	@Override
	public List<Product1> getAllProducts() {
		// TODO Auto-generated method stub
		return productrepo.findAll();
		//return null;
	}

	@Override
	public Product1 getOneProduct(Long id) {
		// TODO Auto-generated method stub
		return productrepo.findById2(id);
		//return null;
	}

	@Override
	public Product1 Addproduct(Product1 p1, byte[] imageprod, Long category_id , Long publicity_id) {
		
		
		p1.setProductImg(imageprod);
		p1.setOrders(null);
	  
		 /*cat.findById(category_id).map(c ->{
			 p1.setCategory(c);
			 return  productrepo.save(p1);
			 
		 });
		 pub1.findById(publicity_id).map(pub->{
			 p1.setPublicity(pub);
			 return productrepo.save(p1);
		 });
		 */
		
		Category1   c1 = cat.findById(category_id).get();
		Publicity pub = pub1.findById(publicity_id).get();
		
		//p1.setCategory(p1.getCategory());
		//p1.setPublicity(p1.getPublicity());
		
		p1.setCategory(c1);
		p1.setPublicity(pub);
		
		return productrepo.save(p1);
				//productrepo.save(p1);
		//return p1;
		
		
		// TODO Auto-generated method stub
		//return null;
	}

	@Override
	public Product1 UpdateProduct(Product1 p1) {
		// TODO Auto-generated method stub
		
		
		
		 return  productrepo.save(p1);
		
		//return null;
	}

	@Override
	public boolean deleteProductByid(Long id) {
		// TODO Auto-generated method stub
		if(!id.equals(null)) {
			productrepo.deleteById(id);
			return true;
		}
		return false ;
	}

	@Override
	public List<Product1> newProducts() {
		// TODO Auto-generated method stub
		return productrepo.getIhgff();
		//return null;
	}

	@Override
	public Product1 findOne(String productId) {
		// TODO Auto-generated method stub
		
		return productrepo.findById2(Long.parseLong(productId));
		//return null;
	}
/*
	@Override
	public Page<Product1> findUpAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Product1> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Product1> findAllInCategory(Integer categoryType, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void increaseStock(String productId, int amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void decreaseStock(String productId, int amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product1 offSale(String productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product1 onSale(String productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product1 update(Product1 productInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product1 save(Product1 productInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String productId) {
		// TODO Auto-generated method stub
		
	}
*/

	@Override
	public void getVisited(Long productId) {
		// TODO Auto-generated method stub
		
		Product1 product =  productrepo.findById2(productId);
		product.setProductViews(product.getProductViews()+1);
		productrepo.save(product);
		
	}

	@Override
	public List<Product1> getProductsByMainCategory(String mainCategoryName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product1> getProductsByCategory(Category1 category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product1> getAllProducts2() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product1 getProductById(Long productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Product1 product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long productId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Product1> sort(List<Product1> products, String sortType) {
		if(sortType.equals("0")){
			Collections.sort(products, Product1.Comparators.PRICE);
		}
		if(sortType.equals("1")){
			Collections.sort(products, Product1.Comparators.PRICE);
			Collections.reverse(products);
		}
		return products;
	}
}
