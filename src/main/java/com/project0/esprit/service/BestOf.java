package com.project0.esprit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project0.esprit.entity.Product1;
import com.project0.esprit.repository.ProductRepository;

import net.bytebuddy.build.HashCodeAndEqualsPlugin.Sorted;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


//algorithme qui va calculer les meilleurs produits chaque mois et les mettre dans le 1er rangé du rayon

@Service
public class BestOf {
	
	@Autowired
	ProductRepository product;
	
	
	public List<Product1> SortBySold() {
		
		List<Product1> sorted=product.findAll();
	     sorted.sort(new Comparator<Product1>() {
	    	@Override
	    	public int compare(Product1 P1,Product1 P2){
	    		Double k  = P2.getPrice()-P1.getPrice();
	    		return Integer.parseInt(k.toString() ) ;
	    	}
		});
	     return sorted;
	}
	
	
	
	
	
	}
