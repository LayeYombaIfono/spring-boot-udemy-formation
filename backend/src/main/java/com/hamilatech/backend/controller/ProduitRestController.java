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
    @GetMapping(path ="/all" , produces = APPLICATION_JSON_VALUE)
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
