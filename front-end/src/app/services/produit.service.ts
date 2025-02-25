import { Injectable } from '@angular/core';
import { Produit } from '../model/produit.model';

import { Observable } from 'rxjs';
import {HttpClient, HttpHeaders } from '@angular/common/http';
// import { Categorie } from '../model/categorie.model';


const httpOptions ={
    headers : new HttpHeaders(
      {
        'Content-Type' : 'application/json'
      }
    )
};

@Injectable({
  providedIn: 'root',
})
export class ProduitService {

  apiUrl : string = 'http://localhost:9091/api/products'

  produits!: Produit[]; //un tableau de Produit

 // categories: Categorie[];

  // Constructeur
  constructor( private http : HttpClient) {



    /* this.categories = [
      {
        idCat: 1,
        nomCat: 'Ordinateur',
        description: 'Portatif',
      },


      {
        idCat: 2,
        nomCat: 'Imprimante',
        description: 'Catouches noir',
      },
      {
        idCat: 3,
        nomCat: 'Tablette',
        description: 'Dimenson 150px',
      },
      {
        idCat: 4,
        nomCat: 'Souris',
        description: 'Dimenson 150px',
      },



    ]; */

   /*  this.produits = [
      {
        id: 1,
        nomProduit: 'PC Asus',
        prixProduit: 3000000,
        dateCreation: new Date('01/14/2011'),
        categorie : {
            idCat: 1,
            nomCat: 'Ordinateur',
            description: 'Portatif',
        }
      },
      {
        id: 2,
        nomProduit: 'Imprimante Epson',
        prixProduit: 4500000,
        dateCreation: new Date('12/17/2010'),

        categorie : {
          idCat: 2,
          nomCat: 'Imprimante',
          description: 'Catouches noir',
        }
      },
      {
        id: 3,
        nomProduit: 'Tablette Samsung',
        prixProduit: 900000,
        dateCreation: new Date('02/20/2020'),
        categorie : {
          idCat: 3,
          nomCat: 'Tablette',
          description: 'Dimenson 150px',
        }
      },
      {
        id: 4,
        nomProduit: 'Souris',
        prixProduit: 30000,
        dateCreation: new Date('02/20/2020'),
        categorie : {
          idCat: 4,
          nomCat: 'Souris',
          description: 'Souris sans file',
        }
      }
    ];
    */
  }

  // Ajouter un produit
  ajouterProduit(prod: Produit) {
    this.produits.push(prod);
  }

  // Afficher la liste des produits
  listProduit(): Observable<Produit[]> {
    return this.http.get<Produit[]>(this.apiUrl);
  }

  //Supprimer un produit
  deleteProduit(prod: Produit) {
    const index = this.produits.indexOf(prod, 0);
    if (index > -1) {
      this.produits.splice(index, 1);
    }
  }

  // Consulter le produit
  consultProduit(id: number): Produit {
    return this.produits.find((p) => p.id == id)!;
  }

  // Mise à jour du produit
  updateroduit(prod: Produit) {
    // Rechercher le produit
    const index = this.produits.indexOf(prod, 0);

    if (index > -1) {
      this.produits.splice(index, 1); // Supprimer l'ancien produit
      this.produits.splice(index, 0, prod); // Insérer le nouveau produit
    }
  }


  // Méthodes pour la gestion des catégories
  /**
   *Lister toutes les catégories
   * @returns Catégorie
   */
 /*  listCategorie():Categorie[]{
    return this.categories;
  } */

/**
 * Méthode pour consulter une catégorie par son id
 * @param id Catégorie
 * @returns Catégorie
 */
/*    consultCategorie(id : number): Categorie{
      return this.categories.find(cat => cat.idCat == id)!;
   } */




}
