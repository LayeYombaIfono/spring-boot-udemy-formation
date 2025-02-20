import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Produit } from '../model/produit.model';
import { ProduitService } from '../services/produit.service';
import { Categorie } from '../model/categorie.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-produit',
  imports: [FormsModule],
  templateUrl: './add-produit.component.html',
  styleUrl: './add-produit.component.css',
})
export class AddProduitComponent implements OnInit {
  // Déclaration des variables pour le formulaire
  message: string = "Produit ajouté avec succès !";

  newProduit = new Produit();

  // Variables catégorie
  categories! : Categorie[];
  newIdCat! : number;
  newCategorie! : Categorie;

  constructor(private produitService: ProduitService, private router : Router) {
    // Injection du service ProduitService
  }


// Initialisation du composant
  ngOnInit(): void {
    // Initialiser la liste des catégories
    this.categories = this.produitService.listCategorie();
  }

  // Méthode pour ajouter un produit
  addProduit() {

    // Ajouter la catégorie
    this.newCategorie = this.produitService.consulCategorie(this.newIdCat);
    this.newProduit.categorie = this.newCategorie;

    //Ajouter le produit
    this.produitService.ajouterProduit(this.newProduit);
    this.router.navigate(['produits']);


  }


}
