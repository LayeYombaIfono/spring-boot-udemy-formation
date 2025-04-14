import { Component, inject, OnDestroy, OnInit } from '@angular/core';
import { ToolbarComponent } from '../shared/toolbar.component';
import { Produit } from '../../core/model/produit.model';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ProduitService } from '../../core/services/produit.service';
import { catchError, of, Subscription } from 'rxjs';
import { Categorie } from '../../core/model/categorie.model';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-search-product-by-name',
  imports: [ToolbarComponent, FormsModule, CommonModule],
  templateUrl: './search-product-by-name.component.html',
  styles: ``,
})
export default class SearchProductByNameComponent implements OnInit, OnDestroy {
  produits!: Produit[];
  categories!: Categorie[];

  nomProduit!: string;

  private productService = inject(ProduitService);

  onSubscription!: Subscription;

  ngOnDestroy(): void {
    this.chargingProduct();
  }
  ngOnInit(): void {
    this.chargingProduct();
  }

  // Chargement des produits
  chargingProduct() {
    this.produits = [];
  }

  onSearchProduct() {
    if (this.nomProduit) {
      this.productService
        .searchByProductName(this.nomProduit)
        .pipe(
          catchError((error: HttpErrorResponse) => {
            console.error('Erreur lors de la recherche de produit :', error);
            this.produits = [];

            return of([]);
          })
        )
        .subscribe((res) => {
          this.produits = Array.isArray(res) ? res : [res];
        });
    } else {
      this.onSubscription = this.productService
        .listProduit()
        .subscribe((prods) => {
          this.produits = prods;
        });
    }
  }
}
