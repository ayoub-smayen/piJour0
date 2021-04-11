package com.project0.esprit.controller;



 /*
  * 
  * 
  * router admin  if user has rule Admin can enter else not
  * qr code generate 
  * add crud admin 
  * 
  * 
  */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.project0.esprit.repository.AdsinseRepository;
import com.project0.esprit.repository.AuthoradsRepository;

/*
 * 
 *         <!-- https://mvnrepository.com/artifact/com.google.code.gson/gson -->
<dependency>
composer require cysha/casino-holdem
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.3.1</version>
</dependency>
 */

import com.project0.esprit.dao.DataDAO;
import com.project0.esprit.dao.MultipleDataDAO;
import com.project0.esprit.entity.Adsinses;
import com.project0.esprit.entity.CodeBart;
import com.project0.esprit.entity.Data;
import com.project0.esprit.entity.MultipleData;

import com.project0.esprit.repository.CodebarRepository;

@RestController
@RequestMapping("admin")
public class AdminController {
	
	
	@Autowired
	private AdsinseRepository  fg;
	
	@Autowired
	private CodebarRepository codebar;
	 
	
	
	@PostMapping("/adcodebar")
	
	public @ResponseBody String  addCode(@RequestBody CodeBart code1){
		codebar.save(code1);
		
		return "adding code ";
	}
	
	@GetMapping("/ads")
	public @ResponseBody List<Adsinses> getAds(){
		
		return fg.findAll();
	}
	
	/*@Autowired
	 * 
	 * RewriteCond %{HTTPS} off
RewriteRule ^(.*)$ https://%{HTTP_HOST}%{REQUEST_URI} [L,R=301]
	MultipleDataDAO multipleDataDAO;

	@RequestMapping("/multiplelinechart")
		public ResponseEntity<?> getDataForMultipleLine() {
			List<MultipleData> dataList = multipleDataDAO.findAll();
			Map<String, List<MultipleData>> mappedData = new HashMap<>();
			for(MultipleData data : dataList) {
				
				if(mappedData.containsKey(data.getName())) {
					mappedData.get(data.getName()).add(data);
				}else {
					List<MultipleData> tempList = new ArrayList<MultipleData>();
					tempList.add(data);
					mappedData.put(data.getName(), tempList);
				}
				
			}
			return new ResponseEntity<>(mappedData, HttpStatus.OK);
		}
	@Autowired
	DataDAO dataDAO;*/
	
	@RequestMapping("/hel")
	public String showHome(){
		return "index";
	}
	/*
	@RequestMapping("/linechartdata")
	@ResponseBody
	public String getDataFromDB(){
		List<Data> dataList = dataDAO.findAll();
		JsonArray jsonArrayCategory = new JsonArray();
		JsonArray jsonArraySeries = new JsonArray();
		JsonObject jsonObject = new JsonObject();
		dataList.forEach(data->{jsonArrayCategory.add(new Gson().toJsonTree( data.getCategory()));
				jsonArraySeries.add(new Gson().toJsonTree(data.getSeries()));
			
		});
		jsonObject.add("categories", jsonArrayCategory);
		jsonObject.add("series", jsonArraySeries);
		//return jsonObject.toString();
	}*/

	
	@GetMapping("")
	private @ResponseBody ResponseEntity<String>  getHello(){
		
		  return new ResponseEntity<String>("hello admin",HttpStatus.OK);
		
	}
}
