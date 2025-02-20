import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { ProduitService } from '../services/produit.service';
import { Produit } from '../model/produit.model';
import { FormsModule } from '@angular/forms';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-update-produit',
  imports: [FormsModule, DatePipe],
  templateUrl: './update-produit.component.html',
  styles: ``,
})
export class UpdateProduitComponent implements OnInit {
  currentProduit = new Produit();

  message: string = 'Le produit a été modifier avec succès !';

  constructor(
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private produitService: ProduitService
  ) {}

  ngOnInit(): void {
      this.currentProduit = this.produitService.consulProduit(
      this.activatedRoute.snapshot.params['id']
    );
  }

  updateProduit() {
    this.produitService.updateroduit(this.currentProduit);
    this.router.navigate(['produits']);
  }
}
