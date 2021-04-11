
package com.project0.esprit.dao;


import java.io.IOException;
import java.util.List;
 
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.project0.esprit.entity.Euser;


public class EuserExcelDao {
	
	 private XSSFWorkbook workbook;
	    private XSSFSheet sheet;
	    private List<Euser> listUsers;
	     
	    public EuserExcelDao(List<Euser> listUsers) {
	        this.listUsers = listUsers;
	        workbook = new XSSFWorkbook();
	    }
	    
	    
	    private void writeHeaderLine() {
	        sheet = workbook.createSheet("user");
	         
	        Row row = sheet.createRow(0);
	         
	        CellStyle style = workbook.createCellStyle();
	        XSSFFont font = workbook.createFont();
	        font.setBold(true);
	        font.setFontHeight(16);
	        style.setFont(font);
	         
	        createCell(row, 0, "userid", style);      
	        createCell(row, 1, "firstname", style);          
	        createCell(row, 2, "password", style);
	        createCell(row, 3, "confirmpassword", style);
	        createCell(row, 4, "email", style);
	        createCell(row, 5, "city", style);
	        createCell(row, 6, "address", style);
	        createCell(row, 7, "phonenumber", style);
	        createCell(row, 8, "age", style);
	        createCell(row, 9, "sexe", style);
	         
	    }
	     
	    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
	        sheet.autoSizeColumn(columnCount);
	        Cell cell = row.createCell(columnCount);
	        if (value instanceof Integer) {
	            cell.setCellValue((Integer) value);
	        } else if (value instanceof Boolean) {
	            cell.setCellValue((Boolean) value);
	        }else {
	            cell.setCellValue((String) value);
	        }
	        cell.setCellStyle(style);
	    }
	     
	    private void writeDataLines() {
	        int rowCount = 1;
	 
	        CellStyle style = workbook.createCellStyle();
	        XSSFFont font = workbook.createFont();
	        font.setFontHeight(14);
	        style.setFont(font);
	                 
	        for (Euser user : listUsers) {
	            Row row = sheet.createRow(rowCount++);
	            int columnCount = 0;
	             
	            createCell(row, columnCount++, user.getUser_id().toString(), style);
	            createCell(row, columnCount++, user.getMembre_username(), style);
	            createCell(row, columnCount++, user.getPassword(), style);
	            createCell(row, columnCount++, user.getConfirm_password().toString(), style);
	            createCell(row, columnCount++, user.getEmail(), style);
	            createCell(row, columnCount++, user.getCity(), style);
	            createCell(row, columnCount++, user.getAddress().toString(), style);
	            createCell(row, columnCount++, user.getPhone_number(), style);
	            createCell(row, columnCount++, user.getAge().toString(), style);
	            createCell(row, columnCount++, user.getSexe(), style);
	            
	           
	        }
	    }
	     
	    public void export(HttpServletResponse response) throws IOException {
	        writeHeaderLine();
	        writeDataLines();
	         
	        ServletOutputStream outputStream = response.getOutputStream();
	        workbook.write(outputStream);
	        workbook.close();
	         
	        outputStream.close();
	         
	    }
	 

}
