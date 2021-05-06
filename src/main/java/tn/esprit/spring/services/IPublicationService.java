package tn.esprit.spring.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import tn.esprit.spring.entity.Publication;

public interface IPublicationService {
	
	public String AddPublication(int user_id,Publication pub) throws Exception;
	public Page<Publication> RetrievePublication(Pageable pageable);
	public void UpdatePublicationById(Publication pub, int id);
	public void DeletePublication(int id);
	public Publication GetPubById(int pubId);
	public void deletePubRedondant();
	public void DeletePostsWithoutInteraction();
	public List<Publication> AffichageDesSujetsAlaUne();
	public void AddLike(int id);
	public void AddDislike(int id);
		
	

}
