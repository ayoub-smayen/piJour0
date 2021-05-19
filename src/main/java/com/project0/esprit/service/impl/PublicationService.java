package com.project0.esprit.service.impl;

import java.security.Principal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.project0.esprit.datentity.Publication;
import com.project0.esprit.datentity.User;
import com.project0.esprit.repository.PublicationRepository;
import com.project0.esprit.repository.UserRepository;
import com.project0.esprit.service.IPublicationInterface;
@Service
public class PublicationService implements IPublicationInterface {
	
	
	
	
	PublicationRepository publicationRep;
	
	
	private  UserRepository userRepository;
	
	@Autowired
	PublicationService(PublicationRepository publicationRep,UserRepository userRepository )
	{
		this.publicationRep = publicationRep;
		this.userRepository = userRepository;
	}
	

	@Override
	public Publication AddPublication(Publication c, Principal p) {
		User user = userRepository.findOneByUsername(p.getName());
	      c.setUser(user);
	      
	      Publication pub = publicationRep.save(c);
	      return pub;
	      
		//return null;
	}

	@Override
	public List<Publication> RetrievePublication() {
		
		
		return this.publicationRep.findAll();
	}

	@Override
	public void UpdatePublicationById(Publication pub, Long id) {
		this.publicationRep.save(pub);
		
	}

	@Override
	public void DeletePublication(Long id) {
		this.publicationRep.deleteById(id);
		
	}

	@Override
	public Publication GetPubById(Long pubId) {
		return publicationRep.findById(pubId).get();
	}
	public static int min(int... numbers) {
        return Arrays.stream(numbers)
          .min().orElse(Integer.MAX_VALUE);
    }
public static int max(int... numbers) {
        return Arrays.stream(numbers)
          .max().orElse(Integer.MAX_VALUE);
    }
    public static double levenshtein(String s0, String s1) {
	int len0 = s0.length()+1;
	int len1 = s1.length()+1;
    int m = max(len0, len1);
	// the array of distances
	int[] cost = new int[len0];
	int[] newcost = new int[len0];
 
	// initial cost of skipping prefix in String s0
	for(int i=0;i<len0;i++) cost[i]=i;
 
	// dynamicaly computing the array of distances
 
	
// transformation cost for each letter in s1
	for(int j=1;j<len1;j++) {
 
		// initial cost of skipping prefix in String s1
		newcost[0]=j-1;
 
		// transformation cost for each letter in s0
		for(int i=1;i<len0;i++) {
 
			// matching current letters in both strings
			int match = (s0.charAt(i-1)==s1.charAt(j-1))?0:1;
 
			// computing cost for each transformation
			int cost_replace = cost[i-1]+match;
			int cost_insert  = cost[i]+1;
			int cost_delete  = newcost[i-1]+1;
 
			// keep minimum c

// keep minimum cost
			newcost[i] = min(cost_insert, cost_delete, cost_replace);
		}
 
		// swap cost/newcost arrays
		int[] swap=cost; cost=newcost; newcost=swap;
	}
 
// the distance is the cost for transforming all letters in both strings
	return (cost[len0-1]*100)/m;
    }
    @Scheduled(fixedDelay= 1000*60)
	@Override
	public void deletePubRedondant() {
    	List<String> pub = publicationRep.findpubtxt();
		for (int i = 0; i < pub.size(); i++) {
			for (int j = i+1; j < pub.size(); j++) {
				if (levenshtein(pub.get(i), pub.get(j))<50.0) {
					publicationRep.deleteSujetRedondant(pub.get(j));	
				}
			}
			
		}
		
	}


	@Override
	public void DeletePostsWithoutInteraction() {
		List<Publication> p = publicationRep.findAll();
    	for (int i = 0; i < p.size(); i++) {
			if (publicationRep.NbreCommentsBypub(p.get(i))<=2 && p.get(i).getLike_count()<=2 && p.get(i).getDislike_count()<=2) {
				
				publicationRep.deleteById(p.get(i).getId());
				publicationRep.DeleteCommentsByPub(p.get(i));
				
			}
		}
		
	}


	@Override
	public void AddLike(Long id) {
		publicationRep.findById(id).map(p -> {
			p.setLike_count(p.getLike_count()+1);
			publicationRep.save(p);
			return p;
		});
		
	}


	@Override
	public void AddDislike(Long id) {
		publicationRep.findById(id).map(p -> {
			p.setDislike_count(p.getDislike_count()+1);
			publicationRep.save(p);
			return p;
		});
		
	}


	@Override
	public List<Publication> AffichageDesSujetsAlaUne() {
		Comparator<Publication> comp = (x,y) -> y.getComments().size()-x.getComments().size();
    	return publicationRep.findAll().stream().sorted(comp).collect(Collectors.toList());
	}

}
