package com.hamilatech.backend.controller;

import com.hamilatech.backend.entities.Produit;
import com.hamilatech.backend.service.ProduitService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping(path = "/products")
public class ProduitRestController {

    @Autowired
    ProduitService produitService;

//    Méthode pour créer un produit
@ResponseStatus(value = HttpStatus.ACCEPTED)
@PostMapping(consumes = APPLICATION_JSON_VALUE)
public void createProduit(@RequestBody Produit produit){
     this.produitService.saveProduit(produit);
}


//   Méthode pour récuperer tout les produit
    @GetMapping( produces = APPLICATION_JSON_VALUE)
   public List<Produit> getAllProduits(){
        return produitService.getAllProduits();
    }

//    Methode pour recuperer un produit par son id
    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public Produit getProduitById(@PathVariable Long id){
        return produitService.getProduitById(id);
    }


// Methode pour modifier le produit
   @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(path = "{id}", consumes = APPLICATION_JSON_VALUE)
    public void updateProduit(@PathVariable Long id,  @RequestBody Produit produit){

        this.produitService.updateProduit(id, produit);

    }




    /**
     *  Methode pour supprimer un produit par id
     * @param id Numéro de produit a supprimé
     */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "{id}")
    public void  deleteProduit(@PathVariable Long id){
        this.produitService.deleteProduitById(id);
    }


    /**
     * Supprimer le produit en founissant l'objet
     * @param produit Produit a supprime
     */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(consumes = APPLICATION_JSON_VALUE)
    public void deleteProduct(@RequestBody Produit produit){
        this.produitService.deleteProduct(produit);
    }

    /**
     * Rechercher les produit par nom
     * @param nom Nom du produit rechercher
     * @return Liste des produit correspondant
     */
    @GetMapping(path = "nom/{nom}", produces = APPLICATION_JSON_VALUE)
    public List<Produit> findProduitByNom(@PathVariable String nom){
        return produitService.findByNomProduit(nom);
    }




}
