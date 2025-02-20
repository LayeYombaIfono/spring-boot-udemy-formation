import { Injectable } from '@angular/core';
import { Produit } from '../model/produit.model';

@Injectable({
  providedIn: 'root',
})
export class ProduitService {
  produits: Produit[]; //un tableau de Produit
  produit!: Produit;

  // Constructeur
  constructor() {
    this.produits = [
      {
        idProduit: 1,
        nomProduit: 'PC Asus',
        prixProduit: 3000.6,
        dateCreation: new Date('01/14/2011'),
      },
      {
        idProduit: 2,
        nomProduit: 'Imprimante Epson',
        prixProduit: 450,
        dateCreation: new Date('12/17/2010'),
      },
      {
        idProduit: 3,
        nomProduit: 'Tablette Samsung',
        prixProduit: 900.123,
        dateCreation: new Date('02/20/2020'),
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



}
