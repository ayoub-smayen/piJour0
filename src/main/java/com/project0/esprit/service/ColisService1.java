package com.project0.esprit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.project0.esprit.entity.Colis;
import com.project0.esprit.repository.ColisRepository;

@Service
public class ColisService1 {

	@Autowired
	ColisRepository colisRepo ;
	
	public List<Colis> getAllEmployees(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
 
        Page<Colis> pagedResult = colisRepo.findAll(paging);
         
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Colis>();
        }
    }
	
	
	
}

