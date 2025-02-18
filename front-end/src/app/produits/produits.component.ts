import { Component, OnInit } from '@angular/core';
import { Produit } from '../model/produit.model';
import { CurrencyPipe, DatePipe } from '@angular/common';
import { ProduitService } from '../services/produit.service';

@Component({
  selector: 'app-produits',
  imports: [DatePipe, CurrencyPipe],
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




}
