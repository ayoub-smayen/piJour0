package com.project0.esprit.service;

import java.util.List;

import com.project0.esprit.entity.Claim;



public interface ClaimService {
	public void AddLivreur(Claim claim);
	public List<Claim> RetrieveClaim();
	public void DeleteClaim(Long id);
	void UpdateClaim(Claim claim, Long id);
}
