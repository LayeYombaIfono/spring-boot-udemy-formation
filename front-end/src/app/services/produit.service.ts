import { Injectable } from '@angular/core';
import { Produit } from '../model/produit.model';

import { Observable } from 'rxjs';
import {HttpClient, HttpHeaders } from '@angular/common/http';
// import { Categorie } from '../model/categorie.model';


const httpOptions ={
    headers : new HttpHeaders(
      {
        'Content-Type' : 'application/json'
      }
    )
};

@Injectable({
  providedIn: 'root',
})
export class ProduitService {

  apiUrl : string = 'http://localhost:9091/api/products'

  produits!: Produit[]; //un tableau de Produit

 // categories: Categorie[];

  // Constructeur
  constructor( private http : HttpClient) {

  }

  // Ajouter un produit
  ajouterProduit(prod: Produit): Observable<Produit> {
     return this.http.post<Produit>(this.apiUrl, prod, httpOptions);
     
     
  }

  // Afficher la liste des produits
  listProduit(): Observable<Produit[]> {
    return this.http.get<Produit[]>(this.apiUrl);
  }

  //Supprimer un produit
  deleteProduit(id: number) {
    const url = `${this.apiUrl}/${id}`;
    return this.http.delete(url, httpOptions);
    
  }

  // Consulter le produit
  consultProduit(id: number): Observable<Produit> {
    const url = `${this.apiUrl}/${id}`;
    return this.http.get<Produit>(url);
  }

  // Mise à jour du produit
  updateProduit(prod: Produit): Observable<Produit> {
    console.log("Produit envoyé pour mise à jour :", prod);
    
     const url = `${this.apiUrl}/${prod.id}`;
      return this.http.put<Produit>(this.apiUrl, prod, httpOptions);
  }
  


  // Méthodes pour la gestion des catégories
  /**
   *Lister toutes les catégories
   * @returns Catégorie
   */
 /*  listCategorie():Categorie[]{
    return this.categories;
  } */

/**
 * Méthode pour consulter une catégorie par son id
 * @param id Catégorie
 * @returns Catégorie
 */
/*    consultCategorie(id : number): Categorie{
      return this.categories.find(cat => cat.idCat == id)!;
   } */




}
