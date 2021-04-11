package com.project0.esprit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project0.esprit.entity.Claim;
import com.project0.esprit.repository.ClaimRepository;

@Service
public class ClaimServiceImpl implements ClaimService {

	@Autowired
	ClaimRepository claimRepository;
	@Override
	public void AddLivreur(Claim claim) {
		claimRepository.save(claim);
		
	}

	@Override
	public List<Claim> RetrieveClaim() {
	List <Claim> claim= (List <Claim>) claimRepository.findAll();
		return claim;
	}

	@Override
	public void DeleteClaim(Long id) {
		this.claimRepository.deleteById((Long) id);
		
	}

	@Override
	public void UpdateClaim(Claim claim, Long id) {
		this.claimRepository.save(claim );
		
	}

}
