import { Produit } from './../model/produit.model';
import { Component, OnInit } from '@angular/core';
import { DatePipe } from '@angular/common';
import { ProduitService } from '../services/produit.service';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-produits',
  imports: [DatePipe,  RouterLink],
  templateUrl: './produits.component.html',
  styleUrl: './produits.component.css',
})
export class ProduitsComponent implements OnInit {

  produits : Produit[]=[];




  constructor(private produitService : ProduitService) {

  }


  ngOnInit(): void {
    this.produits = this.produitService.listProduit();
  }

  // Supprimer un produit
  deleteProduit(prod: Produit){
    const conf = confirm(`Êtes-vous sûr de vouloir supprimer le produit ${prod.nomProduit} `)
    if (conf) {
      this.produitService.deleteProduit(prod)
    }




  }



}
