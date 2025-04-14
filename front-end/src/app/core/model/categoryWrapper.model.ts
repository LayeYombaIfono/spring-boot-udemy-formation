import { Categorie } from './categorie.model';
export class CategoryWrapper {
  _embedded!: { categories: Categorie[] };
}
