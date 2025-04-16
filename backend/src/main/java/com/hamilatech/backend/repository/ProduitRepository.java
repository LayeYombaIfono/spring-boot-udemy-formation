package com.hamilatech.backend.repository;

import com.hamilatech.backend.entities.Categorie;
import com.hamilatech.backend.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestController(path = "prods")
public interface ProduitRepository extends JpaRepository<Produit, Long> {

   List<Produit> findByNomProduit(String nom);
   List<Produit> findByNomProduitContains(String nom);

//    Trouver le produit par son nom et son prix
    @Query("select p from Produit p where p.nomProduit like %:nom and p.prixProduit > :prix")
    List<Produit> findByNomPrix(@Param("nom") String nom, @Param("prix") Double prix);


//    Trouver le produit par sa catégorie
//    @Query("select p from Produit p where p.categorie = ?1")
//    List<Produit> findByCategorie(Categorie categorie);

//    Trouver des produits par categorie
    @Query("select p from Produit p where p.categorie = ?1")
    List<Produit> findByCategory(Categorie categorie);


//    Methode pour trier des donnees
    List<Produit> findByOrderByNomProduitAsc();

//Trier des produits par odre croissant et les prix par ordre decoissant avec JPA Query
    @Query("select p from Produit p order by p.nomProduit ASC, prixProduit DESC")
    List<Produit>trierProduitsNomPrix();

//    List<Produit> findByCategoryByIdCat(Long id);
}
