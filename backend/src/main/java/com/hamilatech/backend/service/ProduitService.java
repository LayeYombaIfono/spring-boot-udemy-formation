package com.hamilatech.backend.service;

import com.hamilatech.backend.entities.Categorie;
import com.hamilatech.backend.entities.Produit;

import java.util.List;

public interface ProduitService {

    Produit saveProduit(Produit produit);
    Produit updateProduit(Produit produit);
    void deleteProduit(Produit produit);
    void deleteProduitById(Long id);
    Produit getProduit(Long id);
    List<Produit> getAllProduits();

//    Ajout des methodes qui tries par nom
    List<Produit> findByNomProduit(String nom);
    List<Produit> findByNomProduitContains(String nom);
    List<Produit> findByNomPrix(String nom, Double prix);
    List<Produit> findByCategory(Categorie categorie);
    List<Produit> findByOrderByNomProduitAsc();
    List<Produit>trierProduitsNomPrix();

}
