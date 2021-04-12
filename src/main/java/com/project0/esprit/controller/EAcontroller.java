package com.project0.esprit.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
 
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project0.esprit.dao.ProductExcelDao;
import com.project0.esprit.entity.Product1;
import com.project0.esprit.repository.ProductRepository;

@Controller
@RequestMapping("api")
public class EAcontroller {

	@Autowired
	private ProductRepository prod ;
	
	
	 @GetMapping("/products/export/excel")
	    public void exportToExcel(HttpServletResponse response) throws IOException {
	        response.setContentType("application/octet-stream");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	         
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
	        response.setHeader(headerKey, headerValue);
	         
	        List<Product1> listUsers = prod.findAll();
	         
	        ProductExcelDao excelExporter = new ProductExcelDao(listUsers);
	         
	        excelExporter.export(response);    
	    }  
	
	
}
