package com.project0.esprit.controller;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project0.esprit.exception.*;
import com.project0.esprit.model.*;
import com.project0.esprit.service.*;


@RestController
@RequestMapping("/api2")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/products1", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Product>> getProducts1() throws ProductNotFoundException {
		Locale l = new Locale("ar","TN");
		 NumberFormat cuurencyFormat = NumberFormat.getCurrencyInstance(l);
		 
		List<Product> products = productService.findAll();
		
		
		return new ResponseEntity<List<Product>> (products, HttpStatus.FOUND);
	}
	
	@RequestMapping(value = "/products/{idProduct}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Product> getBy1(@PathVariable("idProduct") Long idProduct) throws ProductNotFoundException  {
		Product product = productService.findBy(idProduct);
		return new ResponseEntity<Product> (product, HttpStatus.OK);
	}

	@RequestMapping(value = "/products?description={description}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Product> getByDescription1(@PathVariable("description") String description) throws ProductNotFoundException  {
		Product product = productService.findBy(description);
		return new ResponseEntity<Product> (product, HttpStatus.OK);
	}

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Product>> getByCategory1(@RequestParam("category") String category) throws ProductNotFoundException  {
		List<Product> products = productService.findByCategory(category);
		return new ResponseEntity<List<Product>> (products, HttpStatus.OK);
	}

}
