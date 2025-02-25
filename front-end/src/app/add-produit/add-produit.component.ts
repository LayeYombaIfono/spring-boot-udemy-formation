import { Component, OnInit } from '@angular/core';

import { FormsModule } from '@angular/forms';
import { Produit } from '../model/produit.model';
import { ProduitService } from '../services/produit.service';
import { Categorie } from '../model/categorie.model';
import { Router } from '@angular/router';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-add-produit',
  imports: [FormsModule],
  templateUrl: './add-produit.component.html',
  styleUrl: './add-produit.component.css',
  providers: [DatePipe]
})
export class AddProduitComponent implements OnInit {
  // Déclaration des variables pour le formulaire
  message: string = 'Produit ajouté avec succès !';

  newProduit = new Produit();

  // Variables catégorie
  categories!: Categorie[];
  newIdCat!: number;
  newCategorie!: Categorie;

  constructor(
    private produitService: ProduitService,
    private router: Router,
    private datePipe: DatePipe
  ) {
    // Injection du service ProduitService
  }

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
        'dd/MM/yyyy'
      )!;
    }

    this.produitService.ajouterProduit(this.newProduit).subscribe(
      (prod) => {
        //console.log(prod);
        this.router.navigate(['produits']);
      },
      (error) => {
        console.error("Erreur lors de l'ajout du produit", error);
      }
    );
  }
}
