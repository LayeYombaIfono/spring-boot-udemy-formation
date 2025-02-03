package com.hamilatech.backend.service;

import com.hamilatech.backend.entities.Produit;

import java.util.List;

public interface ProduitService {

    Produit saveProduit(Produit produit);
    Produit updateProduit(Produit produit);
    void deleteProduit(Produit produit);
    void deleteProduitById(Long id);
    Produit getProduit(Long id);
    List<Produit> getAllProduits();
}
