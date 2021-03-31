package com.project0.esprit.controller;



/*
 * Ayub
 * 
 * bok  product  type  
 *  other tpe of product book 
 *  
 *  ayub
 *  
 */
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project0.esprit.datentity.Book;
import com.project0.esprit.repository.BookRepository;

@RestController
@RequestMapping("/api2")
@CrossOrigin("*")

public class BookController {
	
	private byte[] bitbook;
	
	@Autowired
	private BookRepository boorep;
	
	@PostMapping("/uploadbookimg")
	public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
		this.bitbook = file.getBytes();
	}
	
	@PostMapping("/addbook")
	private @ResponseBody ResponseEntity<?> addBoo(@RequestBody Book book)  throws Exception {
		book.setImageUrl(this.bitbook);
		Book v = boorep.save(book);
		
		this.bitbook=null;
		return ResponseEntity.status(HttpStatus.CREATED).body(v); 
	}
	
	
	@GetMapping("/books/get")
	public List<Book> getBooks() {
		return boorep.findAll();
	}

	
	

}
