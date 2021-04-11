package esprit.proj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import esprit.proj.entity.Category;
import esprit.proj.entity.Product;
import esprit.proj.repository.productRepository;
import net.bytebuddy.build.HashCodeAndEqualsPlugin.Sorted;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


//algorithme qui va calculer les meilleurs produits chaque mois et les mettre dans le 1er rangé du rayon

@Service
public class BestOf {
	
	@Autowired
	productRepository product;
	
	
	public List<Product> SortBySold() {
		List<Product> sorted=product.findAll();
	     sorted.sort(new Comparator<Product>() {
	    	@Override
	    	public int compare(Product P1,Product P2){
	    		return P2.getSold()-P1.getSold();
	    	}
		});
	     return sorted;
	}
	
	
	
	
	
	}