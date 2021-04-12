package tn.esprit.spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.services.IUserService;

@RestController
@RequestMapping("/pi")
@CrossOrigin(origins="*")
public class UserControllerImpl implements IUserController  {
	
	@Autowired
	IUserService user_service;
	
	@GetMapping("/RetrieveUser")
	public List<User> retrieveAllPublications(){
		List<User> user = user_service.RetrieveUser();
		return user;
	}
	
	@PostMapping("/AddUser")
	public void AddPub(@RequestBody User user){
		
		this.user_service.AddUser(user);;
		
	}
	
	@PutMapping("/UpdateUser/{id}")
	public void UpdatePub(@RequestBody User user,@PathVariable("id") int id){
		
		this.user_service.UpdateUserById(user, id);
		
	}
	
	@DeleteMapping("remove-User/{id}")
	public void DeletePub(@PathVariable("id") int id){
		this.user_service.DeleteUser(id);
	}

}
