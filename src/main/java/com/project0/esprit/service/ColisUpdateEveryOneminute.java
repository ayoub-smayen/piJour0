package com.project0.esprit.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.project0.esprit.entity.Colis;
import com.project0.esprit.entity.Etat;
import com.project0.esprit.repository.ColisRepository;

@Service 
public class ColisUpdateEveryOneminute {
	
	
	@Autowired
	ColisRepository colisRepository ;
	
	@Scheduled(cron = "0 0/2 * 1/1 * ?")
	public void sendNotif() {
		
		for(Colis cv :colisRepository.findAll() )
		System.out.println(cv.getPrenom());
		
	}
	
	
	
	
	
	
	
	/*@Scheduled(cron = "0 0/2 * 1/1 * ?")
	@Transactional
	public List<Colis> ColisEnattent(){
		
		List<Colis> lcol = colisRepository.findAll();
		
		for(Colis b : lcol ) {
			colisRepository.findById(b.getColi_id()).map(etr->{
				// etr.setColi_id(etr.getColi_id());
				 System.out.println(etr.getEtatcolis().toString().equals(Etat.EnAttent.toString()));
				  if(etr.getEtatcolis().toString().equals(Etat.EnAttent.toString())) {
					  System.out.println(etr.getEtatcolis().toString());
					  etr.setEtatcolis(Etat.enCours);
					  System.out.println("update");
					  System.out.println(etr.getEtatcolis());

					  return colisRepository.save(etr);

					  
				  }
				  else {
					  System.out.println("eerrer");
					  return "pass";
				  }
				 // return colisRepository.save(etr);
			});
		}
		
		
		// colisRepository.saveAll(lcol);
		
		for (Colis j : lcol) {
			System.out.println(j.getEtatcolis().toString());
		}
		return lcol;
	}
	*/
	

}
