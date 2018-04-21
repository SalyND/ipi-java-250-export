package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.*;

/**
 * Created by Kayne on 09/04/2018.
 */
@Entity
public class LigneFacture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Facture facture;

    @ManyToOne
    private Article article;

    @Column
    private Integer quantite;
    
    @Column
    private String marque;
    
    @Column
    private Double prixUnitaire;
    
    @Column
    private Double total;
    
    @Column
    private LocalDate dateFacture;
    
    public LocalDate getDateFacture() {
		return dateFacture;
	}

	public void setDateFacture(LocalDate dateFacture) {
		this.dateFacture = dateFacture;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public Double getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(Double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

    public Double getTotal() {
		total  = quantite * prixUnitaire;
    	return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public Article getArticle() {
    	return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

}
