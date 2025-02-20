import { Routes } from '@angular/router';
import { AddProduitComponent } from './add-produit/add-produit.component';
import { ProduitsComponent } from './produits/produits.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { UpdateProduitComponent } from './update-produit/update-produit.component';

export const routes: Routes = [
  { path: 'produits', component: ProduitsComponent },
  { path: 'addproduit', component: AddProduitComponent },
  {path : 'updateProduit/:id', component: UpdateProduitComponent },
  { path: '', redirectTo: 'produits', pathMatch: 'full' },
  { path: '**', component: PageNotFoundComponent },
];
