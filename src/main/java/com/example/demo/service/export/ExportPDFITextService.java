package com.example.demo.service.export;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.ClientDTO;
import com.example.demo.dto.FactureDTO;
import com.example.demo.dto.LigneFactureDTO;
import com.example.demo.entity.LigneFacture;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.lowagie.text.pdf.PdfCell;
import com.lowagie.text.pdf.PdfTable;

@Service
public class ExportPDFITextService extends DocumentException {
	Document documentPdf;
	PdfWriter pdfWriter;
	public void export(OutputStream os, FactureDTO facturePdf )  throws IOException  {
		Document documentPdf = new Document();
		
		try {
			PdfWriter.getInstance(documentPdf, os);
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		documentPdf.open(); 
		documentPdf.add(tableauPdf(facturePdf));
		documentPdf.close();
	}
	
	private PdfPTable tableauPdf(FactureDTO facturePdf)  {
			PdfPTable tableauPdf = new PdfPTable(5);
			PdfPCell header = new PdfPCell();
			
			tableauPdf.setHeaderRows(5);
			tableauPdf.setLockedWidth(true);			
			header.setBorder(2);
			header.setBackgroundColor(BaseColor.BLUE);
			header.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			header.setPhrase(new Phrase("Id"));
			tableauPdf.addCell(header);
			 
			header.setPhrase(new Phrase("Nom"));
			tableauPdf.addCell(header);     
		          
			header.setPhrase(new Phrase("Prenom"));
			tableauPdf.addCell(header);     
			
			header.setPhrase(new Phrase("Adresse"));
			tableauPdf.addCell(header);   
			
			header.setPhrase(new Phrase("Email"));
			tableauPdf.addCell(header);   
			
		    for (int i=0; i<facturePdf.getLigneFactures().size();i++) {
		    	tableauPdf.addCell(facturePdf.getLigneFactures().get(i).toString());
		    	tableauPdf.addCell(facturePdf.getLigneFactures().get(i).getDesignation());
		    	tableauPdf.addCell(facturePdf.getLigneFactures().get(i).getMarque());
		    	tableauPdf.addCell(facturePdf.getLigneFactures().get(i).getQuantite().toString());
		    	tableauPdf.addCell(facturePdf.getLigneFactures().get(i).getPrixUnitaire().toString());
		    	tableauPdf.addCell(facturePdf.getLigneFactures().get(i).getTotal().toString());
		    }
		    
		    return tableauPdf;      
		       
		 }
		 
}
