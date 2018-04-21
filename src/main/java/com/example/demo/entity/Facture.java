package com.example.demo.entity;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Kayne on 09/04/2018.
 */
@Entity
public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private LocalDate dateAchat;

	@ManyToOne
    private Client client;

    //Relation One To Many avec la table LigneFactures: mappage avec le champs Facture
    //correspond à une liste de lignesFactures
    @OneToMany(mappedBy = "facture")
    private Set<LigneFacture> ligneFacturesListe = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

	public Set<LigneFacture> getLigneFacturesListe() {
		return ligneFacturesListe;
	}

	public void setLigneFacturesListe(Set<LigneFacture> ligneFacturesListe) {
		this.ligneFacturesListe = ligneFacturesListe;
	}
	 public LocalDate getDateAchat() {
		return dateAchat;
	}

	public void setDateAchat(LocalDate dateAchat) {
		this.dateAchat = dateAchat;
	}

}
