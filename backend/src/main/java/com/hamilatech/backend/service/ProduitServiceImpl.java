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
     * Méthode pour la mise à jour du produit
     * @param id Produit
     * @param produit nom du produit
     */
    @Override
    public void updateProduit(Long id, Produit produit) {
        try {
//            Verifier si le produit exist avec id
            Produit product = this.produitRepository.getReferenceById(id);

//            Verifier si le produit est deja enregistrer
            boolean produitExist = produitRepository.findByNomProduit(produit.getNomProduit())
                    .stream()
                    .anyMatch(r -> !r.getId().equals(id));

            if (produitExist){
                throw new ProductRegistrationException("Le produit "+produit.getNomProduit()+ " exist deja .");
            }

            //Mettre a jour des informations du produit
            product.setNomProduit(produit.getNomProduit());
            product.setPrixProduit(produit.getPrixProduit());
            product.setDateCreation(product.getDateCreation());
            product.setCategorie(product.getCategorie());

            // Sauvegarder le produit mise a jour
            produitRepository.save(produit);
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la mise a jour du produit : " +e.getMessage());
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
     * Méthoode pour rétourné un produit par son id
     * @param id du produit
     * @return ID
     */
    @Override
    public Produit getProduitById(Long id) {
        return produitRepository.findById(id)
                .orElseThrow(()-> new ProductRegistrationException("Aucun produit n'existe avec cet ID "+ id));
    }




    /**
     * Méthode pour supprimé un produit par son id
     * @param id a supprimé
     */
    @Override
    public void deleteProduitById(Long id) {

        try {
            //Verifier si le produit exit avant suppression
            this.getProduitById(id);
            //Supprimer le produit
            produitRepository.deleteById(id);

        } catch (ProductRegistrationException e) {
            throw new RuntimeException("Erreur lors de la suppression du produit : "+e.getMessage());
        }

    }

    /**
     * Méthode pour supprimer un produit
     * @param produit Le produit a supprimé
     */
    @Override
    public void deleteProduit(Produit produit) {
        produitRepository.delete(produit);

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
