import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'searchFilter',
})
export class SearchFilterPipe implements PipeTransform {
  // nomProduit!: string
  transform(list: any[], filterText: string): any {
    console.log('Recherche en cours...............');

    return list
      ? list.filter((item) =>
          item.nomProduit.toLowerCase().includes(filterText)
        )
      : [];
  }
}
