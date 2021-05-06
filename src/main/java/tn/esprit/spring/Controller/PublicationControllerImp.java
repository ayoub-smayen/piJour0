package tn.esprit.spring.Controller;



import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.scheduling.annotation.Scheduled;
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
import tn.esprit.spring.services.PublicationService;

@RestController
@RequestMapping("/pi")
@CrossOrigin("*")
public class PublicationControllerImp {
	
	@Autowired
	PublicationService pub_service;
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
	public List<Publication> retrieveAllPublications(
			/*/@RequestParam(defaultValue = "0",name="page") int page,
	        @RequestParam(defaultValue = "3",name="size") int size*/){
		
		/*Pageable paging = PageRequest.of(page, size);
		Page<Publication> publi = pub_service.RetrievePublication(paging);*/
	        	List<Publication> pub = pub_rep.findAll();
		
		return pub;
	}
	
	@PostMapping("/AddPublication/{id}")
	public ResponseEntity<Publication> AddPub(@RequestBody Publication pub,@PathVariable("id") int id) throws Exception{
		pub.setPic(this.bytes);
		
		this.bytes = null;
		
		pub_service.AddPublication(id, pub);
		return ResponseEntity.accepted().body(pub);
		
		
		
	}
	
	@PutMapping("/UpdatePublication/{id}")
	public void UpdatePub(@RequestBody Publication pub,@PathVariable("id") int id){
		
		this.pub_service.UpdatePublicationById(pub, id);
		
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
	@PutMapping("AddLikeposts/{id}")
	public void AddLikeposts(@PathVariable("id") int id){
		pub_service.AddLike(id);
	}
	@PutMapping("AdddisLikeposts/{id}")
	public void AdddisLikeposts(@PathVariable("id") int id){
		pub_service.AddDislike(id);
	}
	
	//@Scheduled(fixedDelay=1000*30)
	@PutMapping("/getCommentsNumber")
	public int NbreComments(){
		List<Publication> p = pub_rep.findAll();
		for (int i = 0; i < p.size(); i++) {
			Publication x = p.get(i);
			x.setCommentsNumber(pub_service.getCommentsNumber(x.getId()));
			pub_rep.save(x);
			System.out.println(pub_service.getCommentsNumber(p.get(i).getId()));
		}
		return 0;
	}
	
	@GetMapping("PubNumber")
	public int pubnumber(){
		return pub_rep.NbrePub();
	}
	public static byte[] compressBytes(byte[] data) {

		Deflater deflater = new Deflater();

		deflater.setInput(data);

		deflater.finish();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);

		byte[] buffer = new byte[1024];

		while (!deflater.finished()) {

			int count = deflater.deflate(buffer);

			outputStream.write(buffer, 0, count);

		}

		try {

			outputStream.close();

		} catch (IOException e) {

		}

		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

		return outputStream.toByteArray();

	}
	public static byte[] decompressBytes(byte[] data) {

		Inflater inflater = new Inflater();

		inflater.setInput(data);

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);

		byte[] buffer = new byte[1024];

		try {

			while (!inflater.finished()) {

				int count = inflater.inflate(buffer);

				outputStream.write(buffer, 0, count);

			}

			outputStream.close();

		} catch (IOException ioe) {

		} catch (DataFormatException e) {

		}

		return outputStream.toByteArray();

	}
	

}
