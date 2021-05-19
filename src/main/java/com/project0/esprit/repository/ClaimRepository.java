package com.project0.esprit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project0.esprit.datentity.Delivery_man0;
import com.project0.esprit.entity.Claim;


@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {
	@Query("SELECT a FROM Claim a WHERE subject_claim = ?1")
	public List<Claim> getPubliityBypublictyname(@Param("subject_claim") String subject_claim);
	
	@Query("SELECT a FROM Claim a WHERE idclaim= ?1")
	public Claim  getClaimById(@Param("idclaim") Long idclaim );
	@Query("SELECT a FROM Claim a WHERE a.subject = :subject")
	public List<Claim> getClaimBySubject(@Param("subject") String subject);

	@Query(value="select count(*) from claim where claim.delivery_man_id =:id",nativeQuery=true)
	int deliverymanClaims(@Param("id") Delivery_man0 deliv);
}
