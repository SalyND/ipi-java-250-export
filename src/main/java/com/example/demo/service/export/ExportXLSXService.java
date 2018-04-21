package com.example.demo.service.export;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;

import com.example.demo.dto.*;
import java.io.Writer;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

@Service
public class ExportXLSXService {
	 public void export(OutputStream os, List<ClientDTO> clients) throws IOException {
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("clients");
			
			XSSFRow rowHeader = sheet.createRow(0);
			
			XSSFFont defaultFont = workbook.createFont();
			defaultFont.setFontHeight(12);
			defaultFont.setBold(true);
			
			XSSFCell headerId = rowHeader.createCell(0);
			headerId.setCellValue("Id");
			
			XSSFCell headerNom = rowHeader.createCell(1);
			headerNom.setCellValue("Nom");
			
			XSSFCell headerPrenom = rowHeader.createCell(2);
			headerPrenom.setCellValue("Prenom");
			
			XSSFCell headerAdresse = rowHeader.createCell(3);
			headerAdresse.setCellValue("Adresse");
			
			XSSFCell headerEmail = rowHeader.createCell(4);
			headerEmail.setCellValue("Email");
			
			for (int index = 0; index <clients.size(); index++) {
				XSSFRow row1 = sheet.createRow(index +1);
			}
			
			int rowNum = 1;
			for (ClientDTO client :clients) {
				XSSFRow row1 = sheet.createRow(rowNum);
				
				XSSFCell cellId = row1.createCell(0);
				cellId.setCellValue(client.getId());
				
				XSSFCell cellNom = row1.createCell(1);
				cellNom.setCellValue(client.getNom());
				
				XSSFCell cellPrenom = row1.createCell(2);
				cellPrenom.setCellValue(client.getPrenom());
				
				XSSFCell cellAdresse = row1.createCell(3);
				cellAdresse.setCellValue(client.getAdresse());
				
				XSSFCell cellEmail = row1.createCell(4);
				cellEmail.setCellValue(client.getEmail());
				
				rowNum++;
			}
			
			workbook.write(os);
			workbook.close();
}

	 public void exportFactureClient(ServletOutputStream os, List<FactureDTO> factures) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		for (FactureDTO facture : factures) {
			XSSFSheet sheet = workbook.createSheet("facture" + facture.getId());
		
		}
		
		workbook.write(os);
		workbook.close();
		 
		
	}

}
