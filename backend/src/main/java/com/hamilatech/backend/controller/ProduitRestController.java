package com.hamilatech.backend.controller;

import com.hamilatech.backend.entities.Produit;
import com.hamilatech.backend.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProduitRestController {

    @Autowired
    ProduitService produitService;

//    Méthode pour créer un produit
@RequestMapping(method = RequestMethod.POST)
public Produit createProduit(@RequestBody Produit produit){
    return produitService.saveProduit(produit);
}

//   Méthode pour récuperer tout les produit
    @RequestMapping(method = RequestMethod.GET)
   public List<Produit> getAllProduits(){
        return produitService.getAllProduits();
    }

//    Methode pour recuperer un produit par son id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Produit getProduitById(@PathVariable("id") Long id){
        return produitService.getProduit(id);
    }

// Methode pour modifier le produit
    @RequestMapping(method = RequestMethod.PUT)
    public Produit updateProduit(@RequestBody Produit produit){
        return produitService.updateProduit(produit);
    }


//    Methode pour supprimer un produit
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void  deleteProduit(@PathVariable("id")Long id){
        produitService.deleteProduitById(id);
    }

}
