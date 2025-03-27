import { Component, inject, OnDestroy, OnInit } from '@angular/core';

import { FormsModule } from '@angular/forms';
import { Produit } from '../../core/model/produit.model';
import { ProduitService } from '../../core/services/produit.service';
import { Categorie } from '../../core/model/categorie.model';
import { Router } from '@angular/router';
import { DatePipe } from '@angular/common';
import { ToolbarComponent } from '../shared/toolbar.component';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-add-produit',
  imports: [FormsModule, ToolbarComponent],
  templateUrl: './add-produit.component.html',
  styleUrl: './add-produit.component.css',
  providers: [DatePipe],
})
export default class AddProduitComponent implements OnInit, OnDestroy {
  // Déclaration des variables pour le formulaire
  message: string = 'Produit ajouté avec succès !';
  erreur = "Erreur lors de l'ajout du produit";
  newProduit = new Produit();

  // Variables catégorie
  categories!: Categorie[];
  newIdCat!: number;
  newCategorie!: Categorie;

  onSubscription!: Subscription;

  private produitService = inject(ProduitService);
  private router = inject(Router);
  private datePipe = inject(DatePipe);

  // Initialisation du composant
  ngOnInit(): void {
    this.chargingCategories();
  }

  ngOnDestroy(): void {
    this.onSubscription;
  }

  // Charger des categories
  chargingCategories() {
    this.onSubscription = this.produitService
      .listCategorie()
      .subscribe((cats) => {
        this.categories = cats;
        // console.log(cats);
      });
  }

  // Méthode pour ajouter un produit
  addProduit() {
    if (this.newProduit.dateCreation) {
      this.newProduit.dateCreation = this.datePipe.transform(
        this.newProduit.dateCreation,
        'yyyy-MM-dd'
      )!;
    }

    this.newProduit.categorie = this.categories.find(
      (cat) => cat.idCat == this.newIdCat
    )!;
    this.produitService.ajouterProduit(this.newProduit).subscribe(
      (prod) => {
        // console.log('Produit ajoutes avec succes' + prod);
        this.router.navigate(['/']);
      },
      (error) => {
        console.error("Erreur lors de l'ajout du produit", error);
      }
    );
  }
}
