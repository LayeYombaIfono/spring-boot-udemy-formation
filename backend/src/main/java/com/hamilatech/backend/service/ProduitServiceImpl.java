package com.hamilatech.backend.service;

import com.hamilatech.backend.entities.Categorie;
import com.hamilatech.backend.entities.Produit;
import com.hamilatech.backend.exception.ProductRegistrationException;
import com.hamilatech.backend.repository.ProduitRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Classe qui represent les méthodes CRUD.
 */
@AllArgsConstructor
@Service
public class ProduitServiceImpl implements ProduitService{

    @Autowired
    private  ProduitRepository produitRepository;

    /**
     * Méthode pour enregtré un produit
     * @param produit Le produit à enregistré
     */
    @Override
    public void saveProduit(Produit produit) {
        try {
            boolean productExist = !produitRepository.findByNomProduit(produit.getNomProduit()).isEmpty();

            if (productExist){
               throw new ProductRegistrationException("Le produit " + produit.getNomProduit() + "exit dejà.");
            }

            produitRepository.save(produit);

        } catch (Exception e) {
            throw new RuntimeException(
                    "Erreur lors de l'enregistrement du produit : " + e.getMessage()
            );
        }
    }


    /**
     * Méthode pour recupéré tous les produits
     * @return Les produits
     */
    @Override
    public List<Produit> getAllProduits() {

        try {
            List<Produit> produitList = produitRepository.findAll();

            if (produitList.isEmpty()) {
                throw new ProductRegistrationException("Aucun produit trouvé");
            }

            return produitList;
        } catch (Exception e) {
            throw new RuntimeException("Erreur de la récupération des produits : " +e.getMessage());
        }


    }



    /**
     * Méthode pour la mise à jour du produit
     * @param produit Le produit de mise à jour
     * @return Le produit
     */
    @Override
    public Produit updateProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    /**
     * Méthode pour supprimer un produit
     * @param produit Le produit a supprimé
     */
    @Override
    public void deleteProduit(Produit produit) {
        produitRepository.delete(produit);

    }

    /**
     * Méthode pour supprimé un produit par son id
     * @param id a supprimé
     */
    @Override
    public void deleteProduitById(Long id) {
        produitRepository.deleteById(id);

    }

    /**
     * Méthoode pour rétourné un produit par son id
     * @param id du produit
     * @return ID
     */
    @Override
    public Produit getProduit(Long id) {
        return produitRepository.findById(id).get();
    }



    @Override
    public List<Produit> findByNomProduit(String nom) {
        return produitRepository.findByNomProduit(nom);
    }

    @Override
    public List<Produit> findByNomProduitContains(String nom) {
        return produitRepository.findByNomProduitContains(nom);
    }

    @Override
    public List<Produit> findByNomPrix(String nom, Double prix) {
        return produitRepository.findByNomPrix(nom, prix);
    }

    @Override
    public List<Produit> findByCategory(Categorie categorie) {
        return produitRepository.findByCategory(categorie);
    }

    @Override
    public List<Produit> findByOrderByNomProduitAsc() {
        return produitRepository.findByOrderByNomProduitAsc();
    }

    @Override
    public List<Produit> trierProduitsNomPrix() {
        return produitRepository.trierProduitsNomPrix();
    }


}
