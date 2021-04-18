package tn.esprit.spring.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entity.Publication;

public interface IPublicationService {
	
	public String AddPublication(int user_id,Publication pub) throws Exception;
	public List<Publication> RetrievePublication();
	public void UpdatePublicationById(Publication pub);
	public void DeletePublication(int id);
	public Publication GetPubById(int pubId);
	public void deletePubRedondant();
	public void DeletePostsWithoutInteraction();
	public List<Publication> AffichageDesSujetsAlaUne();
		
	

}
