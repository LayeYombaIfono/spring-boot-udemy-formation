package com.hamilatech.backend.service;

import com.hamilatech.backend.entities.Categorie;
import com.hamilatech.backend.entities.Produit;

import java.util.List;
import java.util.Optional;

public interface ProduitService {

    void saveProduit(Produit produit);
    void updateProduit( Long id, Produit produit);
    List<Produit> getAllProduits();
    Produit getProduitById(Long id);

//    void deleteProduit(Produit produit);

    void deleteProduitById(Long id);

    void deleteProduct(Produit produit);

//    Ajout des methodes qui tries par nom
    List<Produit> findByNomProduit(String nom);
    List<Produit> findByNomProduitContains(String nom);
    List<Produit> findByNomPrix(String nom, Double prix);
    List<Produit> findByCategory(Categorie categorie);
    List<Produit> findByOrderByNomProduitAsc();
    List<Produit>trierProduitsNomPrix();
    Optional<Produit> findByCategoryBy_IdCat(Long idCat);

}
