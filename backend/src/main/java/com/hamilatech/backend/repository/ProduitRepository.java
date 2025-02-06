package com.hamilatech.backend.repository;

import com.hamilatech.backend.entities.Categorie;
import com.hamilatech.backend.entities.Produit;
import jdk.jfr.Percentage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {

    List<Produit> findByNomProduit(String nom);
    List<Produit> findByNomProduitContains(String nom);

//  Ecrire les requetes @Query  JPA QUERY
//    @Query("select p from Produit p where p.nomProduit like %?1 and p.prixProduit > ?2")
//    List<Produit> findByNomPrix(String nom, Double prix);


//    Trouver le produit par son nom et son prix
    @Query("select p from Produit p where p.nomProduit like %:nom and p.prixProduit > :prix")
    List<Produit> findByNomPrix(@Param("nom") String nom, @Param("prix") Double prix);


//    Trouver le produit par sa catégorie
    @Query("select p from Produit p where p.categorie = ?1")
    List<Produit> findByCategorie(Categorie categorie);

//    Trouver des produits par categorie
    @Query("select p from Produit p where p.categorie = ?1")
    List<Produit> findByCategory(Categorie categorie);
}
