package esprit.proj.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import esprit.proj.entity.Product;
import esprit.proj.entity.Ray;
import esprit.proj.exception.ProductNotFoundException;
import esprit.proj.exception.RayNotFoundException;

public interface RayService {
	

		/*Ray findBy(Long RayId) throws RayNotFoundException;
		Ray findBy(String RayDescription) throws RayNotFoundException;*/
		//Ray findByName(String RayName) throws RayNotFoundException;
		List<Ray> findByCategory(String categories) throws RayNotFoundException;
		
		List<Ray> showAll() throws RayNotFoundException;
		Ray addRay(Ray ray);
		void DeleteById(@PathVariable("id") Long id) ;
		void updateRay(Ray ray) ;
		
		List<Product> findAllProductByrayon(Long id) throws ProductNotFoundException;
		
	}

