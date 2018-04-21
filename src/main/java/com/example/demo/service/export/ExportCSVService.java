package com.example.demo.service.export;

import com.example.demo.dto.ClientDTO;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

@Service
public class ExportCSVService {

    public void export(Writer printWriter, List<ClientDTO> clients) throws IOException {
        
    	/*Autre methode pour exporter sans oublier de parametres : creer un tableau
    	 * Exporter exporter = ...;
    	addColumn("Nom", ClientDTO::getNom);
    	addColumn("Prenom", ClientDTO::getPrenom);
    	addColumn("Adresse", ClientDTO::getAdresse);
    	*/
    	
    	
    	printWriter.write("Nom;");
        printWriter.write("Prenom;");
        printWriter.write("Adresse;");
        printWriter.write("Email;");
        for (ClientDTO client : clients) {
            printWriter.write(client.getNom());
            printWriter.write(client.getPrenom());
            printWriter.write(client.getAdresse());
            printWriter.write(client.getEmail());
           /* printWriter.write(client.getNumero());*/
            printWriter.write(";");

            printWriter.write(client.getAdresse());
            printWriter.write("\n");
        }
        

    }
    
    //Methode pour supprimer les caractères spéciaux type (;)
  /*  private String replace(String value) {
    	value = value.replace("\"","\"\"");
    	if (value.contains(";")) {
    		value = "\"" + value + "\"";
    	}
    	return value;
    }*/
}