import { Component } from '@angular/core';
import { Produit } from '../model/produit.model';
import { CurrencyPipe, DatePipe } from '@angular/common';

@Component({
  selector: 'app-produits',
  imports: [DatePipe, CurrencyPipe],
  templateUrl: './produits.component.html',
  styleUrl: './produits.component.css',
})
export class ProduitsComponent {
  produits: Produit[];

  constructor() {
    this.produits = [
      {
        idProduit: 1,
        nomProduit: 'PC Asus',
        prixProduit: 3000000,
        dateCreation: new Date('01/14/2011'),
      },
      {
        idProduit: 2,
        nomProduit: 'Imprimante Epson',
        prixProduit: 15000000,
        dateCreation: new Date('12/17/2010'),
      },
      {
        idProduit: 3,
        nomProduit: 'Tablette Samsung',
        prixProduit: 7000000,
        dateCreation: new Date('02/20/2020'),
      },
      {
        idProduit: 4,
        nomProduit: 'PC Asus',
        prixProduit: 5000000,
        dateCreation: new Date('01/14/2011'),
      },
      {
        idProduit: 5,
        nomProduit: 'PC Asus',
        prixProduit: 5000000,
        dateCreation: new Date('01/14/2011'),
      },
    ];
  }
}
