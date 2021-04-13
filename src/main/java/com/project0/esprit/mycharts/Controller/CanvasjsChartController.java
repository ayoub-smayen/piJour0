package com.project0.esprit.mycharts.Controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

import com.project0.esprit.datentity.Myprofile;
import com.project0.esprit.datentity.User;
import com.project0.esprit.entity.ImageT;
import com.project0.esprit.mycharts.Service.CanvasjsChartService;
import com.project0.esprit.repository.EditProfileRepository;
import com.project0.esprit.repository.UserRepository;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


class MyUser1 {
	private String name ;
	private String email;
	private Long id;
	
	public String getName() {
		return name;
	}

	public MyUser1(String name, String email, Long id) {
		super();
		this.name = name;
		this.email = email;
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	MyUser1(){
		
	}
	
}
@RestController
@RequestMapping("canvasjschart")
public class CanvasjsChartController {
	private byte[] picprofile;
 
	@Autowired
	
	private EditProfileRepository editprofile;
	
	@Autowired
	UserRepository userrepository ;
	
	@Autowired
	private CanvasjsChartService canvasjsChartService;
 
	@RequestMapping(value="/chart",method = RequestMethod.GET)
	public String springMVC(ModelMap modelMap) {
		List<List<Map<Object, Object>>> canvasjsDataList = canvasjsChartService.getCanvasjsChartData();
		modelMap.addAttribute("dataPointsList", canvasjsDataList);
		return "chart";
	}
	
	 @RequestMapping(value = "/username0", method = RequestMethod.GET)
	  @ResponseBody
	  public String currentUserName(Principal principal) {
	     return principal.getName();
	  }
 
	 
	 
	 
	 
	 @PostMapping("/upload1")
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
	 
	 @PostMapping("/editprofile")
	 @ResponseBody
	 private Myprofile    editprofile(@RequestBody Myprofile  prof,Principal authentication) {
		 
User user1 = userrepository.findOneByUsername(authentication.getName());
		 //user1  =  authentication.getName();
		 
		 //prof.setUsers(user1);
		
		 prof.setProfilepic(this.picprofile);
		// editprofile.addProfile1(prof.getId(),prof.getFirstname(), prof.getLastname(),prof.getProfilepic(), prof.getUsers().getId());
		 
		 editprofile.save(prof);
		 return prof;

	 }
	 
	 
	 
	 @RequestMapping(value = "/username", method = RequestMethod.GET)
	  @ResponseBody
	  public User currentUserName(Authentication authentication) {
		 
		 MyUser1 userd ;
		 
		 User user1;
		 
		 user1  = (User) authentication.getPrincipal();
		 
		return user1;
		//return  authentication.getPrincipal().toString();.getId().toString();
		 
	    // return authentication.getName();
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
