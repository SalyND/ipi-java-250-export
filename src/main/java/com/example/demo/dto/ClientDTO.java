package com.example.demo.dto;


/**
 * Created by Kayne on 09/04/2018.
 */
public class ClientDTO {

    private Long id;
	
	private String prenom;

    private String nom;
    
    private String email;
    
    private String adresse;
    
    private Long numero;

    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    
	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
