import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Country } from '../models/country.model';
@Injectable({
  providedIn: 'root'
})
export class CountriesAPIService {
  private countriesApiUrl="https://restcountries.com/v3.1/independent?status=true&fields=translations,coatOfArms,flags,flag"
  constructor(private http: HttpClient) { }

  getData():Observable<any[]>{
    return this.http.get<any>(this.countriesApiUrl);
  }
  getCountriesInLanguage(language:string):Observable<Country[]>{ // Country a un attribu name et flag
    return this.http.get<any[]>(this.countriesApiUrl).pipe(
      map(items => items.map(item => {   
        return new Country(item.translations[language].common,item.flags.svg,item.coatOfArms.svg,item.flag);}
      )) // Transforme chaque objet pour ne garder que la propriété `name`
    );
  }
}
