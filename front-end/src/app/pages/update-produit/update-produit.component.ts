import { Component, inject, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { ProduitService } from '../../core/services/produit.service';
import { Produit } from '../../core/model/produit.model';
import { FormsModule } from '@angular/forms';
import { DatePipe } from '@angular/common';
import { Categorie } from '../../core/model/categorie.model';
import { ToolbarComponent } from '../shared/toolbar.component';

@Component({
  selector: 'app-update-produit',
  imports: [FormsModule, DatePipe, ToolbarComponent],
  templateUrl: './update-produit.component.html',
  styles: ``,
})
export default class UpdateProduitComponent implements OnInit {
  currentProduit = new Produit();
  //categories! : Categorie[];
  updatedCatId!: number;

  message: string = 'Le produit a été modifier avec succès !';
  private activatedRoute = inject(ActivatedRoute);
  private router = inject(Router);
  private produitService = inject(ProduitService);

  ngOnInit(): void {
    this.consultProduit();
    // this.categories = this.produitService.listCategorie();
    // this.currentProduit = this.produitService.consultProduit(this.activatedRoute.snapshot.params['id']);
    //this.updatedCatId = this.currentProduit!.categorie!.idCat;
  }

  consultProduit() {
    this.produitService
      .consultProduit(this.activatedRoute.snapshot.params['id'])
      .subscribe((prod) => {
        this.currentProduit = prod;
      });
  }

  updateProduit() {
    // this.currentProduit.categorie = this.produitService.consultCategorie(this.updatedCatId);
    // this.produitService.updateroduit(this.currentProduit);
    this.produitService.updateProduit(this.currentProduit).subscribe((prod) => {
      this.router.navigate(['/']);
    });
  }
}
