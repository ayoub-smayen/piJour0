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

import com.project0.esprit.dao.EuserExcelDao;
import com.project0.esprit.entity.Euser;
import com.project0.esprit.repository.EuserRepository;

@Controller
@RequestMapping("api")
public class EuserExcelController {

	@Autowired
	private EuserRepository euserrepository ;
	
	
	 @GetMapping("/users/export/excel")
	    public void exportToExcel(HttpServletResponse response) throws IOException {
	        response.setContentType("application/octet-stream");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	         
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
	        response.setHeader(headerKey, headerValue);
	         /////cast!!
	        List<Euser> listUsers = (List<Euser>) euserrepository.findAll();
	         
	        EuserExcelDao excelExporter = new EuserExcelDao(listUsers);
	         
	        excelExporter.export(response);    
	    }  
	
	
}