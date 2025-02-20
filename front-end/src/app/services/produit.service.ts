import { Injectable } from '@angular/core';
import { Produit } from '../model/produit.model';
import { Categorie } from '../model/categorie.model';

@Injectable({
  providedIn: 'root',
})
export class ProduitService {
  produits: Produit[]; //un tableau de Produit

  categories: Categorie[];

  // Constructeur
  constructor() {
    this.categories = [
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



    ];

    this.produits = [
      {
        idProduit: 1,
        nomProduit: 'PC Asus',
        prixProduit: 3000.6,
        dateCreation: new Date('01/14/2011'),
        categorie : {
            idCat: 1,
            nomCat: 'Ordinateur',
            description: 'Portatif',
        }
      },
      {
        idProduit: 2,
        nomProduit: 'Imprimante Epson',
        prixProduit: 450,
        dateCreation: new Date('12/17/2010'),

        categorie : {
          idCat: 2,
          nomCat: 'Imprimante',
          description: 'Catouches noir',
        }
      },
      {
        idProduit: 3,
        nomProduit: 'Tablette Samsung',
        prixProduit: 900.123,
        dateCreation: new Date('02/20/2020'),
        categorie : {
          idCat: 3,
          nomCat: 'Tablette',
          description: 'Dimenson 150px',
        }
      },
    ];
  }

  // Ajouter un produit
  ajouterProduit(prod: Produit) {
    this.produits.push(prod);
  }

  // Afficher la liste des produits
  listProduit(): Produit[] {
    return this.produits;
  }

  //Supprimer un produit
  deleteProduit(prod: Produit) {
    const index = this.produits.indexOf(prod, 0);
    if (index > -1) {
      this.produits.splice(index, 1);
    }
  }

  // Consulter le produit
  consulProduit(id: number): Produit {
    return this.produits.find((p) => p.idProduit == id)!;
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
  listCategorie():Categorie[]{
    return this.categories;
  }

/**
 * Méthode pour consulter une catégorie par son id
 * @param id Catégorie
 * @returns Catégorie
 */
   consulCategorie(id : number): Categorie{
      return this.categories.find(cat => cat.idCat == id)!;
   }




}
