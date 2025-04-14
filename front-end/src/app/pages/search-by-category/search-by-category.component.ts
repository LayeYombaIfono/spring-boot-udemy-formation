import { Produit } from './../../core/model/produit.model';
import { Categorie } from './../../core/model/categorie.model';
import { Component, OnInit, OnDestroy, inject } from '@angular/core';
import { ToolbarComponent } from '../shared/toolbar.component';
// import { Produit } from '../../core/model/produit.model';
import { FormsModule } from '@angular/forms';
import { Subscription } from 'rxjs';
import { ProduitService } from '../../core/services/produit.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-search-by-category',
  imports: [ToolbarComponent, FormsModule, CommonModule],
  templateUrl: './search-by-category.component.html',
  styles: ``,
})
export default class SearchByCategoryComponent implements OnInit, OnDestroy {
  produits!: Produit[];
  idCategorie!: number;
  Categories!: Categorie[];

  onSubscription!: Subscription;

  private produitService = inject(ProduitService);

  ngOnInit(): void {
    this.loadProducts();
  }

  ngOnDestroy(): void {
    this.loadProducts();
  }

  //  Charger des categories
  loadProducts() {
    this.onSubscription = this.produitService
      .listCategorie()
      .subscribe((cats) => {
        this.Categories = cats._embedded.categories;
        console.log(cats);
      });
  }

  // onChange() {
  //   this.produitService
  //     .searchProductByCategory(this.idCategorie)
  //     .subscribe((res) => {
  //       this.produits = Array.isArray(res) ? res : [res];
  //       console.log(this.produits);
  //     });
  // }
}
