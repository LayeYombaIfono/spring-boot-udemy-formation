import { Routes } from '@angular/router';

export const routes: Routes = [
  // { path: 'produits', component: ProduitsComponent },
  {
    path: '',
    title: 'Produits',
    loadComponent: () => import('./pages/produits/produits.component'),
  },

  // { path: 'addproduit', component: AddProduitComponent },
  {
    path: 'add-produit',
    title: 'Enregistrement des produits',
    loadComponent: () => import('./pages/add-produit/add-produit.component'),
  },

  // {path : 'updateProduit/:id', component: UpdateProduitComponent },

  {
    path: 'updateProduit/:id',
    loadComponent: () =>
      import('./pages/update-produit/update-produit.component'),
  },

  {
    path: 'search-category',
    title: 'Recherche par categorie',
    loadComponent: () =>
      import('./pages/search-by-category/search-by-category.component'),
  },

  { path: '', redirectTo: 'produits', pathMatch: 'full' },

  {
    path: '404',
    title: 'Page-not-found',
    loadComponent: () =>
      import('./pages/page-not-found/page-not-found.component'),
  },

  { path: '**', redirectTo: '404' },
];
