package com.project0.esprit.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project0.esprit.datentity.Comment;
import com.project0.esprit.datentity.Poll;
import com.project0.esprit.datentity.User;
import com.project0.esprit.entity.Product1;
import com.project0.esprit.repository.CommentRepository;
import com.project0.esprit.repository.ProductRepository;
import com.project0.esprit.repository.UserRepository;

import com.project0.esprit.service.PollService;
import com.project0.esprit.service.impl.DashboardServiceImpl;
import com.project0.esprit.entity.LikesCmt;


@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class CommentController {

	private static final Logger L=LogManager.getLogger(CommentController.class);
	private byte[] picprofile;
	
	/*@Autowired
	private LikesCmt likj;
	
	  @Autowired
	    private CommentService commentService;
	@PostMapping("/addlikes/{id}")
	private void  addLikes (@PathVariable("id") Long id ) {
		
		int h = 0;
		
		
		commntRepository.findById(id).map(lik->{
			
			likj.incrementLikes();
			System.out.print(lik.getId());
			return "increments ";
			
		});
		
		System.out.println(likj.getLikes_count());
		
		L.info(likj.incrementLikes());
		
	}*/
	
	@Autowired
	private  UserRepository userRepository;
	@Autowired
	private CommentRepository commntRepository;
	
	@Autowired
	private ProductRepository prodrepo;
	
	 @PostMapping("/addComment/{product_id}")
	// @Secured("ROLE_USER")
	 public ResponseEntity<?> post(@RequestBody Comment c,@PathVariable("product_id") Long prod_id, Principal p) {
		 
		 
		 
		 Product1 p1= prodrepo.findById2(prod_id);
		 if(p1.equals(null)) {L.error("error  not products found"); return   ResponseEntity.status(HttpStatus.BAD_REQUEST).build() ;} 
		 User user = userRepository.findOneByUsername(p.getName());
	      c.setProduct(p1);
	      c.setCommentPic(this.picprofile);
	      c.setUser(user);
	      
	      
		 Comment y =commntRepository.save(c);
	       return ResponseEntity.status(201).body(y);
	    }
	/*  @GetMapping("/comments/user/{username}")
	    @Secured("ROLE_USER")
	    public List<Comment> getUserPolls(@PathVariable String username, Principal p) {
	        
	        if (username.equals(p.getName())) {
	            return commentService.getAllForUser(username);
	        } else {
	            return commentService.getAllVisibleForUser(username);
	        }
	    }*/
	 @GetMapping("/comments")
	 @Secured("ROLE_USER")
	 public ResponseEntity<?> getComments(){
		 
		 List<Comment> c = commntRepository.findAll();
		 
		/* for (Comment x : c) {
			 x.setCommentPic(decompressBytes(x.getCommentPic()));
		 }*/
		 
		 return ResponseEntity.status(201).body(c);
		 
	 }
	 
	 @PostMapping("/uploadpcommentimage")
		public void  uplaodImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
			System.out.println("Original Image Byte Size - " + file.getBytes().length);
			/*ImageT img = new ImageT(file.getOriginalFilename(), file.getContentType(),@RequestPart
					compressBytes(file.getBytes()));*/
			this.picprofile = compressBytes(file.getBytes());
			
			if(this.picprofile != null) {
				System.out.println(this.picprofile);
			}
			//imageRepository.save(img);
			//return ResponseEntity.status(HttpStatus.OK);
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
