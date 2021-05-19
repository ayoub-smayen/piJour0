package com.project0.esprit.service;

import java.security.Principal;
import java.util.List;




import com.project0.esprit.datentity.Publication;

public interface IPublicationInterface {

	public Publication AddPublication( Publication c, Principal p);
	public List<Publication> RetrievePublication();
	public void UpdatePublicationById(Publication pub, Long id);
	public void DeletePublication(Long id);
	public Publication GetPubById(Long pubId);
	
	
	public void deletePubRedondant();
	public void DeletePostsWithoutInteraction();
	public void AddLike(Long id);
	public void AddDislike(Long id);
	public List<Publication> AffichageDesSujetsAlaUne();
}
