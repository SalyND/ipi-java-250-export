package com.example.demo.repository;

import com.example.demo.entity.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {
	//Facture correspond à l'entité facture et non à la table du mm nom - Requete JPQL
	/*@Query("Select f from Facture f where f.clientId = :id")
	 * List<Facture> findByClientId(@Param("id") Long clientId);*/
	
	
}