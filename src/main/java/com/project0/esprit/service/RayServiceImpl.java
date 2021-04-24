package com.project0.esprit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.project0.esprit.entity.Product1;
import com.project0.esprit.entity.Ray2;
import com.project0.esprit.repository.ProductRepository;
import com.project0.esprit.repository.RayRepository;
import com.project0.esprit.repository.RayRepository2;



@Service

public class RayServiceImpl implements RayService  {
	
	@Autowired
	RayRepository2 rayRepository;
	@Autowired
	ProductRepository product_rep;
	

	@Override
	public List<Ray2> findByCategory(String categories) throws Exception  {
		List<Ray2> rayons = rayRepository.findByCategory(categories);
		if (rayons.isEmpty() || rayons == null)
			throw new Exception();
		else
			return rayons;
	}

	@Override
	public List<Ray2> showAll() throws Exception{
		List<Ray2> sections = rayRepository.findAll();
		if (sections.isEmpty() || sections == null)
		     throw new Exception();
		else
			return sections;
	}

	@Override
	public Ray2 addRay(Ray2 ray) {
		
		Ray2 r = rayRepository.save(ray) ;
		return r ;
	}

	@Override
	public void updateRay(Ray2 ray) {
		rayRepository.save(ray);
		
	}

	@Override

	public void DeleteById(@PathVariable("id") Long id) {
		
		rayRepository.deleteById(id);
	}

	public void DeleteAll() {
		rayRepository.deleteAll();		
	}
	/*
	@Override
	public List<Product1> findAllProductByrayon(Long id) throws Exception  
	{
		List<Product1> products = product_rep.findAllProductByrayon(id);
		if (products.isEmpty() || products == null)
			throw new Exception();
		else
			return products;
	}
	
*/
	/*public List<Product1> updateRayon(){
		List<Long> ray_id = product_rep.findRayon_id();
		List<Product1> best_products = new ArrayList<Product1>();
		for (int i = 0 ; i < ray_id.size(); i++) {
			rayRepository.findById((long)ray_id.get(i)).map(r ->{
				r.setBestProduct(product_rep.findBestProduct(product_rep.findBestProductByrayId(r.getRayId())));
				rayRepository.save(r);
				best_products.add(product_rep.findBestProduct(product_rep.findBestProductByrayId(r.getRayId())));
				return r;
			});
			
		}
		
		return best_products;
	}
	
	*/
@Scheduled(fixedDelay= 1000*60)
	public void UpdateCapacity(){
		List<Ray2> ray = rayRepository.findAll();
		for (int i = 0; i < ray.size(); i++) {
			ray.get(i).setCapacity(rayRepository.UpdateSumCapacityRayon(ray.get(i)));
			rayRepository.save(ray.get(i));
			
		}
	}


}
