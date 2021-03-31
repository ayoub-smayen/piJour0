package com.project0.esprit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project0.esprit.entity.Category1;
import com.project0.esprit.entity.Product1;
import com.project0.esprit.entity.User1;


@Repository
public interface ProductRepository extends JpaRepository<Product1, Long> {
	
	@Query("SELECT a FROM Product1 a WHERE productname = ?1")
    List<Product1> findByFirstNameAndLastName(@Param("productname") String productname);
 
	
	@Query("SELECT a  from Product1 a WHERE codebar like '619%' ")
	List<Product1> findByFirstNameAndLastName2();
	

	@Query("SELECT r FROM Product1 r ORDER BY createdAt ASC")
	 List<Product1> findAllByDate();
	
	@Query("SELECT r FROM Product1 r WHERE product_id = ?1")
	Product1 findById2(@Param("id") Long id);
	
	@Query("SELECT a FROM Product a WHERE productname = ?1 AND price <= ?2")
    List<Product1> findByFirstNameAndPrice(@Param("productname") String productname,@Param("price") Double price);
 
	@Query("SELECT a FROM Product1 a WHERE price  > ?1 AND price <= ?2")
    List<Product1> findByIntervalAndPrice(@Param("price1") Double price1 ,@Param("price2") Double price2 );
 
	
	
	@Query("SELECT a FROM Product1 a WHERE category_id = ?1 ")
    List<Product1> findByCategory(@Param("cat_id") Long cat_id);
	
	
	@Query("select a from Product1 a  WHERE DATEDIFF(date(created_at) , date(NOW())) <=1  ")
	
	List<Product1> getIhgff();
 
	
	@Query("select a from Product1 a  WHERE  productname  like %?1%")
	List<Product1> getProductSearching(@Param("productname") String productname);

	
	
}
