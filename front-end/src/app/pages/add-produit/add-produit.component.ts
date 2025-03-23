import { Component, inject, OnInit } from '@angular/core';

import { FormsModule } from '@angular/forms';
import { Produit } from '../../core/model/produit.model';
import { ProduitService } from '../../core/services/produit.service';
import { Categorie } from '../../core/model/categorie.model';
import { Router } from '@angular/router';
import { DatePipe } from '@angular/common';
import { ToolbarComponent } from '../shared/toolbar.component';

@Component({
  selector: 'app-add-produit',
  imports: [FormsModule, ToolbarComponent],
  templateUrl: './add-produit.component.html',
  styleUrl: './add-produit.component.css',
  providers: [DatePipe],
})
export default class AddProduitComponent implements OnInit {
  // Déclaration des variables pour le formulaire
  message: string = 'Produit ajouté avec succès !';
  erreur = "Erreur lors de l'ajout du produit";
  newProduit = new Produit();

  // Variables catégorie
  categories!: Categorie[];
  newIdCat!: number;
  newCategorie!: Categorie;

  private produitService = inject(ProduitService);
  private router = inject(Router);
  private datePipe = inject(DatePipe);

  // Initialisation du composant
  ngOnInit(): void {
    // Initialiser la liste des catégories
    //this.categories = this.produitService.listCategorie();
  }

  // Méthode pour ajouter un produit
  addProduit() {
    if (this.newProduit.dateCreation) {
      this.newProduit.dateCreation = this.datePipe.transform(
        this.newProduit.dateCreation,
        'yyyy-MM-dd'
      )!;
    }

    this.produitService.ajouterProduit(this.newProduit).subscribe(
      (prod) => {
        //console.log(prod);
        this.router.navigate(['/']);
      },
      (error) => {
        console.error("Erreur lors de l'ajout du produit", error);
      }
    );
  }
}
