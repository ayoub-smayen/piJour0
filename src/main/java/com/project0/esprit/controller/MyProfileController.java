package com.project0.esprit.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.function.EntityResponse;

import com.project0.esprit.datentity.Myprofile;
import com.project0.esprit.entity.ImageT;
import com.project0.esprit.repository.MyProfileRepository;

@RestController
@RequestMapping("edit")
public class MyProfileController {
	
	
	private byte[] imp;
	
	@Autowired
	private MyProfileRepository  profilereposi;
	
	
	@PostMapping("/upload")
	public BodyBuilder uplaodImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
		System.out.println("Original Image Byte Size - " + file.getBytes().length);
		ImageT img = new ImageT(file.getOriginalFilename(), file.getContentType(),
				compressBytes(file.getBytes()));
		this.imp=img.getPicByte();
		return ResponseEntity.status(HttpStatus.OK);
	}
	
	
	@PostMapping("/profile")
	private @ResponseBody BodyBuilder setProfile(@RequestBody Myprofile myprofile)
	{
		myprofile.setProfilepic(this.imp);
		
		profilereposi.save(myprofile);
		this.imp = null;
		
		return ResponseEntity.status(HttpStatus.OK);
		
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
