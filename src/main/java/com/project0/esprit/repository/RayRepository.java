package com.project0.esprit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.project0.esprit.entity.Category1;
import com.project0.esprit.entity.Product1;
import com.project0.esprit.entity.Ray;


/*
 * int  Integer /  double Double / float  / Float
 *  Crud  pere >    Jpa  fils
 *  
 *  this.rayname = rayname;
		this.raytag = raytag;
		this.rayvision = rayvision;
		this.categories = categories;
 */
@Repository
public interface RayRepository extends JpaRepository<Ray, Long> {
	// findbY 
	@Query("SELECT a from Ray a WHERE rayname = ?1    ")
	public List<Ray>  getRayByName(@Param("rayname") String rayname);
	
	@Query("SELECT a from Ray a WHERE raytag = ?1    ")
	public List<Ray>  getRayByTag(@Param("raytag") String raytag);
	
	@Query("SELECT r FROM Ray r ORDER BY createdAt ASC")
	 List<Ray> findAllByDate();
	
	@Query("SELECT r FROM Ray r WHERE ray_id = ?1")
	Ray findById2(@Param("id") Long id);
	
	
	@Query("SELECT a from Ray a WHERE raytag = ?1  AND  rayname = ?2   ")
	public List<Ray>  getRayByTagAndName(@Param("raytag") String raytag,@Param("rayname") String rayname);
	
	
	@Query("SELECT a.categories from Ray a WHERE rayname =?1   ")
	public List<Ray>  getCategoriesRayName(@Param("rayname") String rayname);
	
	
	@Query("SELECT a FROM Category1 a WHERE ray_id = ?1 ")
    List<Category1> findByCategory(@Param("ray_id") Long ray_id);
	
	
	
	

}
