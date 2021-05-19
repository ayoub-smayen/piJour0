package com.project0.esprit.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project0.esprit.entity.Publicity;
import com.project0.esprit.repository.FavouriteRepository;
import com.project0.esprit.repository.ProductRepository;
import com.project0.esprit.repository.PublicityRepository;
import com.project0.esprit.repository.UserRepository;
import com.project0.esprit.datentity.Favourite;
import com.project0.esprit.datentity.User;
import com.project0.esprit.entity.LikesCmt;
import com.project0.esprit.entity.Product1;


@RestController
@CrossOrigin("*")
@RequestMapping("api1")
public class PublicityController {

	
	
	@Autowired
	private ProductRepository prodrep;
	
	@Autowired
	 private PublicityRepository categoryRepository;
	
	@Autowired
	private FavouriteRepository favrepo;
	
	@Autowired
	private UserRepository userepo;
	
	@PostMapping("/addpub")
	public void add2(@RequestBody   Publicity cat)
	{
		this.categoryRepository.save(cat);
		
	}
	@PutMapping("/affpunuser/{publicity_id}")
	private ResponseEntity<?> postFavpub(Principal p, @PathVariable("publicity_id") Long publicity_id) {
		User u = userepo.findByUsernameAndFetchRoles(p.getName());
		//Favourite f = favrepo.getUserFavourite(u);
		
		Publicity p2 =categoryRepository.findById(publicity_id).get();
		//p2.setPublictyBody(u.getUsername() + " pub");
		//p2.setPublictyname(u.getUsername()+"publicity for ^product");
		
		//p2.setPublictytag(u.getFavourite().getFavourite_title());

		//p2.setProducts(u.getFavourite().getProducts());
		/*u.getFavourite().getProducts().stream().map(y->{
			p2.setPublicity_id(publicity_id);
			y.setPublicity(p2);
			prodrep.save(y);
			return categoryRepository.save(p2);
		});
			*/	
		for (Product1 p3 : u.getFavourite().getProducts()) {
			p3.setPublicity(p2);
			
			
			prodrep.save(p3);
		}
		 categoryRepository.save(p2);
		
		
		return ResponseEntity.status(HttpStatus.OK).body(p2);
		
		
		
	}
	
	@PostMapping("/getpunuser")
	private ResponseEntity<?> postFav(Principal p) {
		User u = userepo.findByUsernameAndFetchRoles(p.getName());
		//Favourite f = favrepo.getUserFavourite(u);
		
		Publicity p2 = new Publicity();
		p2.setPublictyBody(u.getUsername() + " pub");
		p2.setPublictyname(u.getUsername()+"publicity for ^product");
		
		p2.setPublictytag(u.getFavourite().getFavourite_title());

		//p2.setProducts(u.getFavourite().getProducts());
		u.getFavourite().getProducts().stream().map(y->{
			y.setPublicity(p2);
			prodrep.save(y);
			return categoryRepository.save(p2);
		});
				
		
		return ResponseEntity.status(HttpStatus.OK).body(categoryRepository.save(p2));
		
		
		
	}
	
	@GetMapping("/userpub")
	
	public ResponseEntity<?>  getFavpub(Principal p1){
		
		User u = userepo.findByUsernameAndFetchRoles(p1.getName());
		Favourite f = favrepo.getUserFavourite(u);
		return  ResponseEntity.status(HttpStatus.OK).body(f);
		
	}
	
	private Publicity p3 ;

@GetMapping("/userpub2")
	
	public ResponseEntity<?>  getFavpub2(Principal p1){
		
		User u = userepo.findByUsernameAndFetchRoles(p1.getName());
		Favourite f = favrepo.getUserFavourite(u);
				List<Publicity> pub1 = new ArrayList<>();
		Map<String ,  Set<Product1>>  mp1 =new HashMap<>();
		Map<String ,  String>  mp2 =new HashMap<>();
		mp1.put("user_" + u.getUsername(),new HashSet( f.getProducts()));
		/*u.getFavourite().getProducts().stream().map(it->{
			p3= it.getPublicity(); 
			return it.getPublicity();
		});*/
		
		for (Product1  pl  : u.getFavourite().getProducts()) {
			if(categoryRepository.findById(pl.getPublicity().getPublicity_id()) !=null)
				{this.p3 = pl.getPublicity();
			break;}
			else {
				p3=null;
			}
			
		}
		if(!p3.equals(null))
		{mp2.put("this publicity for " + u.getUsername() +" 😁😁 "
		 + p3.getPublictyname(),p3.getPublictyBody());
		
		Map< Map<String ,  String >,  Map<String ,  Set<Product1>> 	 >  ml=new HashMap<>();
		
		
		ml.put(mp2, mp1);		
		
		return  ResponseEntity.status(HttpStatus.OK).body(ml);
		}
		return  ResponseEntity.status(HttpStatus.OK).body(mp1); 
		
	}

@GetMapping("/likes1")
 public  List<Product1>  getlikes()
{
	
	return    prodrep.findBylikes(); 
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
