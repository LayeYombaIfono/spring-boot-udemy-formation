import { Component, inject, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { ProduitService } from '../../core/services/produit.service';
import { Produit } from '../../core/model/produit.model';
import { FormsModule } from '@angular/forms';
import { DatePipe } from '@angular/common';
import { Categorie } from '../../core/model/categorie.model';
import { ToolbarComponent } from '../shared/toolbar.component';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-update-produit',
  imports: [FormsModule, DatePipe, ToolbarComponent],
  templateUrl: './update-produit.component.html',
  styles: ``,
})
export default class UpdateProduitComponent implements OnInit, OnDestroy {
  currentProduit = new Produit();
  categories!: Categorie[];
  updatedCatId!: number;

  message: string = 'Le produit a été modifier avec succès !';
  private activatedRoute = inject(ActivatedRoute);
  private router = inject(Router);
  private produitService = inject(ProduitService);

  onSubscription!: Subscription;

  ngOnInit(): void {
    this.consultProduit();
    this.changingCategories();
  }

  ngOnDestroy(): void {
    this.onSubscription;
  }

  changingCategories() {
    this.onSubscription = this.produitService
      .listCategorie()
      .subscribe((cats) => {
        this.categories = cats;
        console.log(cats);
      });
  }

  consultProduit() {
    this.onSubscription = this.produitService
      .consultProduit(this.activatedRoute.snapshot.params['id'])
      .subscribe((prod) => {
        this.currentProduit = prod;
        this.updatedCatId = this.currentProduit.categorie.idCat;
      });
  }

  updateProduit() {
    this.currentProduit.categorie = this.categories.find(
      (cat) => (cat.idCat = this.updatedCatId)
    )!;
    this.produitService.updateProduit(this.currentProduit).subscribe(() => {
      this.router.navigate(['/']);
    });
  }
}
