package com.example.demo.controller;

import com.example.demo.dto.ClientDTO;

import com.example.demo.dto.FactureDTO;
import com.example.demo.service.ClientService;
import com.example.demo.service.FactureService;
import com.example.demo.service.export.ExportCSVService;
import com.example.demo.service.export.ExportPDFITextService;
import com.example.demo.service.export.ExportXLSXService;

import org.apache.poi.util.DocumentFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("/")
public class ExportController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ExportCSVService exportCSVService;

    @Autowired
    private ExportPDFITextService exportPDFITextService;
    
    @Autowired
    private ExportXLSXService exportXLSXService;
    
    @Autowired
    private FactureService factureService;


    @GetMapping("/clients/csv")
    public void clientsCSV(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=\"clients.csv\"");
        List<ClientDTO> clients = clientService.findAllClients();
        exportCSVService.export(response.getWriter(), clients);
    }
    
    @GetMapping("/clients/xlsx")
    public void clientsXLSX(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	response.setContentType("application/xlsx");        
    	response.setHeader("Content-Disposition", "attachment; filename=\"clients.xlsx\"");
    	List<ClientDTO> clients = clientService.findAllClients();
    	exportXLSXService.export(response.getOutputStream(), clients);
    }
    
    @GetMapping("/clients/{id}/factures/xlsx")
    public void factureClientXLSX(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) throws IOException, DocumentFormatException {
        response.setContentType("application/xlsx");
        response.setHeader("Content-Disposition", "attachment; filename=\"facture " + id + ".xlsx\"");
        ClientDTO client = clientService.findClientById(id);
        List<FactureDTO> facture = factureService.findAllFactureByClientId(id);
        exportXLSXService.exportFactureClient(response.getOutputStream(), facture);
    }

    @GetMapping("/factures/{id}/pdf")
    public void facturePdf(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) throws IOException, DocumentFormatException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"facture " + id + ".pdf\"");
        FactureDTO facturePdf = factureService.findById(id);
        exportPDFITextService.export(response.getOutputStream(), facturePdf);
    }

}
