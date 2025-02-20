import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Produit } from '../model/produit.model';
import { ProduitService } from '../services/produit.service';

@Component({
  selector: 'app-add-produit',
  imports: [FormsModule],
  templateUrl: './add-produit.component.html',
  styleUrl: './add-produit.component.css',
})
export class AddProduitComponent implements OnInit {
  // Déclaration des variables pour le formulaire
  message: string = '';

  newProduit = new Produit();
  constructor(private produitService: ProduitService) {
    // Injection du service ProduitService
  }

  ngOnInit(): void {
    // Initialisation du composant
  }

  // Méthode pour ajouter un produit
  addProduit() {
    this.produitService.ajouterProduit(this.newProduit);
    this.message =
      'Produit: ' + this.newProduit.nomProduit + ' ajouté avec succès !';
  }
}
