package com.project0.esprit.controller;
/*
 * 
 * hedha  controller  gheli @Controller  mch  chyt3eda  Rest ghter  wedh7 
 */
//import com.project0.esprit.entity.City;
import com.project0.esprit.entity.Product1;
import com.project0.esprit.repository.ProductRepository;
//import com.project0.esprit.service.ICityService;
import com.project0.esprit.util.GeneratePdfReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.ByteArrayInputStream;
import java.util.List;

@Controller

@CrossOrigin("*")
@RequestMapping("api")
public class MyController {

   /* @Autowired
    private ICityService cityService;
    */
    
    @Autowired
    private ProductRepository prodrep; // lina   hejetna  b hedhi redha colis   ,  repository  wkhw  ,     bhi  city  gheli  commentaire  ,  3ml  polpulation api ghter hhhhhh  
/*
    @RequestMapping(value = "/pdfreport", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> citiesReport() {

    	List<City> cities = (List<City>) cityService.findAll();
      
        ByteArrayInputStream bis = GeneratePdfReport.citiesReport(cities);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }*/
    
    @RequestMapping(value = "/pdfreportp", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> productsReport() {

    	  List<Product1> prods =(List<Product1>) prodrep.findAll();
      
        ByteArrayInputStream bis = GeneratePdfReport.prodsReport(prods);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}