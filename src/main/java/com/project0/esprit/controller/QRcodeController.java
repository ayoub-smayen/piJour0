package com.project0.esprit.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.WriterException;
import com.project0.esprit.entity.Product1;
import com.project0.esprit.repository.ProductRepository;
import com.project0.esprit.service.impl.QRCodeServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("api")
public class QRcodeController {
	
	
	@Autowired
	 private ProductRepository c;
	
	
	QRCodeServiceImpl qr =new QRCodeServiceImpl();
	
	String filePath = "JD.png";
	
	 private final int WIDTH = 250;
	  private final int HEIGHT = 250;
	  private final String QR_TEXT = "good day ";

	
	//@Autowired
	
	
	
	 @GetMapping("qr-code/{product_id}")
	  public ResponseEntity<byte[]> getQrCode(@PathVariable("product_id") Long id) {
		  
		  /*
		   * ethik 1l  ntsty  b id  prod 
		   */
		//  Long id = 1L;
		 Product1 p =  c.findById2(id);//  hedhi  nty  aaml  colirepo.findbyid(1).get();
		 String QR_TEXT2 =  String.format("  brand = %s \n  name =  %s \n price =  %s   dt ", p.getBrand(),p.getProductname(),p.getPrice().toString());
	    byte[] qrImage = qr.generate(QR_TEXT2, WIDTH, HEIGHT);

	    return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(qrImage);
	  }
	
	
	
	
	@GetMapping("/qrcode")
	
	
	
	private void  getQrcode() throws WriterException, IOException { 
		String qrCodeText = "https://www.consomi.com";
		
		int size = 125;
		String fileType = "png";
		File qrFile = new File(filePath);
		qr.createQRImage(qrFile, qrCodeText, size, fileType);
		System.out.println("DONE");
	}

	
	/*@GetMapping("qr-code")
	  public ResponseEntity<byte[]> getQrCode() {

	    byte[] qrImage = qrCodeService.generate(QR_TEXT, WIDTH, HEIGHT);

	    return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(qrImage);
	  }*/
	  
	  
	  
	  
}
