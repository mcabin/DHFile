import { Component,ViewEncapsulation } from '@angular/core';
import { Character } from '../../models/character.model';
import {CountriesAPIService} from '../../service/countries-api.service'
import { NgFor } from '@angular/common';
import { Country } from '../../models/country.model';
import { FormsModule } from '@angular/forms';


@Component({
  selector: 'app-personal-information',
  standalone: true,
  imports: [NgFor,FormsModule],
  templateUrl: './personal-information.component.html',
  styleUrl: './personal-information.component.css',
  encapsulation:ViewEncapsulation.Emulated
})
export class PersonalInformationComponent {
  constructor(private apiService: CountriesAPIService) {}
  character:Character=new Character();
  countries!:Country[];
  selectedCountry!:Country;
  ngOnInit():void{
    this.apiService.getCountriesInLanguage("fra").subscribe((item)=>this.countries=item)
    this.countries.sort((a,b)=> a.name.localeCompare((b.name)));
  }
  
}
