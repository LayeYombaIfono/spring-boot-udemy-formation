import { Month } from './../../../node_modules/date-fns/types.d';
import { Produit } from './../model/produit.model';
import { Component, OnInit } from '@angular/core';
import { DatePipe } from '@angular/common';
import { ProduitService } from '../services/produit.service';
import { RouterLink } from '@angular/router';
import { parse } from 'date-fns';

@Component({
  selector: 'app-produits',
  imports: [DatePipe,  RouterLink],
  templateUrl: './produits.component.html',
  styleUrl: './produits.component.css',
})
export class ProduitsComponent implements OnInit {

  produits : Produit[]=[];



  constructor(private produitService : ProduitService) {}


  ngOnInit(): void {
    //this.produits = this.produitService.listProduit();

    this.produitService.listProduit().subscribe( prods =>{
        console.log(prods);
        this.produits = this.convertDates(prods);
    })
  }

  // Converture les dates dans la liste des produit
  convertDates(produits : Produit[]) : Produit[]{
    return produits.map(produit => {
      return {
        ...produit, dateCreation: this.convertStringToDate(produit.dateCreation as string)
      };
    });
  }

  // Fonction pour convertir une chaîne de caractères en Date
  convertStringToDate(dateString : string): Date{
    const [day, month, year] = dateString.split('/');
    return new Date (`${year}-${month}-${day}`);
  }

  // Supprimer un produit
  deleteProduit(prod: Produit){
    const conf = confirm(`Êtes-vous sûr de vouloir supprimer le produit ${prod.nomProduit} `)
    if (conf) {
      this.produitService.deleteProduit(prod)
    }




  }



}
