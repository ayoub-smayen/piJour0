package com.project0.esprit.repository;


import org.springframework.data.jpa.repository.Query;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.project0.esprit.entity.Euser;

@Repository
public interface EuserRepository extends CrudRepository<Euser, Long> {


	@Query("SELECT a FROM Euser a WHERE user_id = ?1")
	public Euser findByIdd(@Param(value="user_id" ) Long user_id);

	@Query("select count(u)  from Euser  u  WHERE  u.city = ?1 ")
	public int getCityCount(@Param(value = "city")  String city);
	
	@Query("select count(u)  from Euser  u  WHERE  u.sexe = ?1 ")
	public int getSexeCount(@Param(value = "sexe")  String sexe);
	
	@Query("select count(u)  from Euser  u  WHERE  u.age = ?1 ")
	public int getAgeCount(@Param(value = "age")  String age);
	
	
	
}
