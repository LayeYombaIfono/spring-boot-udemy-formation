import { Subscription } from 'rxjs';
import { Produit } from '../../core/model/produit.model';
import { Component, inject, OnDestroy, OnInit } from '@angular/core';
import { DatePipe } from '@angular/common';
import { ProduitService } from '../../core/services/produit.service';
import { Router, RouterLink } from '@angular/router';
import { ToolbarComponent } from '../shared/toolbar.component';

@Component({
  selector: 'app-produits',
  imports: [DatePipe, RouterLink, ToolbarComponent],
  templateUrl: './produits.component.html',
  styleUrl: './produits.component.css',
})
export default class ProduitsComponent implements OnInit, OnDestroy {
  produits: Produit[] = [];

  private produitService = inject(ProduitService);
  private router = inject(Router);

  onSubscription!: Subscription;

  ngOnInit(): void {
    //this.produits = this.produitService.listProduit();
    this.chargerPrduits();
  }

  ngOnDestroy(): void {
    this.onSubscription;
  }

  // Charger les produits
  chargerPrduits() {
    this.onSubscription = this.produitService
      .listProduit()
      .subscribe((prods) => {
        // console.log(prods);

        this.produits = this.convertDates(prods);
      });
  }

  // Converture les dates dans la liste des produit
  convertDates(produits: Produit[]): Produit[] {
    return produits.map((produit) => {
      return {
        ...produit,
        // dateCreation: this.convertStringToDate(produit.dateCreation as string),
      };
    });
  }

  // Fonction pour convertir une chaîne de caractères en Date
  // convertStringToDate(dateString: string): string {
  //   const [day, month, year] = dateString.split('/');
  //   return `${year}-${month}-${day}`;
  // }

  // Supprimer un produit
  deleteProduit(prod: Produit) {
    const conf = confirm(
      `Êtes-vous sûr de vouloir supprimer le produit ${prod.nomProduit} `
    );
    if (conf) {
      this.produitService.deleteProduit(prod.id).subscribe(() => {
        console.log('Produit supprimer');
        this.chargerPrduits();
        this.router.navigate(['/']);
      });
    }
  }
}
