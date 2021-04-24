package com.project0.esprit.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project0.esprit.entity.Product1;
import com.project0.esprit.entity.Ray;
import com.project0.esprit.entity.Ray2;
import com.project0.esprit.repository.RayRepository;
import com.project0.esprit.repository.RayRepository2;
import com.project0.esprit.service.RayServiceImpl;
@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class RayController {
	
	@Autowired
	
	RayRepository rayrepository;
	
	
	
	 
	@Autowired
	RayServiceImpl RaySer;
	@Autowired
	RayRepository2 ray_rep;
	private byte[] bytes;
	@PostMapping("/upload147")
	public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws Exception {
		this.bytes = file.getBytes();
	}
	@PostMapping("/addRay")
	public Ray2 ADD(@RequestBody @Valid Ray2 ray) {
		ray.setRayonImg(this.bytes);
		RaySer.addRay(ray);
		this.bytes = null;
		return ray;
	}

	@GetMapping("/showRay")
	public List<Ray2> Show() throws Exception 
	{ 
		return RaySer.showAll();
	}



	@DeleteMapping("/deleteRay/{ID}")
	public void DeleteById(@PathVariable("ID") Long RayId) {
		RaySer.DeleteById(RayId);
	}

	@DeleteMapping("/deleteAll")
	public void DeleteAll() {
		RaySer.DeleteAll();
	}
	@PutMapping("/updateRay")
	void update (@RequestBody Ray2 ray) {
		RaySer.updateRay(ray);
	}

	@GetMapping("/notif")
	public String notif(){
		List<Ray2> ray = ray_rep.findAll();
		for (int i = 0; i < ray.size(); i++) {
			if (ray.get(i).getCapacity()<ray.get(i).getCapacity()/2) {
				return "vous devez remplir votre rayon"+ ray.get(i).getRayName();

			}
		}
		return "";
	}
	
	
	
	
	
	
	@PostMapping("/addray")
	public ResponseEntity<Object> AddRay(@RequestBody Ray ray ){
		
		rayrepository.save(ray);
		
		return   ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(ray);
		
		
		
	}
	
@GetMapping("/rayons")
	
	public Iterable<Ray> getAll(){
		return this.rayrepository.findAll();
	}
@GetMapping("/rayons1")
	
	public Iterable<Ray> getAllbyDate(){
		return this.rayrepository.findAllByDate();
	}

@GetMapping("/rayons/{rayname}")

public List<Ray> getAllRayName(@PathVariable("rayname") String rayname ){
	return this.rayrepository.getRayByName(rayname);
}


@GetMapping("/rayon/{id}")

public Ray getProductById(@PathVariable("id") Long id){
	return rayrepository.findById2(id) == null ? null :rayrepository.findById2(id) ;
}
	
@DeleteMapping("/rayon1/{id}")
public void DeleteRay(@PathVariable("id") Long id) {
	
	rayrepository.deleteById(id);
}
	
	

}
