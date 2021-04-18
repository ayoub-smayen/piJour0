package tn.esprit.spring.Controller;



import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
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



import tn.esprit.spring.entity.Comments;
import tn.esprit.spring.entity.ImageT;
import tn.esprit.spring.entity.Publication;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.CommentsRepository;
import tn.esprit.spring.repository.PublicationRepository;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.services.IPublicationService;
import tn.esprit.spring.services.IUserService;

@RestController
@RequestMapping("/pi")
@CrossOrigin("*")
public class PublicationControllerImp implements IPublicationController {
	
	@Autowired
	IPublicationService pub_service;
	@Autowired
	UserRepository user_rep;
	@Autowired
	PublicationRepository pub_rep;
	@Autowired
	CommentsRepository com_rep;
	private byte[] bytes;
	@PostMapping("/upload")
	public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
		this.bytes = file.getBytes();
	}
	
	@GetMapping("/RetrievePublication")
	public List<Publication> retrieveAllPublications(){
		List<Publication> pub = pub_service.RetrievePublication();
		return pub;
	}
	
	@PostMapping("/AddPublication/{id}")
	public String AddPub( @RequestBody Publication pub,@PathVariable("id") int id) throws Exception{
		pub.setPic(this.bytes);
		
		this.bytes = null;
		
		return pub_service.AddPublication(id, pub);
		
		
		
	}
	
	@PutMapping("/UpdatePublication")
	public void UpdatePub(@RequestBody Publication pub){
		
		this.pub_service.UpdatePublicationById(pub);
		
	}
	
	@DeleteMapping("remove-publication/{id}")
	public void DeletePub(@PathVariable("id") int id){
		this.pub_service.DeletePublication(id);
	}
	
	@GetMapping("RetrievePublication/{id}")
	public Publication getPubByID(@PathVariable(value = "id")int id){
		
		
		return pub_service.GetPubById(id);
		
	}
	
	@GetMapping("RetrieveComments/{id}")
	public List<Comments> retrieveCOmmentsById(@PathVariable(value = "id")int id){
		
		return com_rep.RelevantComments(id);
	}
	
	@DeleteMapping("/deleteSujetRedondant")
	public void SuppressionDesSujetsRedondant(){
		pub_service.deletePubRedondant();
	} 
	@DeleteMapping("DeletePubWithoutInteraction")
	public void DeletePubWithoutInteraction(){
		pub_service.DeletePostsWithoutInteraction();
	}
	@GetMapping("GetPubAlaune")
	public List<Publication> getPubAlaUne(){
		return pub_service.AffichageDesSujetsAlaUne();
	}
	
	
	
	

}
