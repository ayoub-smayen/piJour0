package com.project0.esprit.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project0.esprit.entity.Publicity;
import com.project0.esprit.repository.PublicityRepository;
import com.project0.esprit.repository.UserRepository;
import com.project0.esprit.datentity.User;
import com.project0.esprit.entity.LikesCmt;


@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class PublicityController {

	
	
	@Autowired
	private UserRepository userrep;
	
	@Autowired
	 private PublicityRepository categoryRepository;
	 //publicty user_id ???
	
	
	@GetMapping("/cookiepub")
	public @ResponseBody ResponseEntity<?> readCookie(@CookieValue(value = "user0", defaultValue = "pub") String username) {
		
		Map<String ,  Object> m  = new HashMap<String, Object>();
		if(!userrep.findByUsername(username).equals(null)) {
			User u = userrep.findByUsername(username);
		    Cookie cookie = new Cookie("user0", username);
		    
			//  m.put("pubuser", u.getPublicity());
			  return ResponseEntity.status(HttpStatus.FOUND).body(m);
		}
		
		else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("error  not found");
		
	    
	}
	
	
	@GetMapping("/currentpublicities")
	public ArrayList<Publicity> current(){

		Date Today=new java.util.Date();  
		List<Publicity> publicities = categoryRepository.findAll();
		Iterator<Publicity> publicitiesIterator = publicities.iterator();
		int i=0;
		Publicity p;
		ArrayList<Publicity> CurrentPublicities =new ArrayList<Publicity>();
		/**do {
			if ((publicitiesIterator.next().getStartDateP().before(Today)) && (publicitiesIterator.next().getEndDateP().after(Today)))
				{
					p= publicities.get(i);
					CurrentPublicities.add(p);
				}
			i++;
			}
			while (publicitiesIterator.hasNext());*/
		
		for (Publicity p2 : publicities){
			
			if (p2.getCreatedAt().getDate() == (new Date().getDate()+1)){
				CurrentPublicities.add(p2);
			}
			
		}
		
		
		
		return CurrentPublicities;
	}
	
	
	@PostMapping("/addpub")
	public void add2(@RequestBody   Publicity cat)
	{
		this.categoryRepository.save(cat);
		
	}
	
	@GetMapping("/pub")
	
	public List<Publicity> getAll2(){
		return this.categoryRepository.findAll();
	}
	
	@DeleteMapping("/delpub/{id}")
	@ResponseBody
	public ResponseEntity<Object>  delCategory(@PathVariable Long id) {
		 categoryRepository.findById(id);
		categoryRepository.deleteById(id);
		
		 return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/findpub/{categoryName}", method = RequestMethod.GET)
	@ResponseBody
	public List<Publicity> findpublicity(@PathVariable String publictyname) {
		List<Publicity> studentResponse = (List<Publicity>) categoryRepository.getPubliityBypublictyname(publictyname);
		return studentResponse;
	}
	
}
