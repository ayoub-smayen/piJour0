package com.project0.esprit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project0.esprit.entity.Stock;

@Repository
public interface  StockRepository extends  CrudRepository<Stock, Long>  {

	@Query(value="SELECT p.product_id from products p join stock s  on p.stock_id = s.id  where   s.amount<10 ",nativeQuery=true)
	List<Long> missingProduct();
	 
}
