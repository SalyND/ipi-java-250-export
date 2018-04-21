package com.example.demo.service;

import com.example.demo.entity.Article;
import com.example.demo.entity.Client;
import com.example.demo.entity.Facture;
import com.example.demo.entity.LigneFacture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import javax.persistence.EntityManager;

@Service
@Transactional
public class InitData {

    @Autowired
    private EntityManager em;

    //Insertion de données en dur dans la base de données
    public void insertTestData() {

    	//Client 1 - Coordonnées-Articles achetés-Facture correspondante-LigneFactures correspondante
        Client client1  = new Client();
        client1.getId();
        client1.setNom("NDIAYE");
        client1.setPrenom("Saly");
        client1.setAdresse("18 rue de la rose - 78000 Saint Quentin en Yveline");
        client1.setEmail("saly.ndiaye@ipilyon.net");
        client1.setNumero((long) 0606120065);
        em.persist(client1);

        Article article = new Article();
        article.setLibelle("Carte mère ASROCK 2345");
        article.setPrix(79.90);
        article.setMarque("Dell");
        em.persist(article);

        Facture facture1 = new Facture();
        facture1.setId((long) 1);
        facture1.setClient(client1);
        facture1.setDateAchat(LocalDate.now().minusDays(30));
        em.persist(facture1);

        LigneFacture ligneFacture1 = new LigneFacture();
        ligneFacture1.setDateFacture(facture1.getDateAchat());
        ligneFacture1.setFacture(facture1);
        ligneFacture1.setPrixUnitaire(article.getPrix());
        ligneFacture1.setMarque(article.getMarque());
        ligneFacture1.setArticle(article);
        ligneFacture1.setQuantite(5);
        ligneFacture1.getTotal();
        em.persist(ligneFacture1);
        
    	//Client 2 - Coordonnées-Articles achetés-Facture correspondante-LigneFactures correspondante
        Client client2  = new Client();
        client2.getId();
        client2.setNom("Tata");
        client2.setPrenom("toto");
        client2.setAdresse("20 place de la Mariniere - 69150 Saint Martin");
        client2.setEmail("toto@ipilyon.net");
        client2.setNumero((long) 0606123456);
        em.persist(client2);

        Article article2 = new Article();
        article2.setLibelle("Carte mère HTTRD 1833");
        article2.setPrix(18.23);
        article2.setMarque("Hewklet Parckard");
        em.persist(article2);

        Facture facture2 = new Facture();
        facture2.setId((long) 2);
        facture2.setClient(client2);
        facture2.setDateAchat(LocalDate.now().minusDays(15));
        em.persist(facture2);

        LigneFacture ligneFacture2 = new LigneFacture();
        ligneFacture2.setDateFacture(facture2.getDateAchat());
        ligneFacture2.setFacture(facture2);
        ligneFacture2.setPrixUnitaire(article2.getPrix());
        ligneFacture2.setMarque(article2.getMarque());
        ligneFacture2.setArticle(article2);
        ligneFacture2.setQuantite(3);
        ligneFacture2.getTotal();
        em.persist(ligneFacture2);

    	//Client 3 - Coordonnées-Articles achetés-Facture correspondante-LigneFactures correspondante
        Client client3  = new Client();
        client3.getId();
        client3.setNom("Babar");
        client3.setPrenom("Abel");
        client3.setAdresse("1 rue valentin - 33100 Bordeaux");
        client3.setEmail("abel@gmail.net");
        client3.setNumero((long) 0707123456);
        em.persist(client3);

        Article article3 = new Article();
        article3.setLibelle("PC ASUS1833");
        article3.setPrix(753.00);
        article3.setMarque("ASUS");
        em.persist(article3);

        Facture facture3 = new Facture();
        facture3.setId((long) 3);
        facture3.setClient(client3);
        facture3.setDateAchat(LocalDate.now().minusDays(3));
        em.persist(facture3);

        LigneFacture ligneFacture3 = new LigneFacture();
        ligneFacture3.setDateFacture(facture3.getDateAchat());
        ligneFacture3.setFacture(facture3);
        ligneFacture3.setPrixUnitaire(article3.getPrix());
        ligneFacture3.setMarque(article3.getMarque());
        ligneFacture3.setArticle(article3);
        ligneFacture3.setQuantite(1);
        ligneFacture3.getTotal();
        em.persist(ligneFacture3);

    }
}
