import { Categorie } from "./categorie.model";

export class Produit{
    id?: number;
    nomProduit?: string;
    prixProduit?: number;
    dateCreation?: Date | string;
    categorie? : Categorie;
}
